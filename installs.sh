#!/bin/bash

# Exit immediately if a command exits with a non-zero status.
set -e

# --- Configuration ---
# This variable must match the JAR file name used in the Makefile
ANTLR_JAR="antlr-4.13.2-complete.jar"

# --- Helper Functions for Colored Output ---
print_success() {
    echo -e "\e[32m[SUCCESS]\e[0m $1"
}

print_info() {
    echo -e "\e[34m[INFO]\e[0m $1"
}

print_error() {
    echo -e "\e[31m[ERROR]\e[0m $1" >&2
    exit 1
}

# --- 1. Dependency Checks ---
print_info "Checking for required dependencies..."

# Check for Java Compiler (JDK)
if ! command -v javac &> /dev/null; then
    print_error "Java Development Kit (javac) not found. Please install a JDK."
fi

# Check for Python 3
if ! command -v python3 &> /dev/null; then
    print_error "Python 3 not found. Please install Python 3."
fi

# Check for Pip 3
if ! command -v pip3 &> /dev/null; then
    print_error "pip3 not found. Please install the Python package manager."
fi

# Check for ANTLR Jar file
if [ ! -f "$ANTLR_JAR" ]; then
    print_error "ANTLR jar file ('$ANTLR_JAR') not found. Please download it from antlr.org and place it in the project directory."
fi

print_success "All required tools are available."

# --- 2. Build Project (Commands from Makefile) ---
print_info "Building project..."

# Generate ANTLR Parser from ToyLang.g4
print_info "Generating parser from ToyLang.g4..."
java -jar "$ANTLR_JAR" -no-listener -visitor ToyLang.g4

# Compile Java source files
print_info "Compiling Java source files..."
javac -cp ".:$ANTLR_JAR" *.java

print_success "Java project built successfully."

# --- 3. Install Python Dependencies ---
# This step is from the original script and is good practice for users.
if [ -f "requirements.txt" ]; then
    print_info "Installing Python dependencies from requirements.txt..."
    pip3 install -r requirements.txt
    print_success "Python dependencies installed."
else
    print_info "No requirements.txt found, skipping Python dependency installation."
fi

echo -e "\n\e[1;32mInstallation complete! You can now
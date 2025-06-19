#!/bin/bash

# Exit immediately if a command exits with a non-zero status.
set -e

print_success() {
    echo -e "\e[32m[SUCCESS]\e[0m $1"
}

print_info() {
    echo -e "\e[34m[INFO]\e[0m $1"
}

# --- Configuration ---
# This variable must match the JAR file name used in the Makefile
ANTLR_JAR="antlr-4.13.2-complete.jar"

# --- 2. Build Project (Commands from Makefile) ---
print_info "Building project..."

# Generate ANTLR Parser from ToyLang.g4
print_info "Generating parser from ToyLang.g4..."
java -jar "$ANTLR_JAR" -no-listener -visitor ToyLang.g4

# Compile Java source files
print_info "Compiling Java source files..."
javac -cp ".:$ANTLR_JAR" *.java

print_success "Java project built successfully."


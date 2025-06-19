#!/bin/bash

# Exit immediately if a command exits with a non-zero status.
set -e


# --- Configuration ---
# This variable must match the JAR file name used in the Makefile
ANTLR_JAR="antlr-4.13.2-complete.jar"
MAIN_CLASS="Main"

# Run the Java interpreter with the provided script
# This is the generic version of the run command from the Makefile
java -cp ".:$ANTLR_JAR" "$MAIN_CLASS" test.toy > plots/results_short_lived.log
python3 analyze_results.py plots/results_short_lived.log
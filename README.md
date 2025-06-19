# ToyLang Garbage Collector

This project is an implementation of a garbage collector for a simple, JavaScript-like language called ToyLang. It features a mark-and-sweep garbage collector and includes a suite of benchmarks and analysis scripts to evaluate its performance.

## Prerequisites

Before you begin, ensure you have the following tools installed on your system (Linux or macOS):

- **Java Development Kit (JDK)**: Required to compile and run the interpreter. You can check if you have it with `javac --version`.
- **Python 3**: Required for running the analysis scripts. You can check with `python3 --version`.
- **pip3**: The package installer for Python, used to install dependencies.
- **ANTLR v4.13.2 JAR**: The ANTLR parser generator library. The project expects the file `antlr-4.13.2-complete.jar` to be in the root directory.

## Installation

A setup script is provided to compile the project and install all necessary dependencies.

1.  **Make the script executable:**

    ```bash
    chmod +x installs.sh
    ```

2.  **Run the installation script:**

    ```bash
    ./installs.sh
    ```

This script will:

- Verify that all prerequisite tools are available.
- Generate the Java parser and lexer from `ToyLang.g4` using ANTLR.
- Compile all Java source files (`.java` -> `.class`).
- Install the required Python packages (`pandas`, `matplotlib`, `numpy`) using the `requirements.txt` file.

1.  **Make the compile executable:**

    ```bash
    chmod +x compile.sh

    ```

2.  **Run the compile script:**
    ```bash
    ./compile.sh
    ```

This script will:

- Compile all Java source files (`.java` -> `.class`).

## How to Run

The project includes a simple script to execute a default benchmark and generate an analysis.

1.  **Make the run script executable:**

    ```bash
    chmod +x run.sh
    ```

2.  **Execute the script:**
    ```bash
    ./run.sh
    ```
    This specific script will:
    - Run the interpreter on the `test.toy` file.
    - Save the benchmark output to `plots/results_short_lived.log`.
    - Automatically run `analyze_results.py` on the log file to generate plots in the `plots/` directory.

## Running Custom Benchmarks and Analysis

To get the most out of the project, you can run any of the provided benchmarks and generate custom reports.

#### Step 1: Run a Benchmark

Execute the Java interpreter, specifying a benchmark file. It's important to redirect the output (`>`) to a log file for analysis.

```bash
# Create a directory for logs if it doesn't exist
mkdir -p logs

# Run a specific benchmark and save its output
java -cp ".:antlr-4.13.2-complete.jar" Main benchmarks/long_lived_benchmark.toy > logs/long_lived.log
```

#### Step 2: Analyze the Results

Use the provided Python scripts to process the log files.

- **To generate plots:**

  ```bash
  python3 analyze_results.py logs/long_lived.log
  ```

  This will create PNG plot images in the `plots/` directory.

- **To generate a comparative Excel report from multiple runs:**

  ```bash
  # Create a directory for reports
  mkdir -p reports

  # Run the script on all log files in the 'logs' directory
  python3 generate_excel_report.py logs/*.log -o reports/full_benchmark_report.xlsx
  ```

## Cleaning the Workspace

A `Makefile` is included with a `clean` command to remove all generated files, including compiled classes, logs, and plots.

```bash
make clean
```

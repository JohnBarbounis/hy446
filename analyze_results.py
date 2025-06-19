import re
import argparse
import pandas as pd
import matplotlib.pyplot as plt
import os
import numpy as np

def parse_log_file(filepath):
    """Parses the benchmark log file to extract GC metrics."""
    pauses_ms = []
    collected_objects = []
    summary_data = {}

    # Regex patterns to find specific benchmark lines
    pause_pattern = re.compile(r"Paused for [,\d]+ ns \(([\d.]+) ms\). Collected (\d+) objects.")
    summary_start_pattern = re.compile(r"--- Benchmark Summary ---")
    total_time_pattern = re.compile(r"Total time spent in Garbage Collection: .* \(([\d.]+) ms\)")
    runs_pattern = re.compile(r"GC Runs: (\d+)")
    avg_pause_pattern = re.compile(r"Average Pause: ([\d.]+) ms")
    max_pause_pattern = re.compile(r"Max Pause: ([\d.]+) ms")
    min_pause_pattern = re.compile(r"Min Pause: ([\d.]+) ms")
    throughput_pattern = re.compile(r"Application Throughput: ([\d.]+)%")

    in_summary_section = False

    try:
        with open(filepath, 'r') as f:
            for line in f:
                # Find individual GC pause data
                match = pause_pattern.search(line)
                if match:
                    pauses_ms.append(float(match.group(1)))
                    collected_objects.append(int(match.group(2)))
                    continue

                # Check if we entered the summary section
                if summary_start_pattern.search(line):
                    in_summary_section = True
                    continue

                if in_summary_section:
                    match = total_time_pattern.search(line)
                    if match:
                        summary_data['Total GC Time (ms)'] = float(match.group(1))
                        continue
                    match = runs_pattern.search(line)
                    if match:
                        summary_data['GC Runs'] = int(match.group(1))
                        continue
                    match = avg_pause_pattern.search(line)
                    if match:
                        summary_data['Average Pause (ms)'] = float(match.group(1))
                        continue
                    match = max_pause_pattern.search(line)
                    if match:
                        summary_data['Max Pause (ms)'] = float(match.group(1))
                        continue
                    match = min_pause_pattern.search(line)
                    if match:
                        summary_data['Min Pause (ms)'] = float(match.group(1))
                        continue
                    match = throughput_pattern.search(line)
                    if match:
                        summary_data['Throughput (%)'] = float(match.group(1))
                        continue

    except FileNotFoundError:
        print(f"Error: File not found at {filepath}")
        return None, None, None

    return pauses_ms, collected_objects, summary_data


def create_summary_table(summary_data, filename):
    # ...existing code...
    # (No changes needed in this function)
    """Creates and prints a summary table using pandas."""
    if not summary_data:
        print("No summary data found to create a table.")
        return

    # Create a DataFrame for better formatting
    df = pd.DataFrame.from_dict(summary_data, orient='index', columns=['Value'])
    df.index.name = 'Metric'
    print(f"\n--- Benchmark Summary for {filename} ---")
    print(df)
    print("-" * (30 + len(filename)))


def create_plots(pauses_ms, collected_objects, output_prefix):
    """Creates and saves plots for GC performance analysis."""
    if not pauses_ms:
        print("No GC pause data found to create plots.")
        return

    plots_dir = 'plots'
    os.makedirs(plots_dir, exist_ok=True)

    # Plot 1: GC Pause Durations over Time
    plt.figure(figsize=(10, 6))
    plt.plot(range(1, len(pauses_ms) + 1), pauses_ms, marker='o', linestyle='-', color='b')
    plt.title(f'GC Pause Duration per Run ({output_prefix})')
    plt.xlabel('GC Run Number')
    plt.ylabel('Pause Duration (ms)')
    plt.grid(True)
    plot1_filename = os.path.join(plots_dir, f"{output_prefix}_pauses_over_time.png")
    plt.savefig(plot1_filename)
    print(f"Saved plot: {plot1_filename}")
    plt.close()

    # Plot 2: Histogram of GC Pause Durations
    plt.figure(figsize=(10, 6))
    plt.hist(pauses_ms, bins=15, color='c', edgecolor='black')
    plt.title(f'Distribution of GC Pause Durations ({output_prefix})')
    plt.xlabel('Pause Duration (ms)')
    plt.ylabel('Frequency')
    plt.grid(axis='y', alpha=0.75)
    plot2_filename = os.path.join(plots_dir, f"{output_prefix}_pauses_histogram.png")
    plt.savefig(plot2_filename)
    print(f"Saved plot: {plot2_filename}")
    plt.close()

    # --- NEW PLOT ---
    # Plot 3: GC Efficiency Scatter Plot
    plt.figure(figsize=(10, 6))
    plt.scatter(collected_objects, pauses_ms, alpha=0.7, color='purple')
    plt.title(f'GC Efficiency: Pause vs. Objects Collected ({output_prefix})')
    plt.xlabel('Number of Objects Collected')
    plt.ylabel('Pause Duration (ms)')
    plt.grid(True)
    plot3_filename = os.path.join(plots_dir, f"{output_prefix}_efficiency_scatter.png")
    plt.savefig(plot3_filename)
    print(f"Saved plot: {plot3_filename}")
    plt.close()


def create_comparative_plots(all_summaries, plots_dir):
    """Creates plots comparing metrics across multiple benchmark runs."""
    if len(all_summaries) < 2:
        return # Not enough data to compare

    df = pd.DataFrame(all_summaries)
    df = df.set_index('name')

    # --- NEW TABLE ---
    print("\n--- Comparative Benchmark Summary ---")
    print(df.to_string(float_format="%.2f"))
    print("-" * 40)

    # --- NEW PLOT ---
    # Grouped Bar Chart for Throughput
    df['Throughput (%)'].plot(kind='bar', figsize=(10, 7), color=['#1f77b4', '#ff7f0e', '#2ca02c'])
    plt.title('Application Throughput Comparison')
    plt.ylabel('Throughput (%)')
    plt.xlabel('Benchmark Name')
    plt.xticks(rotation=0)
    plt.grid(axis='y', linestyle='--', alpha=0.7)
    plt.tight_layout()
    comp_plot1 = os.path.join(plots_dir, "comparative_throughput.png")
    plt.savefig(comp_plot1)
    print(f"Saved plot: {comp_plot1}")
    plt.close()

    # --- NEW PLOT ---
    # Grouped Bar Chart for Max Pause Time
    df['Max Pause (ms)'].plot(kind='bar', figsize=(10, 7), color=['#d62728', '#9467bd', '#8c564b'])
    plt.title('Maximum GC Pause Time Comparison')
    plt.ylabel('Max Pause (ms)')
    plt.xlabel('Benchmark Name')
    plt.xticks(rotation=0)
    plt.grid(axis='y', linestyle='--', alpha=0.7)
    plt.tight_layout()
    comp_plot2 = os.path.join(plots_dir, "comparative_max_pause.png")
    plt.savefig(comp_plot2)
    print(f"Saved plot: {comp_plot2}")
    plt.close()


def main():
    """Main function to parse arguments and run the analysis."""
    parser = argparse.ArgumentParser(description="Analyze ToyLang GC benchmark logs.")
    parser.add_argument("logfiles", nargs='+', help="Path to one or more log files to analyze.")
    args = parser.parse_args()

    all_summaries = []
    plots_dir = 'plots'

    for logfile in args.logfiles:
        log_filename = os.path.basename(logfile)
        output_prefix = os.path.splitext(log_filename)[0]

        pauses, objects, summary = parse_log_file(logfile)

        if pauses is not None:
            create_summary_table(summary, log_filename)
            create_plots(pauses, objects, output_prefix)
            summary['name'] = output_prefix
            all_summaries.append(summary)

    if len(all_summaries) > 0:
        create_comparative_plots(all_summaries, plots_dir)


if __name__ == "__main__":
    main()
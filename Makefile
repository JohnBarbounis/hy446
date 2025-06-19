clean:
	rm -f *.class
	rm -f ToyLang.interp
	rm -f ToyLang.tokens
	rm -f ToyLangParser.java
	rm -f ToyLangLexer.java
	rm -f ToyLangLexer.interp
	rm -f ToyLangLexer.tokens
	rm -f plots/results_short_lived.log
	rm -f plots/results_short_lived_efficiency_scatter.png
	rm -f plots/results_short_lived_pauses_histogram.png
	rm -f plots/results_short_lived_pauses_over_time.png
	rm -r venv
	rm -r .venv



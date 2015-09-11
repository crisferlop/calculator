compile: clean
	rm -rf compile
	javac src/calculator/*.java
	mkdir calculator
	mv src/calculator/*.class calculator
	touch MANIFEST.MF
	echo 'MAIN-CLASS: calculator.Calculator' >> MANIFEST.MF
	jar -cfmv CalculatorGUI.jar MANIFEST.MF *
	touch MANIFEST.MF
	echo 'MAIN-CLASS: calculator.poli' >> MANIFEST.MF
	jar -cfmv poli.jar MANIFEST.MF *
	chmod +x poli.jar
	chmod +x CalculatorGUI.jar
	mkdir compile
	mv calculator compile
	rm MANIFEST.MF
clean:
	rm -rf compile
	rm -rf calculator
	rm -rf *.jar

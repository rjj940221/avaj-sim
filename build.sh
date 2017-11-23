find . -name "*.java" > sources.txt
if test ! -d build; then mkdir build; fi    
javac -d build -sourcepath src @sources.txt   
java -cp build com.wtc.avaj.simulator.Simulator scenario.txt
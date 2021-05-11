JFLAGS = -g
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
		  Main.java \
		  Rover.java \
		  Coordonee.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
	
run:
	java Main file.tkt
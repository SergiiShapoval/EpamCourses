package ua.epam.sergiishapoval.testprep.stacktrace.first;

/**
 * Created by Сергей on 24.10.2014.
 * Exception in thread "main" java.lang.IllegalArgumentException
 * at stacktrace.Class2.call(JavaSTSimulator.java:27)
 * at stacktrace.Classl.call(JavaSTSimulator.java:18)
 * at stacktrace.JavaSTSimulator.main(JavaSTSimulator.java:36)
 * Java Result: 1
 */
public class JavaSTSimulator {

    public static void main(String[] args) {
        new Classl().call();

    }
}

class Classl{
    void call(){
        new Class2().call();
    }

}

class Class2{
    void call(){
        throw new IllegalArgumentException();
    }
}

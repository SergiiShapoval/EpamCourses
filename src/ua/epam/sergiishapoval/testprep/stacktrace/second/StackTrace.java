package ua.epam.sergiishapoval.testprep.stacktrace.second;

/**
 * Created by Сергей on 24.10.2014.
 * Exception in thread "main" java.lang.RuntimeException
 * at stacktrace.StackTrace$FirstNested$SecondNested. <init>{StackTrace.java: 19)
 * at stacktrace.StackTrace$FirstNested. <init>{StackTrace.java:24),
 * at stacktrace.StackTrace.<init>{StackTrace.java:29)
 * at stacktrace.StackTrace.main{StackTrace.java:34)
 * Java Result: 1
 */
public class StackTrace {
    class FirstNested {
        class SecondNested{
            SecondNested() {


                throw new RuntimeException();
            }
        }

        FirstNested() {
            new SecondNested();
        }
    }

    public StackTrace() {
        new FirstNested();
    }

    public static void main(String[] args) {
        new StackTrace();
    }
}

package ua.epam.sergiishapoval.lecturescodeonsite.lecture10112014;

/**
 * Created by Сергей on 10.11.2014.
 */
public class IllegalMonitorTest {

    static Object o = new Object();

    public static void main(String[] args) {
        o.notify();
    }
}

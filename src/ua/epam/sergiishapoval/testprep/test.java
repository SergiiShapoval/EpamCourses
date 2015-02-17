package ua.epam.sergiishapoval.testprep;

import ua.epam.sergiishapoval.homework.hw14.MyNonBlockingQueue;

/**
 * Created by Сергей on 20.11.2014.
 */
public class test {
    public static void main(String[] args) {
        Object t = null;
        MyNonBlockingQueue queue = (MyNonBlockingQueue) t;
        t.getClass();
        System.out.println(t.getClass());
        System.out.println(queue instanceof Object);
    }
}

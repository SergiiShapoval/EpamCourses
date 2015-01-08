package ua.epam.sergiishapoval.lecturescodeonsite.lecture21112014;

/**
 * Created by Сергей on 21.11.2014.
 */

class Singleton{
    private static Singleton instance;

    private Singleton() {
    }

    public static synchronized Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;

    }
}


public class MySingleton {
}



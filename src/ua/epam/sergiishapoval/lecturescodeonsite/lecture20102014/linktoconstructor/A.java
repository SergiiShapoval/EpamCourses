package ua.epam.sergiishapoval.lecturescodeonsite.lecture20102014.linktoconstructor;

/**
 * Created by Сергей on 23.10.2014.
 */
public class A {
    int x;
    public A(){
        this.x=100;
        int g = 2/0;
    }
    public int getX(){
        return this.x;
    }

}

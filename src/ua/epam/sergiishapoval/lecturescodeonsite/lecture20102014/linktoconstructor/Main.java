package ua.epam.sergiishapoval.lecturescodeonsite.lecture20102014.linktoconstructor;


/**
 * Created by Сергей on 23.10.2014.
 */
public class Main {
    public static void  f(MyInterface m){
        A mm=m.func();
        System.out.println(mm.getX());
    }
    public static void main(String[] args) {
//        f(A::new);
        double[][] identityMatrix = {
                { 1.0, 0.0, 0.0, 0.0 },
                { 0.0, 1.0, 0.0},
                { 0.0, 0.0, 1.0, 0.0 },
                { 0.0 }, };


    }



}

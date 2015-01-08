package ua.epam.sergiishapoval.lecturescodeonsite.lecture20102014.lambda3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Сергей on 23.10.2014.
 */
public class Main {
    /*
        public static void main(String[] args) {
            MyInterface m=p->{return p.getA();};
            A pa=new A();
            pa.a=200;
            System.out.println(m.func(pa));
        }
    */

    /*
    static int b=100;
    public static void main(String[] args) {
        int c=30;
        MyInterface m=p->{return p.getA()+b+c;};  //correct
        A pa=new A();
        pa.a=200;
        System.out.println(m.func(pa));
    }
    */

    static int b=100;
    public static void main(String[] args) {
        int c=30;
        B pb=new B();
//        MyInterface m=B::mymethod2;
        A pa=new A();
        pa.a=200;
//        System.out.println(m.func(pa));


        String[] stringArray = { "Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda" };
//        Arrays.sort(stringArray, String::compareToIgnoreCase);


    }


}

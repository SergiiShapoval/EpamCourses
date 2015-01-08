package ua.epam.sergiishapoval.lecturescodeonsite.lecture08122014;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * Created by Сергей on 08.12.2014.
 */


class A{}
class B extends A{}
class B1 extends A{}
class B2 extends A{}
class C2 extends B{}
class C1 extends B{}

public class GenericCheck {

    static void print(Long i){
        System.out.println(1);
    }
    static void print(Object i){
        System.out.println(2);
    }
    static void print(Object... i){
        System.out.println(3);
    }
    static void print(long[] i){
        System.out.println(4);
    }
    static void print(Integer ... i){
        System.out.println(5);
    }
    static void print(Number ... i){
        System.out.println(6);
    }

    public static void main(String[] args) {
//        List<A> list = Arrays.asList(new B(), new B1(), new B2());
//        List<A> list2 = Arrays.asList(new C1(), new C2());

        print(new int[]{1,2,3});
        print(new Long[]{1l,2l,3l});

        Double d = 1.56D;

    }
}

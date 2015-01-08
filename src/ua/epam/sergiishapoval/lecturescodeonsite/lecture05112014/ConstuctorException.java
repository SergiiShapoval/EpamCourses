package ua.epam.sergiishapoval.lecturescodeonsite.lecture05112014;

/**
 * Created by Сергей on 05.11.2014.
 */

class A{
    public static A pa;
    public A() throws Exception{
        pa=this;
        throw new Exception();
    }
}

public class ConstuctorException {

    public static void main(String[] args) {

        A a = null;
        try{
            a = new A();
        }catch(Exception e){

        }

        System.out.println(A.pa);

    }



}

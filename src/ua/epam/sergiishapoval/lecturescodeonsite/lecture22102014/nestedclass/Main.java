package ua.epam.sergiishapoval.lecturescodeonsite.lecture22102014.nestedclass;

/**
 * Created by Сергей on 23.10.2014.
 */
public class Main {
    public static void main(String[] args) {
        final int a = 10;
        int c = 20;
        class A {
            public void func() {
                int b = a; //верно, a имеет final
//                b = c; //error
            }

            ;


        }
    }
}

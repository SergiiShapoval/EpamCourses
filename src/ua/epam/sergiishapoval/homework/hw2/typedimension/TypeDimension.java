package ua.epam.sergiishapoval.homework.hw2.typedimension;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергей on 21.10.2014.
 */
public class TypeDimension {

    public static void main(String[] args) {


        int counter;
/*
        boolean bool = true;
        boolean bool1 = true;
        do {
            bool <<= 1;
        } while (!bool );
*/

        counter = 0;
        byte bait = 13;
        byte antibait = (byte) ~bait;
        byte sumBait = (byte) (bait | antibait);
        do {
            sumBait <<=1;
            counter++;
        } while (sumBait != 0 );
        System.out.printf("Byte type needs %d bytes", counter / 8);
        System.out.println();


        counter = 0;
        short sh = 13;
        short antiSh = (short) ~sh;
        short sumSh = (short) (sh | antiSh);
        do {
            sumSh <<=1;
            counter++;
        } while (sumSh != 0 );
        System.out.printf("Short type needs %d bytes", counter / 8);
        System.out.println();


        counter = 0;
        int i = 13;
        int antiI = (int) ~i;
        int sumI = (int) (i | antiI);
        do {
            sumI <<=1;
            counter++;
        } while (sumI != 0 );
        System.out.printf("Int type needs %d bytes", counter / 8);
        System.out.println();


        counter = 0;
        long l = 13;
        long antiL = (long) ~l;
        long sumL = (long) (l | antiL);
        do {
            sumL <<=1;
            counter++;
        } while (sumL != 0 );
        System.out.printf("Long type needs %d bytes", counter / 8);
        System.out.println();


        counter = 0;
        char c = 'd';
        char antiC = (char) ~c;
        char sumC = (char) (c | antiC);
        do {
            sumC <<=1;
            counter++;
        } while (sumC != 0 );
        System.out.printf("Char type needs %d bytes", counter / 8);
        System.out.println();



        




/*
        counter = 0;
        float f = (float) (-Float.MAX_VALUE*Math.random());
        float fCopy = f;
        do {
            f <<= 1;
            counter++;
        } while (f != fCopy );
        System.out.println(counter);
*/

/*
        counter = 0;
        double d = Double.MAX_VALUE*Math.random();
        double dCopy = d;
        do {
            d <<= 1;
            counter++;
        } while (d != dCopy );
        System.out.println(counter);
*/

/*
        counter = 0;
        char c = (char) (65535*Math.random());
        char cCopy = c;
        do {
            c <<= 1;
            counter++;
        } while (c != cCopy );
        System.out.println(counter);
*/




    }


}

package ua.epam.sergiishapoval.homework.hw2.bitchange;

/**
 * Created by Сергей on 21.10.2014.
 * 3.	Написать функцию, которая выставляет бит номер pos
 * в значение 1 или 0.
 * Т.е. реализовать функцию void f(int a, int pos, boolean flag).
 * Если flag=true, то необходимо в a выставить бит pos в значение 1.
 * Если flag=false, выставить бит в значение 0.
 */
public class ChangeBit {

    public static void main(String[] args) {

        int a = 8;
        System.out.println(Integer.toBinaryString(a));
        a = changeF(a, 11, true);
        System.out.println(Integer.toBinaryString(a));

    }

    private static int changeF(int a, int pos, boolean flag) {
//        calculate number for Or operation
        int changeBit =1;
        for (int i = 1; i < pos; i++) {
            changeBit <<= 1;
        }
        System.out.println(Integer.toBinaryString(changeBit));



        if (flag) {
            a |= changeBit;
        } else {
            int m = a; // buffer for initial value

            int k = a; //number to check 0 on pos
            k |= changeBit;

            a ^= ~changeBit;
            a = ~a;


            if (k == a) {
                a=m;
            }
        }
        return a;
    }
}

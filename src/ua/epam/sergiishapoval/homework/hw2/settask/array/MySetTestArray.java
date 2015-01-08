package ua.epam.sergiishapoval.homework.hw2.settask.array;

import java.util.ArrayList;

/**
 * Created by Сергей on 21.10.2014.
 */
public class MySetTestArray {
    public static void main(String[] args) {
        MySet mySet1 = new MySet();
        MySet mySet2 = new MySet();

        for (int i = 0; i <8 ; i++) {
            mySet1.add(i);
        }

        for (int i = 4; i <20 ; i++) {
            mySet2.add(i);
        }

        System.out.println(mySet1);
        System.out.println(mySet2);
        mySet1.union(mySet2);
        System.out.println(mySet1);

        


    }
}

package ua.epam.sergiishapoval.lecturescodeonsite.lecture24102014;

import java.util.Arrays;

/**
 * Created by Сергей on 24.10.2014.
 */
public class array_of_array {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{0,0,0,},{1,2,3,}};
        for (int i[] :arr) {
            for (int j: i) {
                System.out.print(j);
            }
            System.out.println();
        }


    }
}

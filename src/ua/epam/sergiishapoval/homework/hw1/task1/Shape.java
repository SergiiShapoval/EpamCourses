package ua.epam.sergiishapoval.homework.hw1.task1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергей on 20.10.2014.
 * Задание 1.
 * Допустимыми фигурами являются круг Ring, треугольник Triangle, параллелограмм Parallelogram
 * и трапеция Trapezium. В классе допустимых фигур Shape определить операцию сложения,
 * если суммой фигур служит сумма их площадей.
 */
public  class Shape {



    public static void main (String[] args){
        List<GetSquare> shapes = new ArrayList<GetSquare>();
        shapes.add(new Ring(5.7));
        shapes.add(new Parallelogram(8.7, 2.0));
        shapes.add(new Triangle (6.8, 10.0));
        shapes.add(new Trapezium (6.8, 10.0, 15.8));

        double squareSum = sumShapeSquare(shapes);

        System.out.printf("%.2f", squareSum);

    }

    private static double sumShapeSquare(List<GetSquare> shapes) {
        double squareSum = 0.0;
        for (GetSquare shape: shapes){
            squareSum += shape.getSquare();
        }
        return squareSum;
    }

}

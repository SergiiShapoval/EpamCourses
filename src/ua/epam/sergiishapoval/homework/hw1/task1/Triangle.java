package ua.epam.sergiishapoval.homework.hw1.task1;

/**
 * Created by Сергей on 20.10.2014.
 */
public class Triangle extends Shape implements GetSquare {
    double side, height;

    public Triangle(double side, double height) {
        this.side = side;
        this.height = height;
    }

    @Override
    public double getSquare() {
        return side*height/2.0;
    }
}

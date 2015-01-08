package ua.epam.sergiishapoval.homework.hw1.task1;

/**
 * Created by Сергей on 20.10.2014.
 */
public class Ring extends Shape implements GetSquare {
    double radius;

    public Ring(double radius) {
        this.radius = radius;

    }

    @Override
    public double getSquare() {
        return Math.PI * Math.sqrt(radius);
    }
}

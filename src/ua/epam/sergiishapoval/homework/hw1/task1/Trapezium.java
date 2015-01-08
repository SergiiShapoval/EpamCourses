package ua.epam.sergiishapoval.homework.hw1.task1;

/**
 * Created by Сергей on 20.10.2014.
 */
public class Trapezium extends Shape implements GetSquare {
    double baseTop, baseBottom, height;

    public Trapezium(double baseTop, double baseBottom, double height) {
        this.baseTop = baseTop;
        this.baseBottom = baseBottom;
        this.height = height;
    }

    @Override
    public double getSquare() {
        return (baseBottom + baseTop) * height / 2.0;
    }
}

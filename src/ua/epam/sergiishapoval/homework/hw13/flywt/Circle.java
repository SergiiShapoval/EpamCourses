package ua.epam.sergiishapoval.homework.hw13.flywt;

import java.awt.*;

/**
 * Created by Сергей on 25.11.2014.
 */
public class Circle {

    Color color;

    double posX,
            posY,
            radius;

    public Circle(Color color, double radius) {
        this.color = color;
        this.radius = radius;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public Color getColor() {
        return color;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "color=" + color +
                ", posX=" + posX +
                ", posY=" + posY +
                ", radius=" + radius +
                '}';
    }
}

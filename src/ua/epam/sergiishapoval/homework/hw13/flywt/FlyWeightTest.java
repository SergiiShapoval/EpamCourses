package ua.epam.sergiishapoval.homework.hw13.flywt;

import java.awt.*;
import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by Сергей on 25.11.2014.
 */
public class FlyWeightTest {
    static Map<Color, Circle> existCircles = new HashMap<>();

    static Random random = new Random();

    public static void main(String[] args) {


        for (int i = 0; i < 10000; i++) {
            int buffer = random.nextInt(255);
            Color randColor =  Color.getHSBColor(buffer, buffer, buffer);
            Circle circle = existCircles.get(randColor);
            if (circle == null){
                circle = new Circle(randColor, 4);
                existCircles.put(randColor, circle);
            }
            draw(circle);
        }

        System.out.printf("Total circle created:%s%n", existCircles.size());
    }

    private static void draw(Circle circle) {
        System.out.printf("%s is drawn%n", circle);
    }


}

package ua.epam.sergiishapoval.homework.hw8.integral;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергей on 10.11.2014.
 * 3.	Найти значение определенного интеграла от гладкой функции f(x).
 * Использовать метод трапеций.
 * Определить оптимальное количество потоков(
 * при котором производительность будет максимальной)
 * чем больше потоков, тем больше разбивок;
 */
public class IntegralByTrapezeMethod {
    public static void main(String[] args) {
        int threadQty = 0;
        double argA = 0.0, argB = 0.0;
        double integralResult = 0.0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        GetTask task = new GetTask(reader);

        try {
            argA = task.getArgument();
            argB = task.getArgument();

            threadQty = task.getThreadQty();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<IntegralThread> integralThreads = new ArrayList<>(threadQty);

        FunctionForIntegral function = new FunctionForIntegral() {
            @Override
            public double f(double arg) {
                return arg;
            }
        };

//order A<B
        if (argA > argB){
            double buffer = argA;
            argA = argB;
            argB = buffer;
        }

        double distanceAB = argB - argA;
        double stepAB = distanceAB / threadQty;
        double segmentStart = argA;

        for (int i = 0; i < threadQty; i++) {
            integralThreads.add(new IntegralThread(function, segmentStart, segmentStart + stepAB ));
            segmentStart += stepAB;
        }

        for (int i = 0; i < threadQty ; i++) {
            integralThreads.get(i).start();
        }

        for (int i = 0; i < threadQty ; i++) {
            try {
                integralThreads.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i <threadQty ; i++) {
            integralResult +=integralThreads.get(i).getIntegralPart();
        }

        System.out.println(String.format("Integral of tested function " +
                "between %.2f and %.2f equals %.4f", argA, argB, integralResult));

    }
}

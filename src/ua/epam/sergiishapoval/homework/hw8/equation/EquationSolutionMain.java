package ua.epam.sergiishapoval.homework.hw8.equation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Сергей on 10.11.2014.
 * 2.	Создать адаптивный алгоритм решения уравнения f(x)=0
 * на отрезке [a,b] методом деления отрезка пополам.
 * Количество потоков зависит от глубины рекурсии.
 */
public class EquationSolutionMain {

    public static void main(String[] args) {
        double argA = 0.0, argB = 0.0;
        double solution = 0.0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        EquationFunction function = new EquationFunction() {
            @Override
            public double f(double arg) {
                return arg - 5;
            }
        };

        GetArgs task = new GetArgs(reader);

        try {
            argA = task.getArgument();
            argB = task.getArgument();

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

//order A < B
        if (argA > argB){
            double buffer = argA;
            argA = argB;
            argB = buffer;
        }

        if ((function.f(argA) < 0 && function.f(argB) > 0) || (function.f(argA) > 0 && function.f(argB) < 0)) {

            EquationThread equationThread = new EquationThread(function, argA, argB);
            equationThread.start();

            try {
                equationThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            solution = equationThread.getSolution();
            System.out.printf("Solution of current function between %.2f and %.2f is %.8f", argA, argB, solution);
        } else {
            System.out.printf("There is no solution of current function between %.2f and %.2f ", argA, argB);
        }



    }
}

package ua.epam.sergiishapoval.homework.hw8.equation;


/**
 * Created by Сергей on 11.11.2014.
 */
public class EquationThread extends Thread {

    EquationFunction function;
    private double argA, argB;
    private double solution;

    public EquationThread(EquationFunction function, double argA, double argB) {
        this.function = function;
        this.argA = argA;
        this.argB = argB;
    }

    public double getSolution() {
        return solution;
    }

    @Override
    public void run() {

        EquationThread nextThread = null;

        System.out.println(Thread.currentThread().getName() + " created");
        double arg = (argA + argB) / 2;
        double funcResult = function.f(arg);
        if (Math.abs(funcResult )< 0.00000001) solution = arg;
        else {
            if (funcResult < 0) {
                nextThread = new EquationThread(function, arg, argB);
                nextThread.start();
                try {
                    nextThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                nextThread = new EquationThread(function, argA, arg);
                nextThread.start();
                try {
                    nextThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            solution = nextThread.getSolution();
        }
    }
}


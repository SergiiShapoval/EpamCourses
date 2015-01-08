package ua.epam.sergiishapoval.homework.hw8.integral;

/**
 * Created by Сергей on 11.11.2014.
 */
public class IntegralThread extends Thread {

    private FunctionForIntegral function;
    private double argA, argB;
    private double integralPart;

    public IntegralThread(FunctionForIntegral function, double argA, double argB) {
        this.function = function;
        this.argA = argA;
        this.argB = argB;
    }

    public double getIntegralPart() {
        return integralPart;
    }

    @Override
    public void run() {
        integralPart = Math.abs(argA - argB) * (function.f(argA) + function.f(argB)) / 2;
    }
}

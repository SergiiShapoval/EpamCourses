package ua.epam.sergiishapoval.homework.hw13.polnote.elements;

/**
 * Created by Сергей on 24.11.2014.
 */
public enum Operation {
    ADD(1) {
        double calculate(double arg1, double arg2) {
            return arg1 + arg2;
        }
    },
    MINUS(1) {
        double calculate(double arg1, double arg2) {
            return arg1 - arg2;
        }
    },
    MULTIPLY(2) {
        double calculate(double arg1, double arg2) {
            return arg1 * arg2;
        }
    },
    DIVIDE(2) {
        double calculate(double arg1, double arg2) {
            return arg1 / arg2;
        }
    },
    OPEN_BREACKETS(10){
        double calculate(double arg1, double arg2) {
                return 0;
        }
    },

    CLOSE_BREACKETS(10){
        double calculate(double arg1, double arg2) {
                return 0;
        }
    }
    ;

    private int priority;

    Operation(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    abstract double calculate (double arg1, double arg2);
}

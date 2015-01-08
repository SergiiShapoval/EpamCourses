package ua.epam.sergiishapoval.homework.hw13.polnote.elements;

/**
 * Created by Сергей on 24.11.2014.
 */
public class Argument extends Component{

    double arg;

    public Argument(double arg) {
        this.arg = arg;
    }

    public double getArg() {
        return arg;
    }

    @Override
    public double calculate() {
        return arg;
    }

    @Override
    public String toString() {
        return arg + "";
    }
}

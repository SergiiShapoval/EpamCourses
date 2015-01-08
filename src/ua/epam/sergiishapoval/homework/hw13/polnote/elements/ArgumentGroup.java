package ua.epam.sergiishapoval.homework.hw13.polnote.elements;

/**
 * Created by Сергей on 24.11.2014.
 */
public class ArgumentGroup extends Component  {

    Operation operation;

    public ArgumentGroup(Operation operation, Component left, Component right) {
        this.operation = operation;
        this.left = left;
        this.right = right;
    }

    @Override
    public void setLeft(Component left) {
        this.left = left;
    }

    @Override
    public void setRight(Component right) {
        this.right = right;
    }

    public double calculate() {
        return operation.calculate(this.left.calculate(), this.right.calculate());
    }

    @Override
    public String toString() {
        return operation.toString();
    }
}

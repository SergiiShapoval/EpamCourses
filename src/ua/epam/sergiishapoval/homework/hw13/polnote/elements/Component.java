package ua.epam.sergiishapoval.homework.hw13.polnote.elements;

/**
 * Created by Сергей on 24.11.2014.
 */
public abstract class Component {

    Component left;
    Component right;

    public void setLeft(Component left) {
        throw new UnsupportedOperationException("Argument can't have child");
    }

    public void setRight(Component right) {
        throw new UnsupportedOperationException("Argument can't have child");
    }

    public double calculate(){
        throw new UnsupportedOperationException("Argument can't calculate itself");
    }
}

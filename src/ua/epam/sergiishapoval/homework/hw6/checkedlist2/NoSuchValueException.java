package ua.epam.sergiishapoval.homework.hw6.checkedlist2;

/**
 * Created by Сергей on 05.11.2014.
 */
public class NoSuchValueException extends Exception {


    public NoSuchValueException(String s) {
        super(s);
    }

    public NoSuchValueException() {
        super();
    }

    @Override
    public String toString() {
        return getMessage() + " is not in a list";
    }
}

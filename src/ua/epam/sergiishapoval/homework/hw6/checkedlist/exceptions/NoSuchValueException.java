package ua.epam.sergiishapoval.homework.hw6.checkedlist.exceptions;

import java.util.NoSuchElementException;

/**
 * Created by Сергей on 05.11.2014.
 */
public class NoSuchValueException extends NoSuchElementException {


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

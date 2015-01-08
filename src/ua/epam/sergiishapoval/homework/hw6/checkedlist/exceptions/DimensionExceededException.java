package ua.epam.sergiishapoval.homework.hw6.checkedlist.exceptions;

/**
 * Created by Сергей on 05.11.2014.
 */
public class DimensionExceededException extends ArrayIndexOutOfBoundsException {
    @Override
    public String toString() {
        return "Your linked list is full. Remove element before insert";
    }
}

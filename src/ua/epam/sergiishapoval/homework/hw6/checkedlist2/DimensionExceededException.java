package ua.epam.sergiishapoval.homework.hw6.checkedlist2;

/**
 * Created by Сергей on 05.11.2014.
 */
public class DimensionExceededException extends Exception {
    public DimensionExceededException() {
        super();
    }

    public DimensionExceededException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "Your linked list is full. " + getMessage()+ " was not inserted. Remove element before insert";
    }
}

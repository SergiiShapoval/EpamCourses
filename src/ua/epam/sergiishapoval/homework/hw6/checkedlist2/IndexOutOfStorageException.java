package ua.epam.sergiishapoval.homework.hw6.checkedlist2;

/**
 * Created by Сергей on 05.11.2014.
 */
public class IndexOutOfStorageException extends IndexOutOfBoundsException{

    public IndexOutOfStorageException() {
        super();
    }

    public IndexOutOfStorageException(String s) {
        super(s);
    }

    @Override
    public String toString() {
        return "There is no element with such index: "+ getMessage();
    }
}

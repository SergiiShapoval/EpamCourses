package ua.epam.sergiishapoval.homework.hw4REDO.prioqueue;

/**
 * Created by Сергей on 30.10.2014.
 */
public interface Queue {

    boolean offer (int object);
    int peek();
    int poll();
    int remove();
    boolean isEmpty();

}

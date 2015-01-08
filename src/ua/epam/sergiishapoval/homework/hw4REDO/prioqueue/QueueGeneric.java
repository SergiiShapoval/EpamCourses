package ua.epam.sergiishapoval.homework.hw4REDO.prioqueue;

/**
 * Created by Сергей on 30.10.2014.
 */
public interface QueueGeneric<T extends Comparable< ? super T>> {
    boolean offer (T object);
    T peek();
    T poll();
    T remove();
    boolean isEmpty();
}

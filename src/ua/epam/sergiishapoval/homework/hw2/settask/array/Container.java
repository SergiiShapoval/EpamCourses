package ua.epam.sergiishapoval.homework.hw2.settask.array;

/**
 * Created by Сергей on 20.10.2014.
 */
public interface Container {
    void add(Object element);
    void remove(int index);
    Object get(int index);
    boolean contains(Object element);
    int size();

}

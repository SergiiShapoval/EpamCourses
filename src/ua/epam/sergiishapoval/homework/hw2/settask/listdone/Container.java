package ua.epam.sergiishapoval.homework.hw2.settask.listdone;

import java.util.List;

/**
 * Created by Сергей on 20.10.2014.
 */
public interface Container {
    void add(Object element);
    void remove(int index);
    Object get(int index);
    List<Object> getAll();
    boolean contains(Object element);
    int size();
    String toString();
    Container clone();

}

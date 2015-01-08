package ua.epam.sergiishapoval.lecturescodeonsite.lecture20102014.set;

/**
 * Created by Сергей on 20.10.2014.
 */
public interface Container {
    void add (int element);
    void remove (int index);
    int get (int index);
    boolean contains (int element);
    int size();


}

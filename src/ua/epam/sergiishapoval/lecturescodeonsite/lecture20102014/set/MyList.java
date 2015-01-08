package ua.epam.sergiishapoval.lecturescodeonsite.lecture20102014.set;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Сергей on 20.10.2014.
 * паттерн адаптер
 */
public class MyList implements Container {
    List<Integer> list = new LinkedList<>();


    @Override
    public void add(int element) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public int get(int index) {
        return 0;
    }

    @Override
    public boolean contains(int element) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}

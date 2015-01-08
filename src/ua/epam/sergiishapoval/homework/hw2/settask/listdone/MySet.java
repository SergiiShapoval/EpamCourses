package ua.epam.sergiishapoval.homework.hw2.settask.listdone;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Сергей on 23.10.2014.
 */
public class MySet {
    Container c;

    public MySet(Container c) {
        this.c = c;
    }

    public void add(Object element) {
        if (!contains(element)) {
            c.add(element);
        }
    }

    public void remove(int index) {
        c.remove(index);

    }

    public Object get(int index) {
        return c.get(index);
    }

    public boolean contains(Object element) {
        return c.contains(element);
    }

    public int size() {
        return c.size();
    }


    public List<Object> getAll() {
        List<Object> list = new LinkedList<>();
        for (int i = 0; i <c.size() ; i++) {
            list.add(c.get(i));
        }

        return list;
    }



    public MySet union(MySet secondSet) {

        MySet newMySet = new MySet(c.clone());
        for (Object element : secondSet.getAll()){
            newMySet.add(element);
        }
        return newMySet;
    }




    @Override
    public String toString() {
        return c.toString();
    }
}

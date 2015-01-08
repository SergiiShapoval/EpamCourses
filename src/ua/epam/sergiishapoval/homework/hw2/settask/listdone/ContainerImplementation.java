package ua.epam.sergiishapoval.homework.hw2.settask.listdone;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Сергей on 21.10.2014.
 * 1.	Написать максимально расширяемый проект множество Set
 * (множество может содержать различные типы,
 * может быть реализовано на базе списка,
 * массива и т.д.)
 */
public class ContainerImplementation implements Container {
    LinkedList<Object> storage = new LinkedList<>();


    @Override
    public void add(Object element) {
        if (!contains(element)) {
            storage.add(element);
        }
    }

    @Override
    public void remove(int index) {
        storage.remove(index);

    }

    @Override
    public Object get(int index) {
        return storage.get(index);
    }

    @Override
    public boolean contains(Object element) {
        return storage.contains(element);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public String toString() {
        return storage.toString();
    }

    @Override
    public List<Object> getAll() {
        return storage;
    }

    @Override
    public Container clone() {

        ContainerImplementation newContainer = new ContainerImplementation();
        for (Object object : this.getAll()) {
            newContainer.add(object);
        }
        return newContainer;
    }
}

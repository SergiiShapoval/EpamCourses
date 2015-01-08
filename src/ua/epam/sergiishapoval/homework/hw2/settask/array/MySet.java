package ua.epam.sergiishapoval.homework.hw2.settask.array;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Сергей on 21.10.2014.
 * 1.	Написать максимально расширяемый проект множество Set
 * (множество может содержать различные типы,
 * может быть реализовано на базе списка,
 * массива и т.д.)
 */
public class MySet implements Container {
    Object[] storage;
    int counter;

    public MySet() {
        storage = new Object [8];
        counter = 0;
    }

    public Object[] getStorage() {
        return storage;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public void add(Object element) {
        if (!contains(element)) {
            if (counter == storage.length) {
                storage = Arrays.copyOf(storage, 2 * storage.length);
            }
            storage[counter] = element;
            counter++;
        }
    }

    @Override
    public void remove(int index) {
        System.arraycopy(storage, index, storage, index + 1, counter - index - 1);

        for (int i = index; i < counter-1 ; i++) {
            storage[i] = storage[i+1];
        }
        counter--;
        if (counter<= storage.length/2){
            storage = Arrays.copyOf(storage, counter);
        }
    }

    @Override
    public Object get(int index) {
        return storage[index];
    }

    @Override
    public boolean contains(Object element) {
        if (element==null) {
            return true;
        } else {
            for (int i = 0; i < counter; i++) {
                if (storage[i].equals(element)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public String toString() {
        StringBuilder outString = new StringBuilder();
        outString.append("{");
        boolean isFirst = true;
        for (int i = 0; i < counter ; i++) {


            if (!isFirst) {
                outString.append(", "+storage[i]);

            } else {
                outString.append(storage[i]);
                isFirst = false;
            }
        }
        outString.append("}");
        return outString.toString();
    }

    public void union(MySet secondSet) {
        for (Object element : secondSet.getStorage() ){
            this.add(element);
        }


    }
}

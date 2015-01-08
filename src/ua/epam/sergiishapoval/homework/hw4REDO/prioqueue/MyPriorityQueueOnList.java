package ua.epam.sergiishapoval.homework.hw4REDO.prioqueue;

import java.util.ArrayList;

/**
 * Created by Сергей on 30.10.2014.
 */
public class MyPriorityQueueOnList <T extends Comparable<? super T>> implements QueueGeneric<T>{

    ArrayList<T> storage;


    public MyPriorityQueueOnList() {

        storage = new ArrayList<>();
        
    }

    @Override
    public boolean offer(T object) {

        if (storage.size() == 0) {
            storage.add(object);
        } else {
            if (object.compareTo(storage.get(0)) >= 0) {
                storage.add(0, object);
            }
            else {
                if (object.compareTo(storage.get(storage.size()-1)) <=0){
                    storage.add(object);
                }
                else {
                    int index = binarySearch (object, 0, storage.size() - 1, (storage.size() - 1)/2);
                    storage.add(index, object);
                }
            }


        }

        return true;
    }

    private int binarySearch(T object, int begin, int end, int middle) {
        if (begin == middle) return middle + 1;

        if (object.compareTo(storage.get(middle))>0){
            return binarySearch(object, begin, middle, (middle + begin) / 2);
        } else {
            if (object.compareTo(storage.get(middle))<0){
                return binarySearch(object, middle, end, (middle + end) / 2);
            } else {
                return middle;
            }
        }

    }


    @Override
    public T peek() {
        return storage.get(0);
    }

    @Override
    public T poll() {
        return storage.remove(0);
    }

    @Override
    public T remove() {
        return storage.remove(0);
    }



    @Override
    public boolean isEmpty() {
        return storage.isEmpty();
    }

    @Override
    public String toString() {
        return storage.toString();
    }
}

package ua.epam.sergiishapoval.homework.hw4REDO.priolinklist;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Сергей on 30.10.2014.
 */
public class PriorityLinkedList<T extends Comparable<? super T>>  implements Iterable<T>{

    LinkedList<T> storage;

    public PriorityLinkedList() {
        storage = new LinkedList<>();
    }

    boolean add(T object){


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

    T get(){
        return storage.get(0);
    }

    T remove(){
        return storage.remove(0);
    }

    int size(){
        return storage.size();
    }

    boolean isEmpty(){
        return storage.isEmpty();
    }

    @Override
    public Iterator iterator() {
        return storage.iterator();
    }

    @Override
    public String toString() {
        return "PriorityLinkedList{" +
                "storage=" + storage +
                '}';
    }
}

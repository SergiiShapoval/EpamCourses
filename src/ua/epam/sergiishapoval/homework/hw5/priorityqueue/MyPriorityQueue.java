package ua.epam.sergiishapoval.homework.hw5.priorityqueue;

import java.util.Arrays;

/**
 * Created by Сергей on 01.11.2014.
 */
public class MyPriorityQueue {

    private Integer[] storage;
    private int size;
    private final static int STORAGE_LENGTH = 11;
    private final static int SIZE_INCREMENT = 2;

    public MyPriorityQueue() {
        storage = new Integer[STORAGE_LENGTH];
    }

    void offer(Integer value){
        int position = 0;
        int comparison;

        if (size() == storage.length) {
            storage = Arrays.copyOf(storage, size*SIZE_INCREMENT);
        }

        while (position < size){
            comparison = value.compareTo(storage[position]);
            if (comparison > 0) {
                value = swap(value, position);
            }

            position++;
        }

        storage[position] = value;


        size++;

    }

    private Integer swap(Integer value, int position) {
        Integer buffer = storage[position];
        storage[position] = value;
        value = buffer;
        return value;
    }

    int size(){
        return size;
    }

    Integer poll(){
        Integer result = storage[0];
        size--;
        Integer valueToSink = swap(result, size);
        storage[size] = null;
        int position=0;
        int maxIndex;
        while (position < size){

            int index1 = position * 2 + 1;
            int index2 = position * 2 + 2;
            if (storage[index1] == null) {
                if (storage[index2] == null) {
                    break;
                }
                maxIndex = index2;
            } else {
                if ( storage[index2] == null) {
                    maxIndex = index1;
                } else {
                    maxIndex = storage[index1].compareTo(storage[index2]) > 0 ? index1 : index2;
                }
            }
            swap(storage[maxIndex], position);
            position = maxIndex;
        }

        if (size > 0) {
            storage[position] = valueToSink;
        }
        return result;
    }

    Integer peek(){
        return storage[0];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(size * 2 + 1 );

        stringBuilder.append("{");

        boolean isFirst = true;

        for (Integer i: storage){

            if (!isFirst) {
                stringBuilder.append(", ");
            } else {
                isFirst = false;
            }

            if ( i != null )
                stringBuilder.append(i);
        }

        stringBuilder.append("}");

        return stringBuilder.toString();
    }

}

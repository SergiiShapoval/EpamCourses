package ua.epam.sergiishapoval.homework.hw4REDO.prioqueue;

import java.util.Arrays;

/**
 * Created by Сергей on 30.10.2014.
 */
public class MyPriorityQueue implements Queue {

    int[] storage;
    int first, last, length, size;

    public MyPriorityQueue(int length) {
        this.length = length;
        storage = new int[length];
        first = last = -1;
        size= 0;
        Arrays.fill(storage, -1);
    }

    @Override
    public boolean offer(int object) {

        if (size == length) {
            return false;
        } else {

            // moving array to the beginning
            if (last >= length - 1) {
                System.arraycopy(storage, first, storage, 0, size);
                first = 0;
                last = size - 1;
                Arrays.fill(storage, last + 1 , length , -1);
            }

            //first element
            if (size == 0) {
                first = last = 0;
                storage[first] = object;
            } else {

                // finding right position to insert

                if (object <= storage[last]) {
                    storage[++last] = object;
                } else {
                    if (object >= storage[first]) {
                        if (first == 0) {
                            System.arraycopy(storage, 0, storage, 1, size);
                            storage[first] = object;
                            last++;
                        } else {
                            storage[--first] = object;
                        }

                    } else {
                        int positionToInsert = BinarySearch(object, last, first, (last + first) / 2);
                        System.arraycopy(storage, positionToInsert, storage, positionToInsert + 1, last + 1 - positionToInsert);
                        storage[positionToInsert] = object;
                        last++;
                    }
                }

            }




/*
            non-priority insert

            storage[++last] = object;
            if (size == 0) {
                first = last;
            }
*/
            size++;


            return true;
        }

    }

    private int BinarySearch(int object, int last, int first, int middle) {
        if (middle == first) return middle + 1;
        if (object > storage[middle]){
            return BinarySearch(object, middle, first, (first + middle) / 2);
        } else {
            if (object < storage[middle]){
                return BinarySearch(object, last, middle, (last + middle) / 2);
            }
            else {
                return middle;
            }
        }
    }

    @Override
    public int peek() {
        return storage[first];
    }

    @Override
    public int poll() {
        if (first == -1) {
            throw new RuntimeException("Queue is empty");
        }
        int result = storage[first];
        storage[first++] = -1;
        size--;
        if (size == 0) first = last = -1;
        return result;
    }

    @Override
    public int remove() {
        if (first == -1) {
            throw new RuntimeException("Queue is empty");
        }
        int result = storage[first];
        storage[first++] = -1;
        size--;
        if (size == 0) first = last = -1;
        return result;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(length * 2 + 1 );

        stringBuilder.append("{");

        boolean isFirst = true;

        for (int i: storage){

            if (!isFirst) {
                stringBuilder.append(", ");
            } else {
                isFirst = false;
            }

            if ( i != -1 )
                stringBuilder.append(i);
        }

        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}

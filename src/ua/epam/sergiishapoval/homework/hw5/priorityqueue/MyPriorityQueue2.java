package ua.epam.sergiishapoval.homework.hw5.priorityqueue;

import java.util.Arrays;

/**
 * Created by Сергей on 01.11.2014.
 * bigger value is prior
 *
 *

 Important points:
 null verification on any operation
 resize and increase size before input
 siftUp on insert, siftDown on delete
 siftUp from end, siftDown from begin
 parent by -1 >>>
 decrease size before delete
 delete while half

 *
 *
 */
public class MyPriorityQueue2 {
    private Integer[] storage;
    private int size;
    private final static int STORAGE_LENGTH = 11;
    private final static int SIZE_INCREMENT = 2;

    public MyPriorityQueue2() {
        storage = new Integer[STORAGE_LENGTH];
    }

    public boolean offer(Integer element) {
        if (element == null)
            throw new NullPointerException();
        int currentEnd = size;
        if (size >= storage.length) {
            storage = Arrays.copyOf(storage, size * SIZE_INCREMENT);
        }
        size++;
        if (currentEnd == 0)
            storage[0] = element;
        else
            siftUp(currentEnd, element);
        return true;
    }

    private void siftUp(int currentPos, Integer insertedObject) {
        while (currentPos > 0) {
            int parent = (currentPos - 1) >>> 1;
            Integer parentValue = storage[parent];
            if (insertedObject.compareTo( parentValue) <= 0)
                break;
            storage[currentPos] = parentValue;
            currentPos = parent;
        }
        storage[currentPos] = insertedObject;
    }

    public Integer poll() {
        if (size == 0)
            return null;
        int lastIndex = --size;
        Integer result = storage[0];
        Integer lastValue = storage[lastIndex];
        storage[lastIndex] = null;
        if (lastIndex != 0)
            siftDown(0, lastValue);
        return result;
    }

    private void siftDown(int position, Integer siftValue) {
        int half = size >>> 1;
        while (position < half) {
//find biggest from both children end pop up, if no - break
            int child = (position << 1) + 1;
            Integer childValue = storage[child];
            int right = child + 1;
            if (right < size &&
                     childValue.compareTo(storage[right]) < 0)
                childValue = storage[child = right];
            if (siftValue.compareTo( childValue) >= 0)
                break;
            storage[position] = childValue;
            position = child;
        }
        storage[position] = siftValue;
    }

    public Integer peek() {
        return (size == 0) ? null : storage[0];
    }

    public int size() {
        return size;
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

package ua.epam.sergiishapoval.homework.hw4REDO.prioqueue;

import java.util.Arrays;

/**
 * Created by Сергей on 30.10.2014.
 */
public class MyPriorityQueueUnlimitedGeneric<T extends Comparable<? super T>> implements QueueGeneric<T> {

    T[] storage;
    int first, last, length, size;

    public MyPriorityQueueUnlimitedGeneric (Class<T> clazz, int length) {
        this.length = length;
        storage = (T[]) java.lang.reflect.Array.newInstance(clazz, length);
        first = last = -1;
        size= 0;
//        Arrays.fill(storage, null);
    }



    @Override
    public boolean offer(T object) {

        if (size == length) {
            increaseLength();

        } else {
            if (last >= length - 1) {
                System.arraycopy(storage, first, storage, 0, size);
                first = 0;
                last = size - 1;
//                Arrays.fill(storage, last + 1 , length , null);
            }
//first element
            if (size == 0) {
                first = last = 0;
                storage[first] = object;
            } else {

// finding right position to insert and insert

                if (object.compareTo(storage[last]) <= 0) {
                    storage[++last] = object;
                } else {
                    if (object.compareTo(storage[first]) >= 0) {
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
// end of insert
            size++;


        }
        return true;
    }

    private int BinarySearch(T object, int last, int first, int middle) {
        if (middle == first) return middle + 1;
        if (object.compareTo(storage[middle]) > 0){
            return BinarySearch(object, middle, first, (first + middle) / 2);
        } else {
            if (object.compareTo(storage[middle]) < 0 ){
                return BinarySearch(object, last, middle, (last + middle) / 2);
            }
            else {
                return middle;
            }
        }
    }


    private void increaseLength() {
        length = 3 * length / 2 + 1;
        storage = Arrays.copyOf(storage, length);
    }

    @Override
    public T peek() {
        return storage[first];
    }

    @Override
    public T poll() {
        if (first == -1) {
            throw new RuntimeException("Queue is empty");
        }
        T result = storage[first];
        storage[first++] = null;
        size--;
        if (size == 0) first = last = -1;
        return result;
    }

    @Override
    public T remove() {
        if (first == -1) {
            throw new RuntimeException("Queue is empty");
        }
        T result = storage[first];
        storage[first++] = null;
        size--;
        if (size == 0) first = -1;
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

        for (T i: storage){

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

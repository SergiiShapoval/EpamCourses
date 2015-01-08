package ua.epam.sergiishapoval.homework.hw6.checkedlist;

import ua.epam.sergiishapoval.homework.hw6.checkedlist.exceptions.DimensionExceededException;
import ua.epam.sergiishapoval.homework.hw6.checkedlist.exceptions.IndexOutOfStorageException;
import ua.epam.sergiishapoval.homework.hw6.checkedlist.exceptions.NoSuchValueException;

/**
 * Created by Сергей on 05.11.2014.
 */
public class SecureArrayList {

    Integer[] storage;
    int dimension;
    int size ;

    public SecureArrayList(int dimension) {
        this.dimension = dimension;
        storage = new Integer[dimension];
    }

    public int size(){
        return size;
    }

    void add(Integer value){
        if (size >= dimension) throw new DimensionExceededException();
        storage[size++] = value;
    }

    public int indexOf(Integer value){
        int index = -1;
        if (value == null) return index;
        for (int i = 0; i < size ; i++) {
            if (value.equals(storage[i])){
                index = i;
                break;
            }
        }
        if (index == -1) throw new NoSuchValueException(value.toString());
        return index;
    }

    public Integer remove(Integer value){
        int index = indexOf(value);
        Integer result = get(index);
        System.arraycopy(storage, index + 1, storage, index, --size - index);
        return result;
    }

    public Integer remove(int index){

        Integer result = get(index);
        System.arraycopy(storage, index + 1, storage, index, --size - index);
        return result;
    }

    public Integer get(int index){
        if (index < 0 || index >= size) throw new IndexOutOfStorageException(index + "");
        return storage[index];
    }
}

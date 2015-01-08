package ua.epam.sergiishapoval.homework.hw6.checkedlist2;

/**
 * Created by Сергей on 05.11.2014.
 */
public class SecureArrayListContinue {

    Integer[] storage;
    int dimension;
    int size ;

    public SecureArrayListContinue(int dimension) {
        this.dimension = dimension;
        storage = new Integer[dimension];
    }

    public int size(){
        return size;
    }

    public boolean add(Integer value) {

        try{
            if (size >= dimension) throw new DimensionExceededException();
            storage[size++] = value;
            return true;
        }catch (Exception e){
            System.out.println( e );
            return false;
        }
    }

    public int indexOf(Integer value) throws NoSuchValueException {
        try {
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
        }catch (Exception e){
            System.out.println(e);
            throw e;
        }
    }

    public Integer remove(Integer value){
        try {
            int index = indexOf(value);
            Integer result = get(index);
            System.arraycopy(storage, index + 1, storage, index, --size - index);
            return result;
        }catch (Exception e) {
            return null;
        }
    }

    public Integer remove(int index){
        try {

            Integer result = get(index);
            System.arraycopy(storage, index + 1, storage, index, --size - index);
            return result;
        }catch (Exception e){
            return null;
        }
    }

    public Integer get(int index) throws IndexOutOfStorageException {
        try {
            if (index < 0 || index >= size) throw new IndexOutOfStorageException(index + "");
            return storage[index];
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}

package ua.epam.sergiishapoval.homework.hw5.hashmap;


/**
 * Created by Сергей on 01.11.2014.
 *

 Important points:
 4 fields in Entry
 resize before input in main put
 put return previous value
 null key verification
 special case for first Entry in cell everywhere
 hash function return 0 or h^h>>>16
 remove and get on same method with boolean if delete
 % = & due to dimension = 2^n
 if of while in delete on entry.next
 resize should null entry.next after copy

 *
 *
 *
 * Хеш-таблица - обычный массив
 * Вычисляем для каждого значения некий хеш-код
 * Например, по ascii коду каждого символа сумму
 * Если в таблице 7 элементов - берём полученный код по модулю 7, и заносим в ячейку с соответствующем модуле
 * Если совпадают коды -  коллизия
 * Ложим в одну ячейку, и делаем из ячейки список
 *
 * При поиске - берём хеш, а потом проверяем элементы списка на равенство
 *
 * Односвязный список в каждой ячейке.
 *
 * Нужен алгоритм, чтобы было минимум коллизий иначе будет работать по принципу поиска в списке.
 * По умолчанию 16 элементов в массиве,
 * В Entry хранится ключ, значение - ссылка на следующий объект, и final hash - константа.
 *
 * p & (length - 1) вычисляем ячейку по полученному хешкоду
 * Null ключ будет добавлен в 0 элемент
 * Специальная функция - putNull
 *
 * При увеличении массива - перерасчёт хеш-кодов и заново пересоздается таблица.
 *
 * Поиск - hashcode - hash - остаток - проходимся по всем с equals.
 *
 * Если значение уже существует - перезаписываем
 *
 * Если один и тот же ключ обновление
 */
public class MyHashMap {

    private Entry[] storage;
    int length = STORAGE_DIMENSION;
    int loadFactor = (int) (STORAGE_DIMENSION * MAX_LOADNESS);
    final static double MAX_LOADNESS = 0.75;

    int size;

    final static int STORAGE_DIMENSION = 16;

    private class Entry {
        Integer value;
        Integer key;
        Entry next;
        final int hash;

        private Entry(int hash, Entry next, Integer key, Integer value) {
            this.hash = hash;
            this.next = next;
            this.key = key;
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public Integer getKey() {
            return key;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return key + ": " +value;
        }
    }

    public MyHashMap() {
        storage = new Entry[STORAGE_DIMENSION];
    }

    public Integer put (Integer key, Integer value){

        if (size >= loadFactor) {
            storage = resizeMap(storage, key, value);
        }
        Integer result =  put(storage, key, value);
        size++;

        return result;

    }

    private Integer put(Entry[] storage, Integer key, Integer value) {

        Integer result = null;

        int cellHash = hash(key);
        boolean isKeyFound = false;
        int cellAddress = cellHash & (length - 1);
        Entry entry;
        if (storage[cellAddress] == null) {
            storage[cellAddress] = new Entry(cellHash , null, key, value);
        } else {
            entry = storage[cellAddress];


            while (entry.next != null) {
                if ((entry.getKey() == null && key == null)  || (entry.getKey() != null && entry.getKey().equals(key))) {
                    result = entry.getValue();
                    entry.setValue(value);
                    isKeyFound = true;
                    break;
                }
                entry = entry.next;
            }

            if (!isKeyFound) {
                entry.next = new Entry(cellHash, null, key, value);
            }
        }

        return result;
    }

    private Entry[] resizeMap(Entry[] storage, Integer key, Integer value) {
        length = length << 1;
        loadFactor = (int) (length * MAX_LOADNESS);

        Entry[] newStorage = new Entry[length];
        for (Entry entry : storage) {
            while (entry != null) {
                int cellAddress = entry.hash & (length - 1);
                if (newStorage[cellAddress] == null) {
                    newStorage[cellAddress] =  entry;
                    entry = entry.next;
                    newStorage[cellAddress].next = null;
                } else {
                    Entry newEntry = newStorage[cellAddress];
                    while (newEntry.next != null) {
                        newEntry = newEntry.next;
                    }
                    newEntry.next = entry;
                    entry = entry.next;
                    newEntry.next.next = null;
                }

            }
        }

        return newStorage;
    }

    private static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }


    public Integer remove(Integer key) {
        return getValue(key, true);
    }
    public Integer get(Integer key) {
        return getValue(key, false);
    }

    private Integer getValue(Integer key, boolean isToBeDeleted) {
        Integer result = null;
        int cellHash = hash(key);
        int cellAddress = cellHash & (length - 1);
        Entry entry = storage[cellAddress];
        if ( (entry.getKey() == null && key == null)  || (entry.getKey() != null && entry.getKey().equals(key))) {
            result = entry.getValue();
            if (isToBeDeleted) {
                storage[cellAddress] = entry.next;
            }
            return result;
        }
        while (entry.next != null) {
            if ((entry.next.getKey() == null && key == null)  || (entry.next.getKey() != null && entry.next.getKey().equals(key))) {
                result = entry.next.getValue();
                if (isToBeDeleted) {
                    entry.next = entry.next.next;
                }
                break;
            }
            entry = entry.next;
        }

        return result;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(size * 2 + 1 );

        stringBuilder.append("{");

        boolean isFirst = true;

        for (Entry entry: storage){

            if (!isFirst) {
                stringBuilder.append(", ");
            } else {
                isFirst = false;
            }

            while ( entry != null ) {
                stringBuilder.append(entry);
                entry = entry.next;
            }
        }

        stringBuilder.append("}");

        return stringBuilder.toString();
    }

}

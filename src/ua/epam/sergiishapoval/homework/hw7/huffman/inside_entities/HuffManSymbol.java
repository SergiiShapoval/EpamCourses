package ua.epam.sergiishapoval.homework.hw7.huffman.inside_entities;

/**
 * Created by Сергей on 07.11.2014.
 */
public class HuffManSymbol implements Comparable<HuffManSymbol> {
    private String key;
    private int value;

    public HuffManSymbol(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HuffManSymbol)) return false;

        HuffManSymbol that = (HuffManSymbol) o;

        if (!key.equals(that.key)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    @Override
    public int compareTo(HuffManSymbol o) {
        return value + key.length() - o.value -o.key.length();
    }

    @Override
    public String toString() {
        return key + " = " + value;
    }
}

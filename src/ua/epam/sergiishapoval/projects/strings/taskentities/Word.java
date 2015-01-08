package ua.epam.sergiishapoval.projects.strings.taskentities;

/**
 * Created by Сергей on 06.11.2014.
 */
public class Word {
    String value;

    public Word(String string) {
        value = string;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;

        Word word = (Word) o;

        if (!value.equals(word.value)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}

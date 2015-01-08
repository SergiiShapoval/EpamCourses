package ua.epam.sergiishapoval.homework.hw1.task2;

/**
 * Created by Сергей on 20.10.2014.
 */
public class Entity {
    String type;
    String name;

    public Entity(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type +" "+name;
    }
}

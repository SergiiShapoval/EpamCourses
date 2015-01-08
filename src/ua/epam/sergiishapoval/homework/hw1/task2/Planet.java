package ua.epam.sergiishapoval.homework.hw1.task2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергей on 20.10.2014.
 * 5.	Создать объект класса Планета, используя классы Материк,
 * Океан, Остров.
 * Методы: вывести на консоль название материка,
 * планеты, количество материков.
 */
public class Planet {
    List<Entity> entities;

    String name;

    public Planet(List<Entity> entities, String name) {
        this.entities = entities;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public static void main (String[] args){

        List<Entity> entities1 = new ArrayList<>();
        String oceanNameBasic = "Ocean";
        for (int i = 0; i < 5 ; i++) {
            entities1.add(new Entity(oceanNameBasic, oceanNameBasic+i));
        }

        String mainlandNameBasic = "Mainland";
        for (int i = 0; i < 5 ; i++) {
            entities1.add(new Entity(mainlandNameBasic, mainlandNameBasic+i));
        }


        String islandNameBasic = "Island";
        for (int i = 0; i < 7 ; i++) {
            entities1.add(new Entity(islandNameBasic, islandNameBasic+i));
        }


        Planet earth = new Planet(entities1, "Earth");

        System.out.println(earth);

        int counter =0;

        for (Entity entity:  earth.getEntities()){
            if (entity.getType().equals("Mainland")){
                System.out.println(entity);
                counter++;
            }
        }

        System.out.println(counter);



    }
}

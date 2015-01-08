package ua.epam.sergiishapoval.homework.hw10.violinist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Сергей on 11.11.2014.
 * 	3. Задача скрипачах
 * 	(либо задача о философах с вилками и ножами)
 * 	Скрипачей больше чем смычков и скрипок, очередь скрипок,
 * 	смычков, скрипачей, после игры возвращает в очередь всё.
 * 	Решить задачу, чтобы гарантировано не было DeadLock
 */
public class ViolinistMain {
    public static void main(String[] args) {

        List<Violinist> violinists = new ArrayList<>();

        Queue<Integer> violins = new LinkedList<>();
        Queue<String> leashes = new LinkedList<>();

        for (int i = 0; i < 4 ; i++) {
            violins.add(i);
            leashes.add(""+i);
        }



        for (int i = 0; i < 12  ; i++) {
            violinists.add(new Violinist(violins, leashes));
        }
        for (int i = 0; i < 12  ; i++) {
            violinists.get(i).start();
        }





    }
}

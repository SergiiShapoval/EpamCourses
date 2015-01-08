package ua.epam.sergiishapoval.homework.hw10.violinist3;

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
        Queue<Thread> violinistThreadsQueue = new LinkedList<>();

        Queue<Integer> violins = new LinkedList<>();
        Queue<String> leashes = new LinkedList<>();

        for (int i = 0; i < 4 ; i++) {
            violins.add(i);
            leashes.add(i+"");
        }

        violins.add(9);

        Violins violinsObject = new Violins(violins, violinistThreadsQueue);
        Leashes leashesObject = new Leashes(leashes, violinistThreadsQueue);

        for (int i = 0; i < 12  ; i++) {
            violinists.add(new Violinist(violinsObject, leashesObject, violinistThreadsQueue));
        }
        for (int i = 0; i < 12  ; i++) {
            violinists.get(i).start();
        }
        for (int i = 0; i < 12  ; i++) {
            try {
                violinists.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All violinists has finished playing");






    }
}

package ua.epam.sergiishapoval.homework.hw10.violinist2;

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
        List<Thread> violinistsPlayed = new ArrayList<>();

        Queue<Integer> violins = new LinkedList<>();
        Queue<String> leashes = new LinkedList<>();

        for (int i = 0; i < 5 ; i++) {
            violins.add(i);
            leashes.add(""+i);
        }

        violins.add(9);

        Violins violinsObject = new Violins(violins);
        Leashes leashesObject = new Leashes(leashes, violinistsPlayed);

        for (int i = 0; i < 12 ; i++) {
            violinists.add(new Violinist(violinsObject, leashesObject, violinistsPlayed));
        }

/*
        for (int i = 0; i < 12  ; i++) {
            violinists.get(i).setDaemon(true);
        }
*/


        for (int i = 0; i < 12  ; i++) {
            violinists.get(i).start();
        }

/*

        CheckViolinist checkViolinist = new CheckViolinist(violinistsPlayed);
        checkViolinist.start();
        try {
            checkViolinist.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All violinists have played");
*/


    }
}

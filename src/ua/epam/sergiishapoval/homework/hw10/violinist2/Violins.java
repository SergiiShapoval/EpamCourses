package ua.epam.sergiishapoval.homework.hw10.violinist2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Сергей on 11.11.2014.
 */
public class Violins {
    volatile Queue<Integer> violins = new LinkedList<>();

    public Violins(Queue<Integer> violins) {
        this.violins = violins;
    }

    public synchronized Integer getViolin(){
        while (violins.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return violins.poll();
    }

    public synchronized void putViolin(Integer violinId){
        violins.offer(violinId);
        notifyAll();
    }
}

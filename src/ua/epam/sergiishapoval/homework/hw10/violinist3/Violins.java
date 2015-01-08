package ua.epam.sergiishapoval.homework.hw10.violinist3;

import java.util.Queue;

/**
 * Created by Сергей on 11.11.2014.
 */
public class Violins {
    Queue<Integer> violins;
    volatile Queue<Thread> violinistThreads;

    public Violins(Queue<Integer> violins, Queue<Thread> violinistThreads) {
        this.violins = violins;
        this.violinistThreads = violinistThreads;
    }

    public synchronized Integer getViolin(){
        try {
            while (violinistThreads.peek() != Thread.currentThread()) {
                    wait();
            }
            while (violins.isEmpty()){
                wait();
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        Integer violin = violins.poll();
        System.out.println(Thread.currentThread().getName() + " has taken violin " + violin);

        return violin;
    }

    public synchronized void putViolin(Integer violinId){
        violins.offer(violinId);
        System.out.println("Violin "+ violinId + " returned");
        notifyAll();
    }
}

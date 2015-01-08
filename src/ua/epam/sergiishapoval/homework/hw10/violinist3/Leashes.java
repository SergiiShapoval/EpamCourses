package ua.epam.sergiishapoval.homework.hw10.violinist3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Сергей on 11.11.2014.
 */
public class Leashes {

    Queue<String> leashes = new LinkedList<>();
    volatile Queue<Thread> violinistThreads;

    public Leashes(Queue<String> leashes, Queue<Thread> violinistThreads) {
        this.leashes = leashes;
        this.violinistThreads = violinistThreads;
    }

    public synchronized String getLeash(){
        try {
            while (violinistThreads.peek() != Thread.currentThread()) {
                wait();
            }
            while (leashes.isEmpty()){
                wait();
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        String leash = leashes.poll();
        violinistThreads.poll();
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " has taken leash " + leash);

        return leash;
    }

    public synchronized void putLeash(String leashId){
        leashes.offer(leashId);
        System.out.println("Leash " + leashId + " returned");
        notifyAll();
    }
}

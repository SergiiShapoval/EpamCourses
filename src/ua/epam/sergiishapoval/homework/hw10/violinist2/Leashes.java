package ua.epam.sergiishapoval.homework.hw10.violinist2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Сергей on 11.11.2014.
 */
public class Leashes {

    volatile Queue<String> leashes = new LinkedList<>();
    final List<Thread> violinistsPlayed;

    public Leashes(Queue<String> leashes, List<Thread> violinistsPlayed) {
        this.leashes = leashes;
        this.violinistsPlayed = violinistsPlayed;
    }

    public synchronized String getLeash(){
        while (leashes.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return leashes.poll();
    }

    public synchronized void putLeash(String leashId){
        leashes.offer(leashId);
/*
        synchronized (violinistsPlayed) {
            if (!violinistsPlayed.contains(Thread.currentThread())) {
                violinistsPlayed.put(Thread.currentThread());
            }
        }
*/
        notifyAll();
    }
}

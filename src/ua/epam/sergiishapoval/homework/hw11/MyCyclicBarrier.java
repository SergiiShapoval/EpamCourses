package ua.epam.sergiishapoval.homework.hw11;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Сергей on 13.11.2014.

 */
public class MyCyclicBarrier {

    volatile int maxThreads;
    Runnable additionalTask;

    public MyCyclicBarrier(int maxThreads) {
        this.maxThreads = maxThreads;
    }

    public MyCyclicBarrier(int maxThreads, Runnable additionalTask) {
        this.maxThreads = maxThreads;
        this.additionalTask = additionalTask;
    }

    public synchronized void await(){
        System.out.println(--maxThreads);

        if (additionalTask != null && maxThreads == 0){
            new Thread(additionalTask).start();
        }

        notifyAll();
        while (maxThreads > 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }



}

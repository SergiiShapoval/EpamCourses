package ua.epam.sergiishapoval.homework.hw10.violinist;

import java.util.Queue;

/**
 * Created by Сергей on 11.11.2014.
 */
public class Violinist extends Thread {

    volatile Queue<Integer> violins;
    volatile Queue<String> leashes;

    public Violinist(Queue<Integer> violins, Queue<String> leashes) {
        this.violins = violins;
        this.leashes = leashes;
    }

    @Override
    public void run() {

        try {
            while (!isInterrupted()) {
                Integer violin = null;
                String leash = null;

                synchronized (violins) {
                    while (violins.isEmpty()) {
                        violins.wait();
                    }
                    violin = violins.poll();
                }

                System.out.println(Thread.currentThread().getName() + " has taken violin");

                synchronized (leashes) {
                    while (leashes.isEmpty()){
                        leashes.wait();
                    }
                   leash = leashes.poll();
                }

                System.out.println(Thread.currentThread().getName() + " has taken leash");
                System.out.println(Thread.currentThread().getName() + " is playing");
                Thread.sleep(2000);

                synchronized (violins) {
                    violins.offer(violin);
                    violins.notifyAll();
                }
                System.out.println("Violin " + violin + "returned");

                synchronized (leashes) {
                    leashes.offer(leash);
                    leashes.notifyAll();

                }
                System.out.println("Leash " + leash + "returned");

                System.out.println(Thread.currentThread().getName() + " has finished playing");
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

    }
}

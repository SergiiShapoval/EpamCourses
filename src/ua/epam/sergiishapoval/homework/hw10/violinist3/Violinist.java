package ua.epam.sergiishapoval.homework.hw10.violinist3;

import java.util.Queue;

/**
 * Created by Сергей on 11.11.2014.
 */
public class Violinist extends Thread {

    Violins violins;
    Leashes leashes;
    volatile Queue<Thread> violinistThreads;

    public Violinist(Violins violins, Leashes leashes, Queue<Thread> violinistThreads) {
        this.violins = violins;
        this.leashes = leashes;
        this.violinistThreads = violinistThreads;
    }

    @Override
    public void run() {

        try {
            while (!isInterrupted()) {
                if (!violinistThreads.contains(this)) {
                    violinistThreads.offer(this);
                }

                Integer violin = null;
                String leash = null;
                violin = violins.getViolin();
                leash = leashes.getLeash();
                System.out.println(Thread.currentThread().getName() + " is playing");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " has finished playing");
                violins.putViolin(violin);
                leashes.putLeash(leash);

            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

    }
}

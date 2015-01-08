package ua.epam.sergiishapoval.homework.hw10.violinist2;

import java.util.List;

/**
 * Created by Сергей on 11.11.2014.
 */
public class Violinist extends Thread {

    volatile Violins violins;
    volatile Leashes leashes;
    volatile List<Thread> violinistsPlayed;

    public Violinist(Violins violins, Leashes leashes, List<Thread> violinistsPlayed) {
        this.violins = violins;
        this.leashes = leashes;
        this.violinistsPlayed = violinistsPlayed;
    }

    @Override
    public void run() {


        while (!isInterrupted()) {
            Integer violin = violins.getViolin();
            System.out.println(Thread.currentThread().getName() + " has taken violin " + violin);
            String leash = leashes.getLeash();
            System.out.println(Thread.currentThread().getName() + " has taken leash " + leash);
            System.out.println(Thread.currentThread().getName() + " is playing");
            try {
                Thread.sleep(200);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " has finished playing");


            violins.putViolin(violin);
            System.out.println("Violin " + violin + " returned");
            leashes.putLeash(leash);
            System.out.println("Leash " + leash + " returned");


                if (!violinistsPlayed.contains(Thread.currentThread())) {
                    violinistsPlayed.add(Thread.currentThread());
                }
                if (violinistsPlayed.size() == 12){
                    System.out.println("All violinists have played");
                    System.out.println(violinistsPlayed);
                    System.exit(1);
                }


        }


    }
}

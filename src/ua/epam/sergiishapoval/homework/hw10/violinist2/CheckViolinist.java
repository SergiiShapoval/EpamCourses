package ua.epam.sergiishapoval.homework.hw10.violinist2;

import java.util.List;

/**
 * Created by Сергей on 12.11.2014.
 */
public class CheckViolinist extends Thread {

    final List<Thread> violinistsPlayed;

    public CheckViolinist(List<Thread> violinistsPlayed) {
        this.violinistsPlayed = violinistsPlayed;
    }

    void checkViolinists(){
        synchronized (violinistsPlayed) {
            while (violinistsPlayed.size() < 3) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Override
    public void run() {
        checkViolinists();
    }
}

package ua.epam.sergiishapoval.homework.hw10.semaphore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергей on 11.11.2014.
 * 	2. Семафор  реализовать - первый попросил - первый получил;
 * 	(предусмотеть , чтобы release нельзя было вызвать
 * 	без acquire  (хранить очередь потоков))
 */
public class SemaphoreMain {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        MySemaphore mySemaphore = new MySemaphore(5);

        for (int i = 0; i < 10 ; i++) {
            threads.add(new SemaphoreThread(mySemaphore));
        }

        for (int i = 0; i < 10; i++) {
            threads.get(i).start();
        }

        try {
            Thread.sleep(45000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10; i++) {
            threads.get(i).interrupt();
        }


    }
}

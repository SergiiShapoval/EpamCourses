package ua.epam.sergiishapoval.homework.hw10.semaphore;

/**
 * Created by Сергей on 11.11.2014.
 */
public class SemaphoreThread extends Thread {
    MySemaphore mySemaphore;

    public SemaphoreThread(MySemaphore mySemaphore) {
        this.mySemaphore = mySemaphore;
    }

    @Override
    public void run() {

        while (! isInterrupted()) {
            try {
                mySemaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " is running");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }

            mySemaphore.release();
        }
    }
}

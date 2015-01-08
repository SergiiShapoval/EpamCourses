package ua.epam.sergiishapoval.lecturescodeonsite.lecture10112014;

/**
 * Created by Сергей on 10.11.2014.
 */
public class SemaphoreSimulation {
    int count;

    public SemaphoreSimulation(int value) {
        this.count = value;
    }
//    блокирует
    public synchronized void acquire() throws InterruptedException{
        while (count == 0) {
            wait();
        }
        count--;
    }
//    освобождает блокировку
    public void realase(){
        count++;
        notifyAll();
    }


}

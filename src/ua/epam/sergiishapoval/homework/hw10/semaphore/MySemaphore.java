package ua.epam.sergiishapoval.homework.hw10.semaphore;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Сергей on 11.11.2014.
 */
public class MySemaphore {

    int count;
    volatile Queue<Thread> acquiredThreads;
    volatile Queue<Thread> waitingThreads;

    public MySemaphore(int value) {
        this.count = value;
        acquiredThreads = new LinkedList<>();
        waitingThreads = new LinkedList<>();
    }
    //    блокирует
    public synchronized void acquire() throws InterruptedException{

        waitingThreads.offer(Thread.currentThread());
        while (waitingThreads.peek() != Thread.currentThread()) {
            wait();
        }
        while (count == 0) {
            wait();
        }
        acquiredThreads.offer(Thread.currentThread());
        count--;
        waitingThreads.poll();

    }
    //    освобождает блокировку
    public synchronized void release(){
        if (acquiredThreads.contains(Thread.currentThread())) {
            count++;
            acquiredThreads.remove(Thread.currentThread());
            notifyAll();
        } else {
            System.err.println("Current Thread haven't acquire before");
        }
    }
}

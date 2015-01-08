package ua.epam.sergiishapoval.homework.hw11;

/**
 * Created by Сергей on 13.11.2014.
 */
public class BarrierThread extends Thread {

    MyCyclicBarrier cyclicBarrier;

    public BarrierThread(String name, MyCyclicBarrier cyclicBarrier) {
        super(name);
        this.cyclicBarrier = cyclicBarrier;
        start();
    }

    @Override
    public void run() {
        cyclicBarrier.await();
        System.out.println(getName() + " continue work");
    }
}

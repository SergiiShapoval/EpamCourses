package ua.epam.sergiishapoval.homework.hw9.Puerto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергей on 13.11.2014.
 */
public class Puerto {

    private int dockQty;
    private int containersCapacity;
    private int currentContainersQty;

    List<Thread> ships = new ArrayList<>();

    public Puerto(int dockQty, int containersCapacity, int currentContainersQty) {
        this.dockQty = dockQty;
        this.containersCapacity = containersCapacity;
        this.currentContainersQty = currentContainersQty;
    }

    public int getContainersCapacity() {
        return containersCapacity;
    }

    public int getCurrentContainersQty() {
        return currentContainersQty;
    }

    public void addContainer() {
        currentContainersQty++;
    }
    public void takeConatiner() {
        currentContainersQty--;
    }


    public synchronized void askPermission(){
        while (dockQty == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ships.add(Thread.currentThread());
        System.out.println(Thread.currentThread().getName() + " has received permission");
        dockQty--;
    }

    public synchronized void returnPermission(){
// Time needed to go out from dock for ship
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " is leaving dock");

        System.out.println("Current containers Qty in Port: " + currentContainersQty);

        if (ships.contains(Thread.currentThread())) {
            dockQty++;
        }
        ships.remove(Thread.currentThread());



        notifyAll();
    }
}

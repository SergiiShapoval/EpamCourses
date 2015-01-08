package ua.epam.sergiishapoval.homework.hw10.restaurant;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Сергей on 13.11.2014.
 */

//takes order and cook it
public class Cook extends Thread{

    final Dish dish;
    Waiter waiter;

    Queue<Order> orders = new LinkedList<>();

    public Cook(String name, Dish dish, Waiter waiter) {
        super(name);
        this.dish = dish;
        this.waiter = waiter;
        setDaemon(true);
        start();
    }

    public synchronized void pathOrderToCook(Order order){
        orders.add(order);
        notifyAll();
    }



    @Override
    public void run() {
        while (true) {
            try {
                Order currentOrder = null;
                synchronized (this) {
                    while (orders.isEmpty()) {
                        wait();
                    }
                    currentOrder = orders.poll();
                }
                Thread.sleep(100*dish.getCookingTime());
                System.out.println (getName() + " has cooked " + dish );
                waiter.pathCookedDish(currentOrder, dish);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}

package ua.epam.sergiishapoval.homework.hw10.restaurant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергей on 13.11.2014.
 */


//create Order, wait for order, eat order, create order...
public class Table extends Thread{

    Waiter waiter;

    public Table(String name, Waiter waiter) {
        super(name);
        this.waiter = waiter;
        start();
    }

    List<Dish> cookedDishes = new ArrayList<>();

    public synchronized void putDishOnTable(Dish dish){
        cookedDishes.add(dish);
        notifyAll();
    }

    @Override
    public void run() {
        try {
//            while (true) {
                List<Dish> orderedDishes = new ArrayList<>();
                int currentOrderDishQty = (int) (1 + Math.random() * 5);
                for (int i = 0; i < currentOrderDishQty; i++) {
                    orderedDishes.add(Dish.values()[(int) (Math.random() * 3)]);
                }
                waiter.createOrder(orderedDishes);


                for (Dish dish: Dish.values()){
                    while (orderedDishes.contains(dish)){
                        synchronized (this) {
                            while (!cookedDishes.contains(dish)) {
                                wait();
                            }
                            cookedDishes.remove(dish);
                        }
                        Thread.sleep(100*dish.getTimeToEat());
                        orderedDishes.remove(dish);
                        System.out.println(getName() + " has eaten " + dish);
                    }
                }



//            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return getName();
    }
}

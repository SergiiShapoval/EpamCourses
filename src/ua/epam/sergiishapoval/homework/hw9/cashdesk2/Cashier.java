package ua.epam.sergiishapoval.homework.hw9.cashdesk2;

import java.util.Queue;

/**
 * Created by Сергей on 13.11.2014.
 */
public class Cashier extends Thread {

    volatile private Queue<Customer> customerQueue;

    public Cashier(String name, Queue<Customer> customerQueue) {
        super(name);
        this.customerQueue = customerQueue;
        this.setDaemon(true);
        start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Customer currentCustomer = null;
                synchronized (customerQueue) {
                    while (customerQueue.size() == 0) {
                        customerQueue.wait();
                    }
                    currentCustomer = customerQueue.poll();
                    customerQueue.notifyAll();
                }

                System.out.println(this + " have start to serve " + currentCustomer);
                Thread.sleep(500 * currentCustomer.getTaskQty());
                System.out.println(currentCustomer.getTaskQty()+ " tasks of " + currentCustomer + " was served by " + this);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return getName();
    }
}

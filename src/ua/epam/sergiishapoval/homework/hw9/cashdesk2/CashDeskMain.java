package ua.epam.sergiishapoval.homework.hw9.cashdesk2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Сергей on 13.11.2014.
 * Разработать многопоточное приложение. Все сущности, желающие получить доступ к ресурсу,
 * должны быть потоками.
 * Использовать возможности ООП.
 * 6.	 Свободная касса. В ресторане быстрого обслуживания
 * есть несколько касс. Посетители стоят в очереди в конкретную кассу,
 * но могут перейти  в другую очередь при уменьшении или исчезновении там очереди
 */
public class CashDeskMain {
    public static void main(String[] args) throws InterruptedException {
        List<Cashier> cashiers = new LinkedList<>();
        Queue<Customer> customers = new LinkedList<Customer>();

        for (int i = 0; i < 3; i++) {
            cashiers.add(new Cashier("Cashier "+ i, customers));
        }

        for (int i = 0; i < 10; i++) {
            synchronized (customers) {
                customers.add(new Customer("Customer " + i, 1 + (int) (9 * Math.random())));
                customers.notifyAll();
            }
        }

        synchronized (customers){
            while (!customers.isEmpty()){
                customers.wait();
            }
        }

        System.out.println("All customers have been served");


    }
}

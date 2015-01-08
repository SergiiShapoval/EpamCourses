package ua.epam.sergiishapoval.homework.hw9.cashdesk1;

import java.util.LinkedList;
import java.util.List;

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
        List<Customer> customers = new LinkedList<Customer>();

        for (int i = 0; i < 3; i++) {
            cashiers.add(new Cashier("Cashier "+ i));
        }

        for (int i = 0; i < 10; i++) {
            customers.add(new Customer("Customer " + i, cashiers, 1 +  (int) (9 * Math.random())));
        }

        for (Customer customer : customers){
            customer.join();
        }

        System.out.println("All customers have been served");


    }
}

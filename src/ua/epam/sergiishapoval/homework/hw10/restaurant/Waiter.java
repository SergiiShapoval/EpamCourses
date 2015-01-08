package ua.epam.sergiishapoval.homework.hw10.restaurant;

import java.util.List;
import java.util.Map;

/**
 * Created by Сергей on 13.11.2014.
 */

//distribute orders, bring orders to customer, when they are done

public class Waiter {

    Map<Dish, Cook> cooks;

    public Waiter(Map<Dish, Cook> cooks) {
        this.cooks = cooks;
    }

//    List<Order> orders = new ArrayList<>();

    public void createOrder(List<Dish> dishes){
        Table currentTable = (Table) Thread.currentThread();
        Order currentOrder = new Order(currentTable, dishes);
//        orders.add(currentOrder);
        System.out.println("Waiter has received next order " + dishes + " from " + currentTable);
        distributeOrder(currentOrder);
    }

    public void distributeOrder(Order order){
        for (Dish dish:order.getOrderList()){
            cooks.get(dish).pathOrderToCook(order);
        }
    }

    public void pathCookedDish(Order order, Dish dish){
        System.out.println("Waiter has passed " + dish + " to " + order.getOrderTable());
        order.getOrderTable().putDishOnTable(dish);
    }


}

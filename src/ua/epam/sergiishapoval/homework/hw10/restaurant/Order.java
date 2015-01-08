package ua.epam.sergiishapoval.homework.hw10.restaurant;

import java.util.List;

/**
 * Created by Сергей on 13.11.2014.
 */
//contains information about dishes and Table
public class Order {

    private Table orderTable;
    private List<Dish> orderList;

    public Order(Table orderTable, List<Dish> orderList) {
        this.orderTable = orderTable;
        this.orderList = orderList;
    }

    public Table getOrderTable() {
        return orderTable;
    }

    public List<Dish> getOrderList() {
        return orderList;
    }


}

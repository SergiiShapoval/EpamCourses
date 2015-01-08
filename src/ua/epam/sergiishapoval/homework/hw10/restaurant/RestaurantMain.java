package ua.epam.sergiishapoval.homework.hw10.restaurant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Сергей on 11.11.2014.
 * 1.	Система ресторан. В ресторане n столиков за каждым столиком сидит клиент.
 * Клиент делает заказ из трех блюд Борщ,Торт, Кофе.
 * Клиент начинает обедает в последовательности Борщ->Торт->Кофе.
 * Также в ресторане есть три повара.
 * Один готовит борщи. Второй- торты. Третий-кофе.
 */
public class RestaurantMain {
    public static void main(String[] args) {

        Map<Dish, Cook> cooksMap = new HashMap<>();
        Waiter waiter = new Waiter(cooksMap);
        for (int i = 0; i < 3; i++) {
            Dish currentDish = Dish.values()[i];
            cooksMap.put(currentDish, new Cook("Cook "+ i,currentDish , waiter));
        }

        for (int i = 0; i < 10; i++) {
            new Table("Table "+ i, waiter);
        }

    }
}

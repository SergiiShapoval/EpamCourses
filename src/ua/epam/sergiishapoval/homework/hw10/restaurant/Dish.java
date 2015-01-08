package ua.epam.sergiishapoval.homework.hw10.restaurant;

/**
 * Created by Сергей on 13.11.2014.
 */
public enum Dish {

    BORCH(15, 7), CAKE(35, 4), CAFE(5, 2);
    int cookingTime;
    int timeToEat;

    Dish(int cookingTime, int timeToEat) {
        this.cookingTime = cookingTime;
        this.timeToEat = timeToEat;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public int getTimeToEat() {
        return timeToEat;
    }
}

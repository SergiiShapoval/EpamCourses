/***********************************************************************
 * Module:  Sensor.java
 * Author:  Сергей
 * Purpose: Defines the Class Sensor
 ***********************************************************************/

package ua.epam.sergiishapoval.homework.hw13.washingMachine.model;

import java.util.*;

/** @pdOid 2241cb88-12f1-4d89-b836-814ae7b12a1f */
public enum Sensor {
    DETERGENT1_SENSOR,
    DETERGENT2_SENSOR,
    DETERGENT3_SENSOR,
    WATER_SENSOR,
    LINEN_SENSOR;

    int currentWeight;

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

}
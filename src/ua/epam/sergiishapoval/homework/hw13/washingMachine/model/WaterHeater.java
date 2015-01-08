/***********************************************************************
 * Module:  WaterHeater.java
 * Author:  Сергей
 * Purpose: Defines the Class WaterHeater
 ***********************************************************************/

package ua.epam.sergiishapoval.homework.hw13.washingMachine.model;

import java.util.*;

/** @pdOid debacc34-9cf1-4cb0-98f6-79fdcfd7cb46 */
public class WaterHeater {

    /** @pdOid 9557139c-38e6-4ffa-97ca-c6a8d5aba2c4 */
    class Thermometer {

        int temperature;

        public void setTemperature(int temperature) {
            this.temperature = temperature;
        }



    }

    private Thermometer thermometer = new Thermometer();

    public WaterHeater() {
    }

    public void heatWater(int temperature){
        thermometer.setTemperature(temperature);
    }


}
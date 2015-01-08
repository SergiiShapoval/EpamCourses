/***********************************************************************
 * Module:  WashingPrograms.java
 * Author:  Сергей
 * Purpose: Defines the Class WashingPrograms
 ***********************************************************************/

package ua.epam.sergiishapoval.homework.hw13.washingMachine.view;

/** @pdOid 9b4df20f-8917-4894-b206-5c00289726e4 */
public enum WashingProgram {

    COLD_WASHING(10, 25, new int[]{-1,5, 15}, 20, 25),
    HOT_WASHING(60, 30, new int[]{5, 15, 7}, 30, 20),
    GENTLE_WASH(20, 30, new int[]{-1, 5, 15}, 10, 5),
    DEEP_WASH(10, 25, new int[]{-1, 5, 15}, 20, 25),
    EXPRESS(25, 15, new int[]{-1,5,-1}, 30, 50);


    WashingProgram(int temperature, int washingtime,  int[] detergentsTime, int washingVelocity, int drainVelocity) {
        this.temperature = temperature;
        this.washingtime = washingtime;
        this.detergentsTime = detergentsTime;
        this.washingVelocity = washingVelocity;
        this.drainVelocity = drainVelocity;
    }

    int temperature;
    int washingtime;

    int[] detergentsTime;
    int washingVelocity;
    int drainVelocity;

    public int getTemperature() {
        return temperature;
    }

    public int getWashingtime() {
        return washingtime;
    }


    public int[] getDetergentsTime() {
        return detergentsTime;
    }

    public int getWashingVelocity() {
        return washingVelocity;
    }

    public int getDrainVelocity() {
        return drainVelocity;
    }
}
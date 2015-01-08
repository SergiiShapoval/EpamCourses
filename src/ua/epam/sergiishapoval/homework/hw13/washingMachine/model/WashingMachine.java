/***********************************************************************
 * Module:  WashingMachine.java
 * Author:  Сергей
 * Purpose: Defines the Class WashingMachine
 ***********************************************************************/

package ua.epam.sergiishapoval.homework.hw13.washingMachine.model;

import ua.epam.sergiishapoval.homework.hw13.washingMachine.view.IndicatorPanel;
import ua.epam.sergiishapoval.homework.hw13.washingMachine.view.WashingMachineState;
import ua.epam.sergiishapoval.homework.hw13.washingMachine.view.WashingProgram;

import java.util.EnumSet;


/** @pdOid 1b402992-d520-4fa9-8ca0-a617c46e01b0 */
public class WashingMachine {


    private WashingProgram washingProgram = WashingProgram.EXPRESS;

    private IndicatorPanel indicatorPanel;
    private WaterHeater heater;
    private Timer timer;
    private Controller[] controllers;
    private EnumSet<Sensor> sensors;

    public WashingMachine(IndicatorPanel indicatorPanel, WaterHeater heater, Timer timer, Controller[] controllers, EnumSet<Sensor> sensors) {
        this.indicatorPanel = indicatorPanel;
        this.heater = heater;
        this.timer = timer;
        this.controllers = controllers;
        this.sensors = sensors;
    }

    public WashingMachine(WaterHeater heater, IndicatorPanel indicatorPanel) {

    }

    public void setWashingProgram(WashingProgram washingProgram) {
        this.washingProgram = washingProgram;
    }

    public void start(){
        verifyProcess();
        prepareWater();
        executeWashing();
        finalizeWashing();
    }

    public void shutDown(){
        finalizeWashing();
    }

    private void finalizeWashing() {
        indicatorPanel.switchState(WashingMachineState.SPINNING);
        indicatorPanel.switchState(WashingMachineState.OFF);
    }


    private void executeWashing() {
        indicatorPanel.switchState(WashingMachineState.WASHING);
        timer.countDown();
    }

    private void prepareWater() {
        heater.heatWater(washingProgram.getTemperature());
    }

    private void verifyProcess(){
        indicatorPanel.switchOn();
        indicatorPanel.switchState(WashingMachineState.VERIFYING);
        indicatorPanel.setProgram(washingProgram);
    }

}
/***********************************************************************
 * Module:  IndicatorPanel.java
 * Author:  Сергей
 * Purpose: Defines the Class IndicatorPanel
 ***********************************************************************/

package ua.epam.sergiishapoval.homework.hw13.washingMachine.view;

/** @pdOid a8e4225b-f388-41b0-ba22-cc18a40a28aa */
public class IndicatorPanel {
    WashingMachineState state = WashingMachineState.OFF;

    private long shownTime;

    WashingProgram program;

    public void switchState(WashingMachineState state) {
        this.state = state;
    }

    public void switchOn(){}

    public void setProgram(WashingProgram program) {
        this.program = program;
    }

    public void setShownTime(long shownTime) {
        this.shownTime = shownTime;
    }
}
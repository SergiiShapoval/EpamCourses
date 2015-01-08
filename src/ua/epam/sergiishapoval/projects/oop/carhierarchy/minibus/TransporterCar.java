package ua.epam.sergiishapoval.projects.oop.carhierarchy.minibus;

import ua.epam.sergiishapoval.projects.oop.interfaces.BigPassengerOrder;

/**
 * Created by Сергей on 25.10.2014.
 */
public class TransporterCar extends MiniBusCar implements BigPassengerOrder {

    public TransporterCar(String brand, String model, String carID,
                          double fuelConsumption, double velocity, double maxCarryingWeight) {
        this.brand = brand;
        this.model = model;
        this.carID = carID;
        this.fuelConsumption = fuelConsumption;
        this.velocity = velocity;
        this.maxCarryingWeight = maxCarryingWeight;
        this.maxPassengers = 25;
    }
}

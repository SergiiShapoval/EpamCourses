package ua.epam.sergiishapoval.projects.oop.carhierarchy.family;

import ua.epam.sergiishapoval.projects.oop.interfaces.MediumOrder;

/**
 * Created by Сергей on 25.10.2014.
 */
public class UniversalCar extends FamilyCar implements MediumOrder {

    public UniversalCar (String brand, String model, String carID,
                         double fuelConsumption, double velocity,
                         double maxCarryingWeight, int maxPassengers) {
        this.brand = brand;
        this.model = model;
        this.carID = carID;
        this.fuelConsumption = fuelConsumption;
        this.velocity = velocity;
        this.maxCarryingWeight = maxCarryingWeight;
        this.maxPassengers = maxPassengers;
        this.doors = 5;
    }
}

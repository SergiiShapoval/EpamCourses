package ua.epam.sergiishapoval.projects.oop.carhierarchy.minibus;

import ua.epam.sergiishapoval.projects.oop.interfaces.BigParcelOrder;

/**
 * Created by Сергей on 25.10.2014.
 */
public class CarrierCar extends MiniBusCar implements BigParcelOrder {


    public CarrierCar(String brand, String model, String carID,
                      double fuelConsumption, double velocity,
                      double maxCarryingWeight,  int maxPassengers) {
        this.brand = brand;
        this.model = model;
        this.carID = carID;
        this.fuelConsumption = fuelConsumption;
        this.velocity = velocity;
        this.maxCarryingWeight = maxCarryingWeight;
        this.maxPassengers = maxPassengers;
    }

}

package ua.epam.sergiishapoval.projects.oop.carhierarchy;

/**
 * Created by Сергей on 24.10.2014.
 *
 *
 * фургон - способность возить большие грузы
 * или много пассажиров - микроавтобус,
 * к-во пассажиров,
 * к-во дверей
 * универсал и возить и пассажиры
 * хетчбек
 * седан
 */

public abstract class Car {
    protected String brand;
    protected String model;
    protected String carID;
    protected String location;

    protected double fuelConsumption;
    protected double price;
    protected double velocity;
    protected double maxCarryingWeight;

    protected int maxPassengers;
    protected int doors;

    protected boolean isLightsOn = false;

    protected Car() {
    }

/*
                getters and setters
*/
    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

/*
    getters
*/

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getVelocity() {
        return velocity;
    }

    public double getMaxCarryingWeight() {
        return maxCarryingWeight;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public int getDoors() {
        return doors;
    }

    public boolean isLightsOn() {
        return isLightsOn;
    }

/*
    methods
*/

    void move( String destination){
        System.out.printf("%s has moved from %s to %s", carID, location, destination);
        System.out.println();
        location = destination;
    }

    void lightsOn(){
        isLightsOn = true;
    }

    void lightsOff(){
        isLightsOn = false;
    }

    void beep(){
        System.out.println("Beee-e-ep!!!");
    }

    double takeParcels (double parcelWeight){
        if (parcelWeight <= maxCarryingWeight) {
            return 0;
        } else {
            return parcelWeight - maxCarryingWeight;
        }
    }

    int takePassengers (int passengersQty){
        if (passengersQty <= maxPassengers) {
            return 0;
        } else {
            return passengersQty - maxPassengers;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", brand, model, carID);
    }
}

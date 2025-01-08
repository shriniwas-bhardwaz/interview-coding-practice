package LowLevelDesign.DesignPatterns.StrategyDesignPattern.VehicleStrategy;

public class SportsVehicle extends Vehicle {

    SportsVehicle() {
        super(new SportsDriveStrategy());
    }
}

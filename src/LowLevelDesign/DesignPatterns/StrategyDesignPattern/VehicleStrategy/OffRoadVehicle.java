package LowLevelDesign.DesignPatterns.StrategyDesignPattern.VehicleStrategy;

public class OffRoadVehicle extends Vehicle {

    OffRoadVehicle() {
        super(new SportsDriveStrategy());
    }
}

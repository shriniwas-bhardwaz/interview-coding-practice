package LowLevelDesign.DesignPatterns.StrategyDesignPattern.VehicleStrategy;

public class Vehicle {

    DriveStrategy driveObject;

    Vehicle(DriveStrategy driveObj) {
        this.driveObject = driveObj;
    }

    public void drive() {
        driveObject.drive();
    }
}

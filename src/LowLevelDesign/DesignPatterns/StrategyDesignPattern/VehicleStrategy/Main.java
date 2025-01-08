package LowLevelDesign.DesignPatterns.StrategyDesignPattern.VehicleStrategy;

public class Main {

    public static void main(String[] args) {
        Vehicle vehicle = new SportsVehicle();
        vehicle.drive();
    }
}

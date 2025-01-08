package LowLevelDesign.DesignPatterns.StrategyDesignPattern.VehicleStrategy;

public class GoodsVehicle extends Vehicle {

    GoodsVehicle() {
        super(new NormalDriveStrategy());
    }
}

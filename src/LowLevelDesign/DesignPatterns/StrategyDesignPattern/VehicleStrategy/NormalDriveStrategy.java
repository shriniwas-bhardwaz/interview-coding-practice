package LowLevelDesign.DesignPatterns.StrategyDesignPattern.VehicleStrategy;

public class NormalDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Normal Drive capabiliy");
    }
}

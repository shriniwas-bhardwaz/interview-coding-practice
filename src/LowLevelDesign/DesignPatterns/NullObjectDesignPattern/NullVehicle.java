package LowLevelDesign.DesignPatterns.NullObjectDesignPattern;

public class NullVehicle implements Vehicle {
    @Override
    public int getSeatingCapacity() {
        return 0;
    }

    @Override
    public int getTankCapacity() {
        return 0;
    }
}

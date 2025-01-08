package LowLevelDesign.DesignPatterns.NullObjectDesignPattern;

public class Main {

    public static void main(String[] args) {
        Vehicle vehicle = VehicleFactory.getVehicleObject("Bike");
        System.out.println(vehicle.getSeatingCapacity() + vehicle.getTankCapacity());
    }
}

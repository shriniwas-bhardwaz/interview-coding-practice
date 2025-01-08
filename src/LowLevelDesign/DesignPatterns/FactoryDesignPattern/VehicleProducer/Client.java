package LowLevelDesign.DesignPatterns.FactoryDesignPattern.VehicleProducer;

public class Client {

    private Vehicle vehicle;

    public Client(VehicleFactory factory) {
        this.vehicle = factory.createVehicle();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}

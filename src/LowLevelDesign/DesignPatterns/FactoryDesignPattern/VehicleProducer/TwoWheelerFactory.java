package LowLevelDesign.DesignPatterns.FactoryDesignPattern.VehicleProducer;

public class TwoWheelerFactory implements VehicleFactory{
    @Override
    public Vehicle createVehicle() {
        return new TwoWheeler();
    }
}

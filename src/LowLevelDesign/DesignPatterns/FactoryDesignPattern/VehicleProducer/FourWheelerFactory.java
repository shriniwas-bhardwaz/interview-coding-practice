package LowLevelDesign.DesignPatterns.FactoryDesignPattern.VehicleProducer;

public class FourWheelerFactory implements VehicleFactory{
    @Override
    public Vehicle createVehicle() {
        return new FourWheeler();
    }
}

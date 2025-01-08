package LowLevelDesign.DesignPatterns.StrategyDesignPattern.TravelPlanning;

public class Plane implements TransportationStrategy{
    @Override
    public String travel() {
        return "Travelling by Plane";
    }
}

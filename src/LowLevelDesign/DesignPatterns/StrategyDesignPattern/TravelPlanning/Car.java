package LowLevelDesign.DesignPatterns.StrategyDesignPattern.TravelPlanning;

public class Car implements TransportationStrategy{
    @Override
    public String travel() {
        return "Travelling by Car";
    }
}

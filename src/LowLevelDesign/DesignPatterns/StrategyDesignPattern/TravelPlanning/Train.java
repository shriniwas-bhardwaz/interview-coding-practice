package LowLevelDesign.DesignPatterns.StrategyDesignPattern.TravelPlanning;

public class Train implements TransportationStrategy{
    @Override
    public String travel() {
        return "Travelling By Train";
    }
}

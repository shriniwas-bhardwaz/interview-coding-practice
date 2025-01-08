package LowLevelDesign.DesignPatterns.StrategyDesignPattern.TravelPlanning;

public class Traveller {

    private TransportationStrategy transportationStrategy;

    public Traveller(TransportationStrategy transportationStrategy) {
        this.transportationStrategy = transportationStrategy;
    }

    public void setTransportationStrategy(TransportationStrategy transportationStrategy) {
        this.transportationStrategy = transportationStrategy;
    }
    public String travel() {
        return transportationStrategy.travel();
    }
}

package LowLevelDesign.DesignPatterns.StrategyDesignPattern.TravelPlanning;

public class Main {

    public static void main(String[] args) {

        Traveller traveller = new Traveller(new Plane());
        System.out.println(traveller.travel());

        System.out.println("Flight Cancelled");
        traveller.setTransportationStrategy(new Train());

        System.out.println(traveller.travel());
        System.out.println("Train missed");

        traveller.setTransportationStrategy(new Car());
        System.out.println(traveller.travel());
    }
}

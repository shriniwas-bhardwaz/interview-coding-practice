package LowLevelDesign.DesignPatterns.FactoryDesignPattern.ProductCreator;

public class ConcreteProductA implements Product{
    @Override
    public void display() {
        System.out.println("ConcreteProductA");
    }
}

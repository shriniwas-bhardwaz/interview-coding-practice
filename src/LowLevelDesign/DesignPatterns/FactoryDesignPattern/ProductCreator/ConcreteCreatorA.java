package LowLevelDesign.DesignPatterns.FactoryDesignPattern.ProductCreator;

public class ConcreteCreatorA implements Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}

package LowLevelDesign.DesignPatterns.FactoryDesignPattern.ProductCreator;

public class ConcreteCreatorB implements Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductB();
    }
}

package LowLevelDesign.DesignPatterns.FactoryDesignPattern.ProductCreator;

public class CreatorFactory {

    public static Creator getCreator(String productType) {

        switch (productType) {
            case "A":
                return new ConcreteCreatorA();
            case "B":
                return new ConcreteCreatorB();
            default: throw new IllegalArgumentException("Unknown product type: " + productType);
        }
    }
}
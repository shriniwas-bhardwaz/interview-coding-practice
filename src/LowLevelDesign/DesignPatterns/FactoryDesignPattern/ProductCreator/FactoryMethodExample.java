package LowLevelDesign.DesignPatterns.FactoryDesignPattern.ProductCreator;

import java.util.Scanner;

public class FactoryMethodExample {
    public static void main(String[] args) {

        /*Creator creatorA = new ConcreteCreatorA();
        Product productA = creatorA.factoryMethod();
        productA.display();

        Creator creatorB = new ConcreteCreatorB();
        Product productB = creatorB.factoryMethod();
        productB.display(); */

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the type of product you want to create (A/B):");
        String type = scanner.nextLine().toUpperCase();

        Creator creator = CreatorFactory.getCreator(type);
        Product product =  creator.factoryMethod();
        product.display();

        scanner.close();
    }
}

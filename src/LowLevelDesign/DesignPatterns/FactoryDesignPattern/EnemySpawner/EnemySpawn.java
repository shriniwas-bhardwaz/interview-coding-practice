package LowLevelDesign.DesignPatterns.FactoryDesignPattern.EnemySpawner;

import java.util.Scanner;

public class EnemySpawn {

    public static void main(String[] args) {

        System.out.println("Enter difficulty level");
        Scanner sc = new Scanner(System.in);
        String difficulty = sc.nextLine();

        Enemy enemy = EnemyFactory.getEnemy(difficulty);
        System.out.println(enemy.getClass().getSimpleName());
        System.out.println(enemy.getHealth());
        System.out.println(enemy.getSpeed());
        System.out.println(enemy.getAttackPower());
    }
}

package LowLevelDesign.DesignPatterns.FactoryDesignPattern.EnemySpawner;

public class Zombie implements Enemy{
    @Override
    public int getHealth() {
        return 50;
    }

    @Override
    public int getSpeed() {
        return 2;
    }

    @Override
    public int getAttackPower() {
        return 10;
    }
}

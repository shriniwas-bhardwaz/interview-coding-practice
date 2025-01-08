package LowLevelDesign.DesignPatterns.FactoryDesignPattern.EnemySpawner;

public class Vampire implements Enemy{
    @Override
    public int getHealth() {
        return 30;
    }

    @Override
    public int getSpeed() {
        return 4;
    }

    @Override
    public int getAttackPower() {
        return 15;
    }
}

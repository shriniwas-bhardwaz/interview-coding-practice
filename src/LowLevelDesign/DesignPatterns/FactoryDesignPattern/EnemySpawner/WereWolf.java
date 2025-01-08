package LowLevelDesign.DesignPatterns.FactoryDesignPattern.EnemySpawner;

public class WereWolf implements Enemy {
    @Override
    public int getHealth() {
        return 80;
    }

    @Override
    public int getSpeed() {
        return 6;
    }

    @Override
    public int getAttackPower() {
        return 25;
    }
}

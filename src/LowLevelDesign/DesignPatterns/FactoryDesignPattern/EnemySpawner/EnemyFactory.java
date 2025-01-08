package LowLevelDesign.DesignPatterns.FactoryDesignPattern.EnemySpawner;



public class EnemyFactory {

    public static Enemy getEnemy(String difficulty) {
        switch(difficulty.toUpperCase()) {
            case "EASY" : return new Zombie();
            case "MEDIUM" : return new Vampire();
            case "HARD" : return new WereWolf();
            default: throw new IllegalArgumentException("Unknown Level : " + difficulty);
        }
    }
}

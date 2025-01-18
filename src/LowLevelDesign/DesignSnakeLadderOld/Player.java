package LowLevelDesign.DesignSnakeLadderOld;

public class Player {
    String name;
    int currentPosition;

    Player(String name, int currentPosition) {
        this.name = name;
        this.currentPosition = currentPosition;
    }

    public String getName() {
        return this.name;
    }
    public int getCurrentPosition() {
        return this.currentPosition;
    }
}

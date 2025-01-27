package LowLevelDesign.DesignSnakeAndLadder;


// Used to notify players about their turns.
public interface Observer {
    void update(String message);
}

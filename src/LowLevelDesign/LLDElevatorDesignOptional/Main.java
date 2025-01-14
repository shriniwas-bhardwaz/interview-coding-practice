package LowLevelDesign.LLDElevatorDesignOptional;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        List<Floor> floorList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            floorList.add(new Floor(i));
        }

        Building building = new Building(floorList);

        // Simulate button presseElevatorSystems
        floorList.get(0).pressButton(Direction.UP); // Floor 1 requests UP
        floorList.get(1).pressButton(Direction.DOWN); // Floor 2 requests DOWN
        floorList.get(2).pressButton(Direction.UP); // Floor 3 requests UP

        // Start elevator control
        for (ElevatorController controller : ElevatorCreator.elevatorControllerList) {
            new Thread(() -> controller.controlElevator()).start();
        }
    }
}
package LowLevelDesign.ElevatorSystemDesignMain.algorithm;



import LowLevelDesign.ElevatorSystemDesignMain.model.Direction;
import LowLevelDesign.ElevatorSystemDesignMain.model.ElevatorController;
import LowLevelDesign.ElevatorSystemDesignMain.model.ElevatorSystem;

import java.util.List;

public class ElevatorSelectionStrategy {
    protected List<ElevatorController> elevatorControllerList = ElevatorSystem.INSTANCE.getElevatorControllerList();


    public int selectElevator(int floor, Direction dir) {
        return 0;
    }
}

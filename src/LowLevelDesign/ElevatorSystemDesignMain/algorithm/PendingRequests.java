package LowLevelDesign.ElevatorSystemDesignMain.algorithm;

import LowLevelDesign.ElevatorSystemDesignMain.model.Direction;
import lombok.Getter;


@Getter
public class PendingRequests {
    private int floor;
    private Direction dir;

    public  PendingRequests(int floor, Direction dir)
    {
        this.floor= floor;
        this.dir= dir;
    }

}

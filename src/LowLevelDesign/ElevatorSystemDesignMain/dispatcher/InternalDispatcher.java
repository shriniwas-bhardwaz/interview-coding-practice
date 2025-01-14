package LowLevelDesign.ElevatorSystemDesignMain.dispatcher;


import LowLevelDesign.ElevatorSystemDesignMain.model.Direction;
import LowLevelDesign.ElevatorSystemDesignMain.model.ElevatorController;
import LowLevelDesign.ElevatorSystemDesignMain.model.ElevatorSystem;

public class InternalDispatcher {

    public  void submitRequest(int floor, Direction dir, int elevatorId)
    {
        for(ElevatorController eController: ElevatorSystem.INSTANCE.getElevatorControllerList())
        {
            if(eController.getId()== elevatorId)
            {
                eController.acceptRequest(floor, dir);
            }
        }
    }
}

package LowLevelDesign.DesignParkingLot.parking;

import java.util.List;

public abstract class ParkingStrategy {
    public abstract ParkingSpace park(List<ParkingSpace> availableSpaces);
}

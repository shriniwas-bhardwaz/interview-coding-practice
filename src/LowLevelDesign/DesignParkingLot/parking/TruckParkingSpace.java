package LowLevelDesign.DesignParkingLot.parking;

public class TruckParkingSpace extends ParkingSpace{
    public TruckParkingSpace(String spaceId) {
        super(spaceId, ParkingSpaceType.TruckParking);
    }
}

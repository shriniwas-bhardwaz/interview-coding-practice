package LowLevelDesign.DesignParkingLot.parking;


import LowLevelDesign.DesignParkingLot.vehicle.Vehicle;
import lombok.Getter;

@Getter
public class EntryGate {
    private String gateId;

    public EntryGate(String gateId){
        this.gateId= gateId;
    }

    public Ticket generateTicket(Vehicle v){
        if(!ParkingLot.INSTANCE.isParkingSpaceAvailable(v.getVType()))
            return null;


        ParkingSpace pSpace= ParkingLot.INSTANCE.findParkingSpace(v);
        pSpace.parkVehicle(v);
        return new Ticket(v, pSpace);
    }
}

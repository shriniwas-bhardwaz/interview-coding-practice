package LowLevelDesign.DesignParkingLot.vehicle;

import lombok.Getter;

@Getter
public abstract class Vehicle {
    private String regNum;
    private VehicleType vType;


    public Vehicle(String regNum, VehicleType vType)
    {
        this.regNum= regNum;
        this.vType= vType;
    }

}

package model;

public class RadarData {
    private final String plateNumber;
    private final VehicleType vehicleType;
    private final int currentSpeed;
    private final boolean beltFastened;

    public RadarData(String plateNumber, VehicleType vehicleType, int currentSpeed, boolean beltFastened) {
        this.plateNumber = plateNumber;
        this.vehicleType = vehicleType;
        this.currentSpeed = currentSpeed;
        this.beltFastened = beltFastened;
    }

    public String getPlateNumber() { return plateNumber; }
    public VehicleType getVehicleType() { return vehicleType; }
    public int getCurrentSpeed() { return currentSpeed; }
    public boolean isBeltFastened() { return beltFastened; }
}
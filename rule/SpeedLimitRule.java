package rule;

import model.RadarData;
import model.VehicleType;
import model.Violation;

public class SpeedLimitRule implements ViolationRule {
    private final VehicleType targetVehicleType;
    private final int allowedSpeed;
    private final int fineAmount;

    public SpeedLimitRule(VehicleType targetVehicleType, int allowedSpeed, int fineAmount) {
        this.targetVehicleType = targetVehicleType;
        this.allowedSpeed = allowedSpeed;
        this.fineAmount = fineAmount;
    }

    @Override
    public String getRuleIdentifier() {
        return targetVehicleType + " Speed Violation";
    }

    @Override
    public Violation inspect(RadarData data) {
        if (data.getVehicleType() == targetVehicleType && data.getCurrentSpeed() > allowedSpeed) {
            String details = "speed of " + data.getCurrentSpeed() + " exceeded max allowed " + allowedSpeed;
            return new Violation(details, fineAmount);
        }
        return null;
    }
}
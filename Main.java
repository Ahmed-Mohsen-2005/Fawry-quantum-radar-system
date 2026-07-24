import core.Radar;
import model.RadarData;
import model.VehicleType;
import rule.SafetyBeltRule;
import rule.SpeedLimitRule;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Radar radar = new Radar();

        radar.registerRule(new SpeedLimitRule(VehicleType.Truck, 60, 300));
        radar.registerRule(new SpeedLimitRule(VehicleType.Private, 80, 300));
        radar.registerRule(new SpeedLimitRule(VehicleType.Bus, 70, 300));
        radar.registerRule(new SafetyBeltRule(100));

        RadarData vehicle1 = new RadarData("GAD2324", VehicleType.Private, 94, false);
        radar.processRadarData(vehicle1);

        RadarData vehicle2 = new RadarData("TRK9999", VehicleType.Truck, 72, true);
        radar.processRadarData(vehicle2);

        RadarData vehicle3 = new RadarData("OK5555", VehicleType.Private, 75, true);
        radar.processRadarData(vehicle3);

        List<String> fines = radar.getAllFines();
        for (String f : fines) {
            System.out.println(f);
        }

        Map<String, Integer> stats = radar.getViolatedRulesWithCount();
        for (Map.Entry<String, Integer> entry : stats.entrySet()) {
            System.out.println(entry.getKey() + " -> Count: " + entry.getValue());
        }
    }
}
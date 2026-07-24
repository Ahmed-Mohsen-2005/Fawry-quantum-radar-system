package core;

import model.RadarData;
import model.Ticket;
import model.Violation;
import rule.ViolationRule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Radar {
    private final List<ViolationRule> activeRules = new ArrayList<>();
    private final List<Ticket> issuedTickets = new ArrayList<>();
    private final Map<String, Integer> violationStatistics = new HashMap<>();

    public void registerRule(ViolationRule rule) {
        activeRules.add(rule);
    }

    public void processRadarData(RadarData data) {
        List<Violation> detectedViolations = new ArrayList<>();
        for (ViolationRule rule : activeRules) {
            Violation violation = rule.inspect(data);
            if (violation != null) {
                detectedViolations.add(violation);
                violationStatistics.put(
                    rule.getRuleIdentifier(),
                    violationStatistics.getOrDefault(rule.getRuleIdentifier(), 0)+1
                );
            }
        }

        if (!detectedViolations.isEmpty()) {
            Ticket ticket = new Ticket(data.getPlateNumber(), detectedViolations);
            issuedTickets.add(ticket);
            ticket.displayTicket();
        }
    }

    public List<String> getAllFines() {
        List<String> result = new ArrayList<>();
        for (Ticket ticket : issuedTickets) {
            result.add(ticket.getPlateNumber() + " with total amount: " + ticket.calculateTotalCost() + " EGP");
        }
        return result;
    }

    public Map<String, Integer> getViolatedRulesWithCount() {
        return Collections.unmodifiableMap(violationStatistics);
    }
}
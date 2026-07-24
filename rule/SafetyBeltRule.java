package rule;

import model.RadarData;
import model.Violation;

public class SafetyBeltRule implements ViolationRule {
    private final int fineAmount;

    public SafetyBeltRule(int fineAmount) {
        this.fineAmount = fineAmount;
    }

    @Override
    public String getRuleIdentifier() {
        return "Safety Belt Violation";
    }

    @Override
    public Violation inspect(RadarData data) {
        if (!data.isBeltFastened()) {
            return new Violation("Seatbelt not fastned", fineAmount);
        }
        return null;
    }
}
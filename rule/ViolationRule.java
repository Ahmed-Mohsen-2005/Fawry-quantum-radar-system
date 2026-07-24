package rule;

import model.RadarData;
import model.Violation;

public interface ViolationRule {
    String getRuleIdentifier();
    Violation inspect(RadarData data);
}
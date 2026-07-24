package model;

public class Violation {
    private final String reason;
    private final int cost;

    public Violation(String reason, int cost) {
        this.reason = reason;
        this.cost = cost;
    }

    public String getReason() { return reason; }
    public int getCost() { return cost; }
}
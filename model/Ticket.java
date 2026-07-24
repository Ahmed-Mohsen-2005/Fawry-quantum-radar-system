package model;

import java.util.List;

public class Ticket {
    private final String plateNumber;
    private final List<Violation> violations;

    public Ticket(String plateNumber, List<Violation> violations) {
        this.plateNumber = plateNumber;
        this.violations = violations;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public int calculateTotalCost() {
        int sum = 0;
        for (Violation v : violations) {
            sum += v.getCost();
        }
        return sum;
    }

    public void displayTicket() {
        System.out.println("Traffic for car " + plateNumber);
        System.out.println("Total amount: " + calculateTotalCost() + " EGP");
        System.out.println("Violations:");
        for (Violation v : violations) {
            System.out.println("- " + v.getReason() + " : " + v.getCost() + " EGP");
        }
        System.out.println();
    }
}
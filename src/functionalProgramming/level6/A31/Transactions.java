package functionalProgramming.level6.A31;

public class Transactions {
    private double amount;
    private String type;

    public Transactions(double amount, String type) {
        this.amount = amount;
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }
}

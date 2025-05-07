package functionalProgramming.level10.A50;

import java.time.LocalDate;

public class Order {
    private int id;
    private LocalDate date;
    private double totalAmount;

    public Order(int id, LocalDate date, double totalAmount) {
        this.id = id;
        this.date = date;
        this.totalAmount = totalAmount;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}

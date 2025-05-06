package functionalProgramming.level5.A30;

// Order class with status, amount, and customerName
class Order {
    String status;
    double amount;
    String customerName;

    public Order(String status, double amount, String customerName) {
        this.status = status;
        this.amount = amount;
        this.customerName = customerName;
    }

    public String getStatus() {
        return status;
    }

    public double getAmount() {
        return amount;
    }

    public String getCustomerName() {
        return customerName;
    }
}


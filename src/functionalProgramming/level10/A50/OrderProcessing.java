package functionalProgramming.level10.A50;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class OrderProcessing {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order(1, LocalDate.of(2023, 1, 5), 120.50),
                new Order(2, LocalDate.of(2023, 2, 10), 250.00),
                new Order(3, LocalDate.of(2023, 3, 15), 300.75),
                new Order(4, LocalDate.of(2023, 4, 20), 180.25)
        );

        LocalDate startDate = LocalDate.of(2023, 2, 1);
        LocalDate endDate = LocalDate.of(2023, 3, 31);

        double totalInRange = orders.stream()
                .filter(order -> !order.getDate().isBefore(startDate) && !order.getDate().isAfter(endDate))
                .mapToDouble(Order::getTotalAmount)
                .sum();

        System.out.println("Total amount between Feb and March 2023: " + totalInRange);
    }
}

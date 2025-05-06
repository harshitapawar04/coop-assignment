package functionalProgramming.level5.A30;

import java.util.*;
import java.util.stream.Collectors;

public class OrderProcessor {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("DELIVERED", 250.00, "Alice"),
                new Order("PENDING", 150.00, "Bob"),
                new Order("DELIVERED", 450.00, "Charlie"),
                new Order("CANCELLED", 200.00, "David"),
                new Order("DELIVERED", 100.00, "Eve")
        );

        List<String >customerNames= orders.stream()
                .filter(order-> order.getStatus().equals("DELIVERED"))
                .sorted(Comparator.comparingDouble(Order::getAmount).reversed())
                .map(Order::getCustomerName)
                .collect(Collectors.toList());

        System.out.println(customerNames);
    }

}

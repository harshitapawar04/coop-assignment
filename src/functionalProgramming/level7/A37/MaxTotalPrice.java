package functionalProgramming.level7.A37;

import java.util.*;

public class MaxTotalPrice {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order(Arrays.asList(new Item("Book", 30), new Item("Pen", 5))),
                new Order(Arrays.asList(new Item("Laptop", 800), new Item("Mouse", 20))),
                new Order(Arrays.asList(new Item("Notebook", 10), new Item("Pencil", 2)))
        );

        Optional<Order>maxOrder= orders.stream()
                .max(Comparator.comparingDouble(Order::getTotalPrice));

        maxOrder.ifPresent(order ->{
                    double total = order.getTotalPrice();
                    System.out.println("Order with max total price: " + total);
                }
                );
    }

}

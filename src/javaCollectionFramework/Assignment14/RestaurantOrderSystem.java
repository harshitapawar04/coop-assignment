package javaCollectionFramework.Assignment14;
import java.util.*;

class Order {
    private final int orderId;
    private final String description;

    public Order(int orderId, String description) {
        this.orderId = orderId;
        this.description = description;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Order#" + orderId + ": " + description;
    }
}

public class RestaurantOrderSystem {
    private final Deque<Order> currentOrders = new ArrayDeque<>();
    private final List<Order> orderHistory = new ArrayList<>();
    private int nextOrderId = 1;

    // Add order to front (priority)
    public void addOrderToFront(String description) {
        Order order = new Order(nextOrderId++, description);
        currentOrders.addFirst(order);
        System.out.println("Added to front: " + order);
    }

    // Add order to back (normal)
    public void addOrderToBack(String description) {
        Order order = new Order(nextOrderId++, description);
        currentOrders.addLast(order);
        System.out.println("Added to back: " + order);
    }

    // Serve order from front (FIFO)
    public void serveOrderFromFront() {
        if (!currentOrders.isEmpty()) {
            Order served = currentOrders.removeFirst();
            orderHistory.add(served);
            System.out.println("Served from front: " + served);
        } else {
            System.out.println("No orders to serve.");
        }
    }

    // Cancel order from back (e.g., customer leaves)
    public void cancelOrderFromBack() {
        if (!currentOrders.isEmpty()) {
            Order canceled = currentOrders.removeLast();
            System.out.println("Canceled from back: " + canceled);
        } else {
            System.out.println("No orders to cancel.");
        }
    }

    // View current orders
    public void viewCurrentOrders() {
        System.out.println("\nCurrent Orders:");
        for (Order order : currentOrders) {
            System.out.println("  " + order);
        }
    }

    // View order history
    public void viewOrderHistory() {
        System.out.println("\nOrder History:");
        for (Order order : orderHistory) {
            System.out.println("  " + order);
        }
    }

    public static void main(String[] args) {
        RestaurantOrderSystem system = new RestaurantOrderSystem();

        system.addOrderToBack("Burger");
        system.addOrderToBack("Pasta");
        system.addOrderToFront("VIP Sushi");
        system.serveOrderFromFront();
        system.cancelOrderFromBack();

        system.viewCurrentOrders();
        system.viewOrderHistory();
    }
}

package functionalProgramming.level7.A37;

import java.util.*;

public class Order {
    List<Item> items;

    public Order(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    // Total price of items in the order
    public double getTotalPrice() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }
}

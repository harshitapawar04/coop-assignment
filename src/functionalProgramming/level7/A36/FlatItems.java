package functionalProgramming.level7.A36;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;

public class FlatItems {

    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order(Arrays.asList(new Item("Book"), new Item("Pen"))),
                new Order(Arrays.asList(new Item("Pencil"), new Item("Notebook"))),
                new Order(Arrays.asList(new Item("Eraser")))
        );

        List<String> itemNames= orders.stream()
                .flatMap(order->order.getItems().stream())
                .map(Item::getName)
                .collect(Collectors.toList());

        System.out.println("List of items : " + itemNames);
    }
}

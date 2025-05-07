package functionalProgramming.level7.A38;

import java.util.*;
import java.util.stream.Collectors;

public class HighestRatedByCategory {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("iPhone", "Electronics", 4.5),
                new Product("Samsung Galaxy", "Electronics", 4.7),
                new Product("LG TV", "Electronics", 4.3),
                new Product("The Alchemist", "Books", 4.8),
                new Product("Clean Code", "Books", 4.9),
                new Product("Harry Potter", "Books", 4.7)
        );

        Map<String, String> topRatedByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(Product::getRating)),
                                optional -> optional.map(Product::getName).orElse("No Product")
                        )
                ));
        topRatedByCategory.forEach((category , productName)->{
            System.out.println(category+ " - " + productName);
        });
    }
}

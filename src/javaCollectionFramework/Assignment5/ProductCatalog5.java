package javaCollectionFramework.Assignment5;
import java.util.*;

class Product {
    int id;
    String name;
    double price;
    double rating;
    int stock;

    public Product(int id, String name, double price, double rating, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", Price: $" + price +
                ", Rating: " + rating +
                ", Stock: " + stock;
    }
}


public class ProductCatalog5 {
    public static void main(String[] args) {
        TreeMap<Integer, Product> productMap = new TreeMap<>();

        // Add some sample products
        productMap.put(101, new Product(101, "Laptop", 1200.0, 4.5, 10));
        productMap.put(102, new Product(102, "Smartphone", 800.0, 4.7, 25));
        productMap.put(103, new Product(103, "Headphones", 150.0, 4.7, 50));
        productMap.put(104, new Product(104, "Monitor", 300.0, 4.4, 15));
        productMap.put(105, new Product(105, "Keyboard", 70.0, 4.3, 30));

        List<Product> sortedProducts = new ArrayList<>(productMap.values());

        sortedProducts.sort((p1, p2) -> {
            int ratingCompare = Double.compare(p2.rating, p1.rating); // descending
            if (ratingCompare != 0) return ratingCompare;
            return p1.name.compareToIgnoreCase(p2.name); // ascending by name
        });

        System.out.println("=== Product Catalog (Sorted by Rating ↓, Name ↑) ===");
        for (Product product : sortedProducts) {
            System.out.println(product);
        }
    }
}

import java.util.ArrayList;

class Product {
    private int id;
    private String productName;
    private int price;

    public Product(int id, String productName, int price) {
        this.id = id;
        this.productName = productName;
        this.price = price;
    }

    public void displayProduct() {
        System.out.println("ID: " + id + ", Name: " + productName + ", Price: " + price);
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }
}

class Store {
    private ArrayList<Product> products;

    public Store() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void findExpensiveProduct() {
        if (products.isEmpty()) {
            System.out.println("No product available");
            return;
        }

        Product expensiveProduct = products.get(0);
        for (Product product : products) {
            if (expensiveProduct.getPrice() < product.getPrice()) {
                expensiveProduct = product;
            }
        }
        System.out.println("Highest Price Product:");
        expensiveProduct.displayProduct(); // Corrected line
    }

    public void findProduct(String searchName) {
        boolean found = false;
        for (Product product : products) {
            if (product.getProductName().toLowerCase().contains(searchName.toLowerCase())) {
                System.out.println("Product found:");
                product.displayProduct(); // Corrected line
                found = true;
            }
        }
        if (!found) {
            System.out.println("No product found with the name: " + searchName);
        }
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available");
        } else {
            for (Product product : products) {
                product.displayProduct();
            }
        }
    }
}

public class InventorySystem {
    public static void main(String[] args) {
        Store store = new Store();

        // Corrected price format: removed commas in price values
        store.addProduct(new Product(1, "Laptop", 99999));
        store.addProduct(new Product(2, "Smartphone", 49999));
        store.addProduct(new Product(3, "Keyboard", 8999));
        store.addProduct(new Product(4, "Monitor", 27999));
        store.addProduct(new Product(5, "Headphones", 14999));

        System.out.println("All Products:");
        store.displayProducts();

        System.out.println("\nProduct with Highest Price:");
        store.findExpensiveProduct();

        System.out.println("\nSearch for 'phone':");
        store.findProduct("phone");
    }

}

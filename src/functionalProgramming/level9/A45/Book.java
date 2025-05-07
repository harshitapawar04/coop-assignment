package functionalProgramming.level9.A45;

public class Book {
    private String title;
    private double price;
    private double rating;

    // Constructor
    public Book(String title, double price, double rating) {
        this.title = title;
        this.price = price;
        this.rating = rating;
    }

    // Getters
    public double getPrice() { return price; }
    public double getRating() { return rating; }
    public String getTitle() { return title; }
}

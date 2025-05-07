package functionalProgramming.level9.A45;

import java.util.*;

public class BookSummary {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Book A", 19.99, 4.5),
                new Book("Book B", 25.99, 4.2),
                new Book("Book C", 15.50, 3.8)
        );

        long count = books.size();
        double averageRating = books.stream()
                .mapToDouble(Book::getRating)
                .average()
                .orElse(0.0);
        double totalPrice = books.stream()
                .mapToDouble(Book::getPrice)
                .sum();

        Summary summary = new Summary(count, averageRating, totalPrice);
        System.out.println(summary);
    }
}

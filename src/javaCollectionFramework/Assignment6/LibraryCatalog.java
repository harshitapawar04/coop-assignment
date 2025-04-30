package javaCollectionFramework.Assignment6;

import java.util.*;

// Book class
class Book {
    String title;
    String author;
    int year;

    Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book b = (Book) o;
        return year == b.year &&
                title.equalsIgnoreCase(b.title) &&
                author.equalsIgnoreCase(b.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title.toLowerCase(), author.toLowerCase(), year);
    }

    @Override
    public String toString() {
        return "\"" + title + "\" by " + author + " (" + year + ")";
    }
}

public class LibraryCatalog {
    public static void main(String[] args) {
        Map<String, Set<Book>> catalog = new HashMap<>();

        addBook(catalog, "Fantasy", new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        addBook(catalog, "Fantasy", new Book("Harry Potter", "J.K. Rowling", 1997));
        addBook(catalog, "Fantasy", new Book("Harry Potter", "J.K. Rowling", 1997)); // Duplicate
        addBook(catalog, "Sci-Fi", new Book("Dune", "Frank Herbert", 1965));
        addBook(catalog, "Sci-Fi", new Book("Foundation", "Isaac Asimov", 1951));

        printBooksInGenre(catalog, "Fantasy");
        printBooksInGenre(catalog, "Sci-Fi");
    }

    static void addBook(Map<String, Set<Book>> catalog, String genre, Book book) {
        if (!catalog.containsKey(genre)) {
            catalog.put(genre, new HashSet<>());
        }
        catalog.get(genre).add(book);
    }

    static void printBooksInGenre(Map<String, Set<Book>> catalog, String genre) {
        System.out.println("\nBooks in genre: " + genre);

        Set<Book> books = catalog.get(genre);
        if (books == null || books.isEmpty()) {
            System.out.println("No books found.");
            return;
        }

        List<Book> sortedList = new ArrayList<>(books);
        Collections.sort(sortedList, new Comparator<Book>() {
            public int compare(Book b1, Book b2) {
                return Integer.compare(b1.year, b2.year);
            }
        });

        for (Book b : sortedList) {
            System.out.println(b);
        }
    }
}

package functionalProgramming.level11.A51;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class TextAnalyzer {
    public static void main(String[] args) {
        String paragraph = "Hello world! Hello Java. Java is powerful. Java streams are cool, and the world loves Java.";

        // Convert to lowercase, remove punctuation, split by whitespace
        Map<String, Long> wordCount = Arrays.stream(paragraph.toLowerCase()
                        .replaceAll("[^a-zA-Z ]", "")  // Remove punctuation
                        .split("\\s+"))               // Split by whitespace
                .collect(Collectors.groupingBy(
                        Function.identity(),          // Group by word
                        Collectors.counting()         // Count occurrences
                ));

        System.out.println("Word Frequency Map:");
        wordCount.forEach((word, count) -> System.out.println(word + " → " + count));
    }
}

package functionalProgramming.level11.A54;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Top3LongestStrings {
    public static void main(String[] args) {
        List<String> words = Arrays.asList(
                "Stream", "Java", "FunctionalProgramming", "Code", "Lambda", "Collector", "Optional", "Map"
        );

        List<String> top3Longest = words.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Top 3 Longest Strings: " + top3Longest);
    }
}

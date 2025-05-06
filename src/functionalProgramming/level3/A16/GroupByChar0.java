package functionalProgramming.level3.A16;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class GroupByChar0 {
    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "cherry", "avocado", "blueberry");

        Map<Character, List<String >>groupedWords= words.stream()
                .collect(Collectors.groupingBy(
                        name->name.charAt(0),
                        TreeMap::new,
                        Collectors.toList()
                ));

        groupedWords.forEach((key, value) ->
                System.out.println(key + ": " + value));
    }
}

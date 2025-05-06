package functionalProgramming.level4.A26;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortedSet {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Amy", "John", "Max", "Elizabeth", "Bob", "Max", "Elizabeth", "Bob","Clara");

        List<String> sortedNames=names.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(sortedNames);
    }
}

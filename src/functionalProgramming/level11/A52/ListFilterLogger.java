package functionalProgramming.level11.A52;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListFilterLogger {
    public static <T> List<T> filterAndLog(List<T> list, Predicate<T> predicate) {
        return list.stream()
                .filter(item -> {
                    boolean match = predicate.test(item);
                    if (match) {
                        System.out.println("Matched: " + item);
                    }
                    return match;
                })
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Amanda", "Brian", "Alex");

        List<String> filtered = filterAndLog(names, name -> name.startsWith("A"));

        System.out.println("Filtered List: " + filtered);
    }
}

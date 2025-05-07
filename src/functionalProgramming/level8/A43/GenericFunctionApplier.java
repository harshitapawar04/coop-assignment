package functionalProgramming.level8.A43;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GenericFunctionApplier {

    public static <T, R> List<R> applyFunctionToList(List<T> list, Function<T, R> function) {
        return list.stream()
                .map(function)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        List<String> names = List.of("Alice", "Bob", "Charlie");
        List<Integer> lengths = applyFunctionToList(names, String::length);
        System.out.println("Lengths: " + lengths);  // [5, 3, 7]

        List<Integer> numbers = List.of(1, 2, 3);
        List<String> labeled = applyFunctionToList(numbers, n -> "Number: " + n);
        System.out.println("Labeled: " + labeled);  // [Number: 1, Number: 2, Number: 3]
    }
}

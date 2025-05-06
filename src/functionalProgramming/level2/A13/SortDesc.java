package functionalProgramming.level2.A13;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortDesc {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 7);

        List<Integer>sortedNumbers= numbers.stream()
                .sorted(Comparator.reverseOrder()).
                collect(Collectors.toList());

        System.out.println(sortedNumbers);
    }
}

//Convert a list of integers to a Set using Collectors.toSet()
package functionalProgramming.level3.A21;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ConvertSet {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(11, 23, 35, 47, 11,22,3442,23,11,35,4);

        Set<Integer> uniqueNumbers = numbers.stream()
                .collect(Collectors.toSet());

        System.out.println(uniqueNumbers);
    }
}

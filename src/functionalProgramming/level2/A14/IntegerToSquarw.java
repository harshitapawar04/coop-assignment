//Convert a list of integers into a list of their squares.
package functionalProgramming.level2.A14;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerToSquarw {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 7);

        List<Integer>squares= numbers.stream()
                .map(n->n*n)
                .collect(Collectors.toList());

        System.out.println(squares);
    }
}

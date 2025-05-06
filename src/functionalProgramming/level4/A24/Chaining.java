//Chain multiple stream operations: filter > map > sort > collect.

package functionalProgramming.level4.A24;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Chaining {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(11, 23, 35, 4,231,342,43,12,456,3,2,355);

        List<Integer>newNums= numbers.stream()
                .filter(n-> n%2==0) //filters even number
                .map(n-> n*n) // maps the num to square
                .sorted()
                .collect(Collectors.toList());

        System.out.println(newNums);

    }
}

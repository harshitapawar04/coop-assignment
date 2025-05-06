
package functionalProgramming.level2.A8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterEven {
    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(10,22,1,25,34,235,234,2,121,567,856,666);

        List<Integer> evenNUmbers= numbers.stream()
                .filter(n->n%2==0)
                .collect(Collectors.toList());

        System.out.println(evenNUmbers);
    }
}

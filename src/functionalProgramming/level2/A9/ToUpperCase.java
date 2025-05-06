//Convert a list of strings to uppercase using map().
package functionalProgramming.level2.A9;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ToUpperCase {
    public static void main(String[] args) {
        String[] fruits= {"Apple", "Banana", "Avocado", "apricot", "Almond"};

        List<String>toUpper= Arrays.stream(fruits)
                .map(String :: toUpperCase)
                .collect(Collectors.toList());
        System.out.println(toUpper);
    }
}

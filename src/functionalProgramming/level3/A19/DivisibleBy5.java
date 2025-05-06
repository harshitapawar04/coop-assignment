//Find the first element in a list of integers that is divisible by 5 using findFirst().

package functionalProgramming.level3.A19;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DivisibleBy5 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(11, 25, 43, 44, 65, 6, 17, 58, 90, 10);
        Optional<Integer> divBy5= numbers.stream()
                .filter(n-> n%5==0)
                .findFirst( );

        divBy5.ifPresent(n-> System.out.println("First Number divisible by 5 is " + n));
    }
}

//Optional is a container object introduced in Java 8 to represent a value that may or may not be present.

//isPresent()	Checks if value is present
//get()	Returns value (throws if empty — not recommended alone)
//orElse("default")	Returns value or default
//orElseGet(() -> ...)	Returns value or computes default
//orElseThrow()	Throws exception if empty
//ifPresent(value -> ...)	Performs action if value is present
//map()	Transforms the value if present
//filter()	Filters the value using a condition
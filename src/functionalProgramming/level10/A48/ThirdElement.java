package functionalProgramming.level10.A48;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ThirdElement {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("Apple", "Banana", "Cherry", "Date");

        Optional<String> thirdElement = items.stream()
                .skip(2)  // Skip the first 2 elements
                .findFirst();  // Get the third

        thirdElement.ifPresentOrElse(
                item -> System.out.println("Third element: " + item),
                () -> System.out.println("List has fewer than 3 elements")
        );
    }
}

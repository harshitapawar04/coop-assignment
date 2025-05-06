//Use Optional to safely get a value or return a default.
package functionalProgramming.level3.A20;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UseOptional {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Mike", "Sarah", "Sam");
        Optional<String> name= names.stream()
                .filter(n->n.startsWith("Z"))
                .findFirst();

        System.out.println(name.orElse("No matching Name Found"));
    }

}

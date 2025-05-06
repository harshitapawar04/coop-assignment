

package functionalProgramming.level3.A18;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoinStrings {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

    String joiningStrings= names.stream()
                .collect(Collectors.joining(" , "));

        System.out.println(joiningStrings);
    }
}

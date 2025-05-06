//Find the longest string in a list using reduce().
package functionalProgramming.level2.A12;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LongestString {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "Stream", "Programming", "Reduce", "Function");

        Optional<String> longest= words.stream()
                .reduce((a,b)->a.length()>b.length() ? a : b);

        longest.ifPresent(s->System.out.println("Longest word- "+ s ));
    }
}

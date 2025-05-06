package functionalProgramming.level2.A15;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordToLength {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "Stream", "Programming", "Reduce", "Function");

        List<Integer>length= words.stream()
                .map(n->n.length())
                .collect(Collectors.toList());

        System.out.println(length);
    }
}

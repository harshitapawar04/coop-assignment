package functionalProgramming.level2.A11;

import java.util.Arrays;
import java.util.List;

public class StringsStartWithS {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Sam", "Steve", "John", "Sarah", "Mike", "Sophie");

        long totalCount=names.stream()
                .filter(name-> name.startsWith("S"))
                .count();

        System.out.println(totalCount);
    }
}

package functionalProgramming.level8.A42;

import java.util.function.Function;

public class FunctionComposition {

    public static void main(String[] args) {

        Function<String, Integer> parse = Integer::parseInt;

        Function<Integer, Integer> doubleIt = n -> n * 2;

        Function<String, Integer> parseAndDouble = parse.andThen(doubleIt);

        String input = "21";
        int result = parseAndDouble.apply(input);
        System.out.println("Doubled value: " + result);
    }
}

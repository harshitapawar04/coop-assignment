package functionalProgramming.level8.A44;

import java.util.function.Function;

public class ComposeAndThen {
    public static void main(String[] args) {

        Function<Integer, Integer> doubleIt = x -> x * 2;

        Function<Integer, Integer> addThree = x -> x + 3;

        // Using andThen (first double, then add 3)
        Function<Integer, Integer> andThenExample = doubleIt.andThen(addThree);
        System.out.println("andThen (2 * 2 + 3): " + andThenExample.apply(2)); // (2*2)+3 = 7

        // Using compose:(first add 3, then double)
        Function<Integer, Integer> composeExample = doubleIt.compose(addThree);
        System.out.println("compose ((2 + 3) * 2): " + composeExample.apply(2)); // (2+3)*2 = 10
    }
}


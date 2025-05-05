package functionalProgramming.level1.A6;

import java.util.function.BiFunction;

public class BifunctionSum {
    public static void main(String[] args) {
        BiFunction<Integer , Integer, Integer>sum=(a, b)->(a+b);
        Integer result= sum.apply(12,14);
        System.out.println("Sum is " + result);
    }
}

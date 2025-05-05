package functionalProgramming.level1.A4;

import java.util.function.Supplier;

public class SupplierGet {
    public static void main(String[] args) {
        Supplier<Double> randomNumber=()->Math.random();
        System.out.println(randomNumber.get());
    }
}

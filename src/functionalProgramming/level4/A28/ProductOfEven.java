package functionalProgramming.level4.A28;

import java.util.*;

public class ProductOfEven {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6);

        Optional<Integer>product= numbers.stream()
                .filter(n->n%2==0)
                .reduce((a,b)->a*b);

        product.ifPresent(p-> System.out.println("Product of Even Numbers: " + p));
    }
}

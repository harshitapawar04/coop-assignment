package functionalProgramming.level1.A5;

import java.util.Arrays;
import java.util.List;

public class SortLambda {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Banana", "Apple", "Mango", "Cherry");
        words.sort((s1,s2)->s1.compareTo(s2));
        System.out.println("Sorted List: " +words);
    }

}

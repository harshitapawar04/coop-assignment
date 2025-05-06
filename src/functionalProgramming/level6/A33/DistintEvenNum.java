package functionalProgramming.level6.A33;

import java.util.*;
import java.util.stream.Collectors;

public class DistintEvenNum {
    public static void main(String[] args) {
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(2, 4, 5, 6),
                Arrays.asList(3, 4, 8, 10),
                Arrays.asList(2, 12, 14)
        );

         List<Integer>evenDistintNums= listOfLists.stream()
                 .flatMap(List::stream)
                 .filter(n->n%2==0)
                 .distinct()
                 .collect(Collectors.toList());

        System.out.println("Distint Even Numbers From list: " + evenDistintNums);

    }
}

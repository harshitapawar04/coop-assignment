package functionalProgramming.level4.A27;

import java.util.*;

public class AvgLengthOfString {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "kiwi");

        OptionalDouble avgLength= words.stream()
                .mapToInt(String::length)
                .average();

        System.out.println("Average length of the words: " + avgLength);
    }
}

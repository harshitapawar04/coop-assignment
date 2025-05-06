//Write a function that takes a list of strings and returns a map of word to its length

package functionalProgramming.level4.A22;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordLength {
    public static Map<String, Integer> mapWOrdsToLength(List<String>words){
        return words.stream()
                .collect(Collectors.toMap(word->word , word->word.length()));
    }
    public static void main(String[] args) {
        List<String> words = List.of("Java", "Stream", "Optional", "Map");

        Map<String , Integer> wordLengthMap= mapWOrdsToLength(words);
        System.out.println(wordLengthMap);
    }
}

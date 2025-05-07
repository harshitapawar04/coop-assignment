package functionalProgramming.level8.A41;

import java.util.function.Function;

public class TextCleanerPipeline {
    public static void main(String[] args) {
        Function<String, String> trim = s->s.trim();

        Function<String, String> toLower = s->s.toLowerCase();

        Function<String, String> removePunctuation = s -> s.replaceAll("\\p{Punct}", "");

        Function<String, String> cleanText = trim
                .andThen(toLower)
                .andThen(removePunctuation);

        String input = "    Hello, World!! Welcome to Java.  ";
        String result = cleanText.apply(input);

        System.out.println("Cleaned Text: " + result);
    }
}

package functionalProgramming.level10.A49;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ValidURLs {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList(
                "https://www.google.com",
                "htt://invalid-url",
                "http://example.com",
                "www.missing-protocol.com",
                "https://openai.com"
        );

        Predicate<String> isValidUrl = url -> {
            try {
                new URL(url);
                return true;
            } catch (MalformedURLException e) {
                return false;
            }
        };

        List<String> validUrls = urls.stream()
                .filter(isValidUrl)
                .collect(Collectors.toList());

        System.out.println("Valid URLs:");
        validUrls.forEach(System.out::println);
    }
}

package javaCollectionFramework.Assignment7;

import java.util.*;

public class MovieRatingAggregator {
    public static void main(String[] args) {
        Map<String, List<Integer>> movieRatings = new HashMap<>();

        // Adding one rating at a time
        addRating(movieRatings, "Inception", 5);
        addRating(movieRatings, "Inception", 4);
        addRating(movieRatings, "Inception", 5);
        addRating(movieRatings, "Interstellar", 4);
        addRating(movieRatings, "Interstellar", 4);
        addRating(movieRatings, "Tenet", 3);
        addRating(movieRatings, "Tenet", 2);
        addRating(movieRatings, "Tenet", 4);

        Map<String, Double> averageRatings = new HashMap<>();

        for (Map.Entry<String, List<Integer>> entry : movieRatings.entrySet()) {
            String movie = entry.getKey();
            List<Integer> ratings = entry.getValue();

            int sum = 0;
            for (int rating : ratings) {
                sum += rating;
            }

            double average = 0;
            if (!ratings.isEmpty()) {
                average = (double) sum / ratings.size(); // Cast to double to avoid integer division
            }

            averageRatings.put(movie, average);
        }

        System.out.println("Average Ratings (sorted descending):");

        List<Map.Entry<String, Double>> ratingList = new ArrayList<>(averageRatings.entrySet());

        ratingList.sort(new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> a, Map.Entry<String, Double> b) {
                return Double.compare(b.getValue(), a.getValue()); // Descending order
            }
        });

        for (Map.Entry<String, Double> entry : ratingList) {
            System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue());
        }
    }

    static void addRating(Map<String, List<Integer>> map, String movie, int rating) {
        map.putIfAbsent(movie, new ArrayList<>());
        map.get(movie).add(rating);
    }
}

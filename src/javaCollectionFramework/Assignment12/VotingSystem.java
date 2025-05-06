package javaCollectionFramework.Assignment12;
import java.util.*;

public class VotingSystem {
    private final Map<String, Integer> voteMap = new HashMap<>();

    // Add a vote for a candidate
    public void vote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
    }

    // Display results sorted by vote count descending
    public void printResults() {
        List<Map.Entry<String, Integer>> sortedResults = new ArrayList<>(voteMap.entrySet());

        sortedResults.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("Voting Results:");
        for (Map.Entry<String, Integer> entry : sortedResults) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();

        // Simulated votes
        system.vote("Alice");
        system.vote("Bob");
        system.vote("Alice");
        system.vote("Charlie");
        system.vote("Bob");
        system.vote("Alice");

        system.printResults();
    }
}

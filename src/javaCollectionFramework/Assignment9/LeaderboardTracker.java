package javaCollectionFramework.Assignment9;

import java.util.*;

class Player {
    private String name;
    private int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    // Setter for score (no setter for name since it's used as ID)
    public void setScore(int score) {
        this.score = score;
    }

    // Equality based on name
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Player)) return false;
        Player other = (Player) obj;
        return this.name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name + ": " + score;
    }
}

public class LeaderboardTracker {
    // Comparator: sort by score descending, then name ascending
    private final Comparator<Player> scoreComparator = (a, b) -> {
        int scoreCompare = Integer.compare(b.getScore(), a.getScore());
        return scoreCompare != 0 ? scoreCompare : a.getName().compareTo(b.getName());
    };

    private final TreeSet<Player> leaderboard = new TreeSet<>(scoreComparator);
    private final Map<String, Player> playerMap = new HashMap<>();

    public void addOrUpdatePlayer(String name, int newScore) {
        Player existing = playerMap.get(name);
        if (existing != null) {
            leaderboard.remove(existing);         // Remove from TreeSet before update
            existing.setScore(newScore);          // Update score
        } else {
            existing = new Player(name, newScore);
            playerMap.put(name, existing);
        }
        leaderboard.add(existing);                // Re-insert updated/new player
    }

    public void printLeaderboard() {
        System.out.println("Leaderboard:");
        for (Player player : leaderboard) {
            System.out.println(player);
        }
    }

    public static void main(String[] args) {
        LeaderboardTracker lb = new LeaderboardTracker();
        lb.addOrUpdatePlayer("Harshita", 50);
        lb.addOrUpdatePlayer("Harshi", 70);
        System.out.println("Initial Leaderboard:");
        lb.printLeaderboard();

        System.out.println("\nUpdating Harshita to 80:");
        lb.addOrUpdatePlayer("Harshita", 80);
        lb.printLeaderboard();

        System.out.println("\nUpdating Harshit to 90:");
        lb.addOrUpdatePlayer("Harshit", 90);
        lb.printLeaderboard();
    }
}

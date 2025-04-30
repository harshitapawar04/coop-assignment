package javaCollectionFramework.Assignment9;
//Problem 9: Leaderboard Tracker (TreeSet, Comparator)
//        Track player scores using TreeSet<Player>  sorted by score descending.
//        Update a player's score and maintain correct leaderboard order.

import java.util.*;

class Player {
    String name;
    int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // Needed to find and remove by equality
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
    // Comparator: sort by score descending, then name ascending (for tie-breaker)
    private final Comparator<Player> scoreComparator = (a, b) -> {
        if (a.score != b.score)
            return Integer.compare(b.score, a.score); // Descending
        return a.name.compareTo(b.name); // Ascending by name
    };

    private final TreeSet<Player> leaderboard = new TreeSet<>(scoreComparator);
    private final Map<String, Player> playerMap = new HashMap<>(); // For fast lookup

    public void addOrUpdatePlayer(String name, int newScore) {
        Player existing = playerMap.get(name);
        if (existing != null) {
            leaderboard.remove(existing); // Remove old
            existing.score = newScore;
        } else {
            existing = new Player(name, newScore);
            playerMap.put(name, existing);
        }
        leaderboard.add(existing); // Re-insert
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
        System.out.println("Updating Harshita to 80 ");
        lb.printLeaderboard();

        System.out.println("Updating Harshita to 80 ");
        lb.addOrUpdatePlayer("Harshita", 80);
        lb.printLeaderboard();
        lb.addOrUpdatePlayer("Harshit", 90);
        System.out.println("Updating Player Harhit to 90 ");
        lb.printLeaderboard();
    }
}

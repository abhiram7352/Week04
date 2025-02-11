package day02_java_collections;

import java.util.*;

// Class representing the Voting System
public class VotingSystem {
    // HashMap to store votes for each candidate
    private Map<String, Integer> voteMap = new HashMap<>();

    // Method to cast a vote for a candidate
    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
    }

    // Display the vote count in insertion order using LinkedHashMap
    public void displayVotesInOrder() {
        System.out.println("--- Votes in Order of Casting (LinkedHashMap) ---");
        Map<String, Integer> linkedVoteMap = new LinkedHashMap<>();
        for (String candidate : voteMap.keySet()) {
            linkedVoteMap.put(candidate, voteMap.get(candidate));
        }
        linkedVoteMap.forEach((candidate, votes) ->
                System.out.println(candidate + ": " + votes));
    }

    // Display the results sorted by candidate names using TreeMap
    public void displaySortedResults() {
        System.out.println("--- Sorted Results by Candidate Name (TreeMap) ---");
        Map<String, Integer> sortedVoteMap = new TreeMap<>(voteMap);
        sortedVoteMap.forEach((candidate, votes) ->
                System.out.println(candidate + ": " + votes));
    }

    // Display the winner(s) of the election
    public void displayWinners() {
        System.out.println("--- Election Winner(s) ---");
        int maxVotes = Collections.max(voteMap.values());
        voteMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxVotes)
                .forEach(entry -> System.out.println(entry.getKey() + " with " + entry.getValue() + " votes"));
    }

    // Main method to run the Voting System
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        // Casting votes
        votingSystem.castVote("Abhiram");
        votingSystem.castVote("Rahul");
        votingSystem.castVote("Abhiram");
        votingSystem.castVote("Vinay");
        votingSystem.castVote("Rahul");
        votingSystem.castVote("Abhiram");

        // Displaying votes and results
        votingSystem.displayVotesInOrder();
        votingSystem.displaySortedResults();
        votingSystem.displayWinners();
    }
}

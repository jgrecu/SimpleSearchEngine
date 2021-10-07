package search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchEngine {
    private List<String> people;
    private Map<String, List<Integer>> invertedIndex = new HashMap<>();

    public SearchEngine(List<String> people) {
        this.people = people;
        createInvertedIndex();
    }

    private void createInvertedIndex() {
        for (int i = 0; i < people.size(); i++) {
            for (String word : people.get(i).toLowerCase().strip().split("\\s+")) {
                if (!invertedIndex.containsKey(word)) {
                    invertedIndex.put(word, new ArrayList<>(List.of(i)));
                } else {
                    invertedIndex.get(word).add(i);
                }
            }
        }
    }

    public void searchList(String input) {
        List<Integer> temp = invertedIndex.get(input.toLowerCase());

        if (temp != null) {
            System.out.println(temp.size() + " persons found:");
            for (int entry : temp) {
                System.out.println(people.get(entry));
            }
        } else {
            System.out.println("No matching people found.");
        }
    }

    public void printList() {
        System.out.println("\n=== List of people ===");
        for (String entry : people) {
            System.out.println(entry);
        }
        System.out.println();
    }
}

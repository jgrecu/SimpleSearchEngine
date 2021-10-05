package search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private List<String> people;

    public SearchEngine(List<String> people) {
        this.people = people;
    }

    public void searchList(String input) {
        List<String> temp = new ArrayList<>();
        for (String entry : people) {
            if(entry.toLowerCase().contains(input.toLowerCase())) {
                temp.add(entry);
            }
        }

        if (!temp.isEmpty()) {
            for (String entry : temp) {
                System.out.println(entry);
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

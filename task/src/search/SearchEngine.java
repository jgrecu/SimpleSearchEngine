package search;

import java.util.*;
import java.util.stream.Collectors;

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

    public void searchList(String type, String input) {
        List<String> temp = List.of(input.toLowerCase().split("\\s+"));
        SortedSet<Integer> common = new TreeSet<>();

        switch (type) {
            case "all":
                common = searchListAll(temp);
                break;
            case "any":
                common = searchListAny(temp);
                break;
            case "none":
                common = searchListNone(temp);
                break;
            default:
                break;
        }
        if (!common.isEmpty()) {
            System.out.println("\n" + common.size() + " persons found:");
            for (int entry : common) {
                System.out.println(people.get(entry));
            }
        } else {
            System.out.println("No matching people found.");
        }
    }

    public SortedSet<Integer> searchListAll(List<String> searchTerms) {
        SortedSet<Integer> common = new TreeSet<>(invertedIndex.getOrDefault(searchTerms.get(0), new ArrayList<>()));
        List<Integer> temp1;
        for (String searchTerm : searchTerms) {
            temp1 = invertedIndex.getOrDefault(searchTerm, new ArrayList<>());
            common.retainAll(temp1);
        }
        return common;
    }

    public SortedSet<Integer> searchListAny(List<String> searchTerms) {
        SortedSet<Integer> common = new TreeSet<>(invertedIndex.getOrDefault(searchTerms.get(0), new ArrayList<>()));
        List<Integer> temp1;
        for (String searchTerm : searchTerms) {
            temp1 = invertedIndex.getOrDefault(searchTerm, new ArrayList<>());
            common.addAll(temp1);
        }
        return common;
    }

    public SortedSet<Integer> searchListNone(List<String> searchTerms) {
        SortedSet<Integer> common = invertedIndex.values()
                .stream().flatMap(List::stream).collect(Collectors.toCollection(TreeSet::new));
        List<Integer> temp1;
        for (String searchTerm : searchTerms) {
            temp1 = invertedIndex.getOrDefault(searchTerm, new ArrayList<>());
            common.removeAll(temp1);
        }
        return common;
    }

    public void printList() {
        System.out.println("\n=== List of people ===");
        for (String entry : people) {
            System.out.println(entry);
        }
        System.out.println();
    }
}

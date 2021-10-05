package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        List<String> people = createList(scanner);
        search(scanner, people);
    }

    static void findWordIndex(String input, String word) {
        String[] words = input.strip().split(" ");
        int index = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                index = i;
            }
        }
        System.out.println(index > -1 ? index + 1 : "Not found");
    }

    static List<String> createList(Scanner scanner) {
        List<String> people = new ArrayList<>();
        System.out.println("Enter the number of people:");
        int listSize = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter all people:");
        for (int i = 0; i < listSize; i++) {
            people.add(scanner.nextLine());
        }
        return people;
    }

    static void search(Scanner scanner, List<String> people) {
        System.out.println("\nEnter the number of search queries:");
        int numberOfSearches = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfSearches; i++) {
            System.out.println("\nEnter data to search people:");
            String input = scanner.nextLine();
            printResult(searchList(input, people));
        }
        System.out.println("\n");
    }

    private static List<String> searchList(String input, List<String> people) {
        List<String> temp = new ArrayList<>();
        for (String entry : people) {
            if(entry.toLowerCase().contains(input.toLowerCase())) {
                temp.add(entry);
            }
        }
        return temp;
    }

    private static void printResult(List<String> stringList) {
        if (stringList.size() > 0) {
            System.out.println("\nFound people:");
            for (String entry : stringList) {
                System.out.println(entry);
            }
        } else {
            System.out.println("No matching people found.");
        }
    }
}

package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchUserInterface {
    private static SearchEngine searchEngine;
    private static final Scanner scanner = new Scanner(System.in);

    static void start() {
        searchEngine = new SearchEngine(initializeList(scanner));
        run();
    }

    private static void run() {
        boolean noExit = true;
        while (noExit) {
            printMainMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    findPerson();
                    break;
                case 2:
                    searchEngine.printList();
                    break;
                case 0:
                    System.out.println("\nBye!");
                    noExit = false;
                    break;
                default:
                    System.out.println("\nIncorrect option! Try again.");
            }
        }
    }

    private static void findPerson() {
        System.out.println("\nEnter a name or email to search all suitable people.");
        String patern = scanner.nextLine();
        searchEngine.searchList(patern);
    }

    private static void printMainMenu() {
        System.out.println("\n=== Menu ===\n" +
                "1. Find a person\n" +
                "2. Print all people\n" +
                "0. Exit");
    }

    static List<String> initializeList(Scanner scanner) {
        List<String> people = new ArrayList<>();
        System.out.println("Enter the number of people:");
        int listSize = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter all people:");
        for (int i = 0; i < listSize; i++) {
            people.add(scanner.nextLine());
        }
        return people;
    }
}

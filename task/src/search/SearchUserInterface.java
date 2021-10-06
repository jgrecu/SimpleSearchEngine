package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchUserInterface {
    private static SearchEngine searchEngine;
    private static final Scanner scanner = new Scanner(System.in);

    static void start(String fileName) {
        searchEngine = new SearchEngine(readFile(fileName));
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

    public static List<String> readFile(String filename) {
        List<String> people = new ArrayList<>();
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextLine()) {
                people.add(scanner.nextLine());
            }
            return people;
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found");
            return people;
        }
    }
}

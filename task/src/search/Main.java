package search;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String word = scanner.nextLine();
        findWordIndex(input, word);
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
}

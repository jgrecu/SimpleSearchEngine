package search;

public class Main {
    public static void main(String[] args) {
        String fileName = "";
        if ("--data".equals(args[0])) {
            fileName = args[1];
        }
        SearchUserInterface.start(fileName);
    }
}

package Utils;

import Library.Library;
import java.io.Serializable;
import java.util.Scanner;
import java.io.IOException;

public class Utils implements Serializable {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void waitForKeyPress() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeLastLine() {
        System.out.print("\033[F"); // Move cursor to the previous line
        System.out.print("\033[K"); // Erase the line content
    }

    public void case1(Scanner scanner, Library library) {
        //first clear the screen
        Utils.clearScreen();

        System.out.print("Group: ");
        String group = scanner.nextLine();

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Author: ");
        String author = scanner.nextLine();

        System.out.print("Read (true/false): ");
        boolean read = scanner.nextBoolean();
        scanner.nextLine(); // Consume the newline character

        library.addBook(group, title, author, read);

        // make a list of all books from the group
        System.out.println(group + ":");
        System.out.println(library.getBooksFromGroup(group));

        new Utils().waitForKeyPress();

        Utils.clearScreen();
    }

    public void case2(Scanner scanner, Library library) {
        //first clear the screen
        Utils.clearScreen();

        System.out.print("Group: ");
        String group = scanner.nextLine();

        System.out.print("Title: ");
        String title = scanner.nextLine();

        library.removeBook(group, title);

        // I want to show the name of the group, the number of books in the group and the books in the group
        System.out.println(group + " (" + library.getNumberOfBooksInGroup(group) + " books):");
        System.out.println(library.getBooksFromGroup(group));

        new Utils().waitForKeyPress();

        Utils.clearScreen();
    }

    public void case3(Scanner scanner, Library library) {
        //first clear the screen
        Utils.clearScreen();

        System.out.print("Current group: ");
        String currentGroup = scanner.nextLine();

        System.out.print("New group: ");
        String newGroup = scanner.nextLine();

        System.out.print("Title: ");
        String title = scanner.nextLine();

        library.transferBook(currentGroup, newGroup, title);

        // make a list of all books from the group
        System.out.println(currentGroup + ":");
        System.out.println(library.getBooksFromGroup(currentGroup));

        System.out.println(newGroup + ":");
        System.out.println(library.getBooksFromGroup(newGroup));

        new Utils().waitForKeyPress();

        Utils.clearScreen();
    }

    public void case4(Scanner scanner, Library library) {
        //first clear the screen
        Utils.clearScreen();

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.println(library.getBook(title));

        new Utils().waitForKeyPress();

        Utils.clearScreen();
    }

    public void case5(Scanner scanner, Library library) {
        //first clear the screen
        Utils.clearScreen();

        System.out.print("Group: ");
        String group = scanner.nextLine();

        System.out.println(library.getBooksFromGroup(group));

        new Utils().waitForKeyPress();

        Utils.clearScreen();
    }

    public void case6(Scanner scanner, Library library) {
        //first clear the screen
        Utils.clearScreen();

        System.out.println(library.getAllBooks());

        new Utils().waitForKeyPress();

        Utils.clearScreen();
    }

    public void case7(Scanner scanner, Library library) {
        //first clear the screen
        Utils.clearScreen();

        System.out.print("Group: ");
        String group = scanner.nextLine();

        library.addGroup(group);

        System.out.println(library.getAllGroups());

        new Utils().waitForKeyPress();

        Utils.clearScreen();
    }

    public void case8(Scanner scanner, Library library) {
        //first clear the screen
        Utils.clearScreen();

        System.out.print("Group: ");
        String group = scanner.nextLine();

        library.removeGroup(group);

        System.out.println(library.getAllGroups());

        new Utils().waitForKeyPress();

        Utils.clearScreen();
    }

    public void case9(Scanner scanner, Library library) {
        //first clear the screen
        Utils.clearScreen();

        System.out.print("Group: ");
        String group = scanner.nextLine();

        // make a list of all books from the group and write also the number of books in the group
        System.out.println(group + " (" + library.getNumberOfBooksInGroup(group) + " books):");
        System.out.println(library.getBooksFromGroup(group));

        new Utils().waitForKeyPress();

        Utils.clearScreen();
    }

    // this should print the name of all groups
    public void case10(Scanner scanner, Library library) {
        //first clear the screen
        Utils.clearScreen();

        System.out.println("All Groups:");
        System.out.println(library.getAllGroups());

        new Utils().waitForKeyPress();

        Utils.clearScreen();
    }

    // this should print the name of all groups and all the books in each group like this

    // Group1 (2 books):
    // Book1
    // Book2
    // Group2 (1 book):
    // Book3
    public void case11(Scanner scanner, Library library) {
        //first clear the screen
        Utils.clearScreen();

        System.out.println("All Groups(" + library.getNumberOfGroups() + " groups):");
        System.out.println(library.getAllGroups());
        System.out.println("-------------------------");
        for (String group : library.getAllGroups().split("\n")) {
            System.out.println(group + " (" + library.getNumberOfBooksInGroup(group) + " books):");
            System.out.println(library.getBooksFromGroup(group));
            System.out.println("-------------------------");
        }

        new Utils().waitForKeyPress();

        Utils.clearScreen();
    }

    
}

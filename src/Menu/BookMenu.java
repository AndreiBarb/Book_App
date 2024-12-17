package Menu;

import Library.Library;
import Utils.Utils;
import FilesSafer.FilesSafer;
import java.io.Serializable;
import java.util.Scanner;

public class BookMenu implements Serializable {
    private Scanner scanner;

    public BookMenu() {
        this.scanner = new Scanner(System.in);
    }

    // Close the scanner
    public void closeScanner() {
        scanner.close();
    }

    public void showBookMenu() {
        System.out.println("1. Add book");
        System.out.println("2. Remove book");
        System.out.println("3. Transfer book");
        System.out.println("4. Show book");
        System.out.println("5. Show all books from group");
        System.out.println("6. Show all books");
        System.out.println("7. Add group");
        System.out.println("8. Remove group");
        System.out.println("9. Show group");
        System.out.println("10. Show all groups");
        System.out.println("11. Show library");
        System.out.println("12. Exit");
    }

    public int parseMenuOption(Library library) {
        Utils utils = new Utils();
        
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            switch (choice) {
                case 1:
                    utils.case1(scanner, library);
                    return 0;
                case 2:
                    utils.case2(scanner, library);
                    return 0;
                case 3:
                    utils.case3(scanner, library);
                    return 0;
                case 4:
                    utils.case4(scanner, library);
                    return 0;
                case 5:
                    utils.case5(scanner, library);
                    return 0;
                case 6:
                    utils.case6(scanner, library);
                    return 0;
                case 7:
                    utils.case7(scanner, library);
                    return 0;
                case 8:
                    utils.case8(scanner, library);
                    return 0;
                case 9:
                    utils.case9(scanner, library);
                    return 0;
                case 10:
                    utils.case10(scanner, library);
                    return 0;
                case 11:
                    utils.case11(scanner, library);
                    return 0;
                case 12:
                    // FilesSafer filesSafer = new FilesSafer();
                    
                    // filesSafer.saveLibrary(library, "Library.txt");
                    // filesSafer.serializeLibrary(library, "Library.ser");

                    System.out.println("Exit");
                    return 1;
                
                
                default:
                    utils.clearScreen();
                    System.out.print("Invalid option");
                    utils.waitForKeyPress();
                    return 0;
            }
        } else {
            utils.clearScreen();
            System.out.println("Invalid option");
            scanner.nextLine(); // Consume the invalid input
            utils.waitForKeyPress();
            utils.clearScreen();
            return 0;
        }
        
    }
                
    
}

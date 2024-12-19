import Book.Book;
import Group.Group;
import Library.Library;
import java.util.Scanner;
import Menu.BookMenu;
import FilesSafer.FilesSafer;

public class App {
    public static void main(String[] args) {
        FilesSafer filesSafer = new FilesSafer();
        Library library = filesSafer.deserializeLibrary("Library.ser");
        
        int flag = 0;
        BookMenu bookMenu = new BookMenu();
        while(flag == 0) {
            bookMenu.showBookMenu();
            flag = bookMenu.parseMenuOption(library);
        }
        bookMenu.closeScanner();
        
        filesSafer.serializeLibrary(library, "Library.ser");
        filesSafer.saveLibrary(library, "Library.txt");
    }
}
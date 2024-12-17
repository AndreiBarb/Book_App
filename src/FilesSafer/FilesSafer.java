package FilesSafer;

import Library.Library;
import Group.Group;
import Book.Book;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class FilesSafer {
    public void saveLibrary(Library library, String filename) {
        char check = '\u2714'; // ✔
        char cross = '\u274C'; // ❌
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false))) { // 'true' to append to the file if it exists
            for(Group group : library.getAllGroupsArray()) {
                String nameOfGroup = group.getNameOfGroup() + " (" + group.getNumberOfBooksFromGroup() + " books):";
                // write the name of the book in the file
                writer.write(nameOfGroup);
                writer.newLine();
                for(Book book : group.getBooks().values()) {
                    if(book.HasBeenRead() == true) {
                        String bookString = check + " - " + book.getTitle() + " by " + book.getAuthor();
                        writer.write(bookString);    
                        writer.newLine();
                    }
                    else {
                        String bookString = cross + " - " + book.getTitle() + " by " + book.getAuthor();
                        writer.write(bookString);    
                        writer.newLine();
                    }
                    
                    

                    
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serializeLibrary(Library library, String filename) {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(library);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Library deserializeLibrary(String filename) {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (Library) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new Library(); // Return a new Library if deserialization fails
        }
    }

    public static void writeToFile(String filename) {
        // Implementation of writeToFile method
    }
}

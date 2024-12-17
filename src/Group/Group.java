package Group;

import Book.Book;

import java.io.Serializable;
import java.util.TreeMap;
import java.util.Map;


public class Group implements Serializable {
    
    private String name;
    
    private Map<String, Book> books = new TreeMap<String, Book>();
    
    public Group(String name) {
        this.name = name;
    }

    public Map<String, Book> getBooks() {
        return books;
    }
    
    public int getNumberOfBooksFromGroup() {
        return books.size();
    }

    public void addBookToGroup(Book book) {
        books.put(book.getTitle(), book);
    }

    public void removeBookFromGroup(String title) {
        books.remove(title);
    }

    public Book getBookFromGroup(String title) {
        return books.get(title);
    }

    public String getNameOfGroup() {
        return name;
    }

    public void setNameOfGroup(String name) {
        this.name = name;
    }   

    public int calculateProgressOfGroup() {
        float total = books.size();
        float count = 0;
        for(Book book : books.values()) {
            if (book.HasBeenRead() == true) {
                count++;
            }
        }
        
        return Math.round((count / total) * 100);
    }

    //return an array list with all the books, not just theyr name
    

    public String toString() {
        return name + " - " + getNumberOfBooksFromGroup() + " books";
    }
}
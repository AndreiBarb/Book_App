package Group;

import Book.Book;

import java.io.Serializable;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;



public class Group implements Serializable {
    
    private String name;
    
    private Map<String, Book> books = new TreeMap<String, Book>();
    private List<Book> booksList = new ArrayList<Book>();
    
    public Group(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return booksList;
    }
    
    public int getNumberOfBooksFromGroup() {
        return books.size();
    }

    public void addBookToGroup(Book book) {
        books.put(book.getTitle(), book);
        booksList.add(book);
    }

    public void removeBookFromGroup(String title) {
        books.remove(title);
        booksList.remove(getBookFromGroup(title));
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
        for(Book book : booksList) {
            System.out.println(book.HasBeenRead());
            if (book.HasBeenRead() == true) {
                count++;
            }
        }
        System.out.println(count);
        System.out.println(total);
        System.out.println(Math.round((count / total) * 100));
        
        return Math.round((count / total) * 100);
    }

    //return an array list with all the books, not just theyr name
    

    public String toString() {
        return name + " - " + getNumberOfBooksFromGroup() + " books";
    }
}
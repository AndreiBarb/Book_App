package Book;

import java.io.Serializable;

public class Book implements Serializable{
    private String title;
    private String author;
    private boolean hasBeenRead;

    public Book(String title, String author, boolean read) {
        this.title = title;
        this.author = author;
        this.hasBeenRead = read;  
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean HasBeenRead() {
        return hasBeenRead;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setHasBeenRead(boolean read) {
        this.hasBeenRead = read;
    }

    public String toString() {
        return title + " by " + author + " has been read: " + hasBeenRead;
    }
}




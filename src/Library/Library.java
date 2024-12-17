package Library;
import Book.Book;
import Group.Group;
import Utils.Utils;


import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map;

public class Library implements Serializable {
        

        private Map<String, Group> groups = new TreeMap<String, Group>();
        private Map<String, Book> books = new TreeMap<String, Book>();

        public Library() {}
        
        //getAllBooksFromGroup
        public String getBooksFromGroup(String name) {
                if(groups.get(name) == null) {
                        return "Group not found";
                }
                else {
                        Group group = groups.get(name);
                        String result = "";
                        for(Book book : group.getBooks().values()) {
                                result += book.getTitle() + "\n";
                        }
                        return result;
                }
        }
        
        public void addGroup(String groupName) {
                //Add group to the list of groups
                Group group = new Group(groupName);
                groups.put(groupName, group);
                //Add all books from the group to the list of books
                for(Book book : group.getBooks().values()) {
                        books.put(book.getTitle(), book);
                }

        }

        public Map<String, Group> getGroups() {
                return groups;
        }

        public void addBook(String groupName, String bookTitle, String bookAuthor, boolean hasBeenRead) {
                
                
                //Verify if group is already in the list of groups
                if(groups.get(groupName) == null) {
                        Group group = new Group(groupName);
                        groups.put(groupName, group);
                }

                Group group = groups.get(groupName);
                
                //Verify if book is already in the list of books
                if(group.getBookFromGroup(bookTitle) == null) {
                        Book book = new Book(bookTitle, bookAuthor, hasBeenRead);
                        group.addBookToGroup(book);
                        books.put(bookTitle, book);
                }
        }

        public void removeGroup(String name) {
                groups.remove(name);
        }

        public void removeBook(String groupName, String title) {
                if(groups.get(groupName) == null) {
                        System.out.println("Group not found");
                }
                else {
                        Group group = groups.get(groupName);
                        group.removeBookFromGroup(title);
                        books.remove(title);
                }
        }

        public Group getGroup(String name) {
                return groups.get(name);
        }

        public Book getBook(String title) {
                return books.get(title);
        }

        public void transferBook(String old_Group_Name, String new_Group_Name, String title_Book) {
                if((getGroup(old_Group_Name) != null) && 
                (getGroup(new_Group_Name) != null) && 
                (getGroup(old_Group_Name).getBookFromGroup(title_Book) != null) && 
                (getGroup(new_Group_Name).getBookFromGroup(title_Book) == null)) {
                
                        getGroup(new_Group_Name).addBookToGroup(getBook(title_Book));
                        getGroup(old_Group_Name).removeBookFromGroup(title_Book);
                }             
        }

        public String getAllBooks() {
                String result = "";
                for(Book book : books.values()) {
                        result += book.getTitle() + "\n";
                }
                return result;
        }

        public String getAllGroups() {
                String result = "";
                for(Group group : groups.values()) {
                        result += group.getNameOfGroup() + "\n";
                }
                return result;
        }

        public int getNumberOfBooksInGroup(String name) {
                return groups.get(name).getNumberOfBooksFromGroup();
        }

        //this function will return an array with all of the groups in the library
        public List<Group> getAllGroupsArray() {
        return new ArrayList<>(groups.values());
    }

        public int getNumberOfGroups() {
                return groups.size();
        }
        
                
        
    
       

    
}



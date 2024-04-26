import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Library {
    //ArrayLists for books, users, and staff in library system
    private final LinkedList<Book> bookLinkedList = new LinkedList<>();
    private final ArrayList<User> userArrayList = new ArrayList<>();
    private final ArrayList<Staff> staffArrayList = new ArrayList<>();

    //Login hashmaps
    private final HashMap<String, String> loginInfo = new HashMap<>();
    private final HashMap<String, String> staffLoginInfo = new HashMap<>();

    Library() {
        //Adds default staff account
        Staff admin = new Staff("Admin", "Staff", "Admin", "SaferPassword", 1234);
        staffArrayList.add(admin);
        staffLoginInfo.put(admin.getUserName(), admin.getPassword());
        //Creates book list for any instance of library
        readBooksFromFile();
    }

    //Getter functions
    public User getUser(String username, String password) {
        User foundUser = null;
        for (User user : userArrayList) {
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                foundUser = user;
            }
        }
        return foundUser;
    }

    public Staff getStaff(String username, String password) {
        Staff foundStaff = null;
        for (Staff staff : staffArrayList) {
            if (staff.getUserName().equals(username) && staff.getPassword().equals(password)) {
                foundStaff = staff;
            }
        }
        return foundStaff;
    }

    public Staff getStaff(int pin) {
        Staff foundStaff = null;
        for (Staff staff : staffArrayList) {
            if (staff.getPin() == pin) {
                foundStaff = staff;
            }
        }
        return foundStaff;
    }

    public Book getBook(String title) {
        Book foundBook = null;
        for (Book book : bookLinkedList) {
            if (book.getTitle().equals(title)) {
                foundBook = book;
            }
        }
        return foundBook;
    }

    public Book getBook(String title, String author) {
        Book foundBook = null;
        for (Book book : bookLinkedList) {
            if (book.getTitle().equals(title) && book.getAuthor().equals(author)) {
                foundBook = book;
            }
        }
        return foundBook;
    }

    public String getBookList() {
        StringBuilder list = new StringBuilder();
        for (Book book : bookLinkedList) {
            list.append(book.toString()).append("\n");
        }
        return list.toString();
    }

    //Adding methods
    public void addBook(Book book) {
        bookLinkedList.add(book);
    }

    public void addUser(User user) {
        userArrayList.add(user);
        loginInfo.put(user.getUserName(), user.getPassword());
    }

    public void addStaff(Staff staff) {
        staffArrayList.add(staff);
        staffLoginInfo.put(staff.getUserName(), staff.getPassword());
    }

    //Removing methods
    public void removeBook(Book book) {
        bookLinkedList.remove(book);
    }

    public void removeUser(User user) {
        for (Book book : user.getBookList()) {
            book.setAvailable(true);
        }
        userArrayList.remove(user);
        loginInfo.remove(user.getUserName());
    }

    public void removeStaff(Staff staff) {
        for (Book book : staff.getBookList()) {
            book.setAvailable(true);
        }
        staffArrayList.remove(staff);
        staffLoginInfo.remove(staff.getUserName());
    }

    //Login methods
    public boolean userLogin(String username, String password) {
        return loginInfo.containsKey(username) && loginInfo.get(username).equals(password);
    }

    public boolean staffLogin(String username, String password) {
        return staffLoginInfo.containsKey(username) && staffLoginInfo.get(username).equals(password);
    }

    //Reading all the books from booklist.txt
    private void readBooksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("booklist.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(", ");

                String title = null;
                String author = null;
                String isbn = null;

                for (String part : parts) {
                    if (part.startsWith("Title: ")) {
                        title = part.substring("Title: ".length()).trim();
                    } else if (part.startsWith("Author: ")) {
                        author = part.substring("Author: ".length()).trim();
                    } else if (part.startsWith("ISBN: ")) {
                        isbn = part.substring("ISBN: ".length()).trim();
                    }
                }

                if (title != null && author != null && isbn != null) {
                    bookLinkedList.add(new Book(title, author, isbn));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

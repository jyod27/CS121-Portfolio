import java.util.LinkedList;

public class User {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private int remainingCheckOuts;
    private LinkedList<Book> userBookList;

    public User (String firstName, String lastName, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        //Individual list for each user's books
        userBookList = new LinkedList<>();
        this.remainingCheckOuts = 5;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public LinkedList<Book> getBookList() {
        return userBookList;
    }

    public String getBookListString() {
        StringBuilder userList = new StringBuilder();
        for(Book book: userBookList) {
            userList.append(book.toString() + "\n");
        }
        return userList.toString();
    }


    public String checkOut(Book book) {
        if (remainingCheckOuts > 0 ) {
            if(book.getAvailable()) {
                userBookList.add(book);
                remainingCheckOuts --;
                book.setAvailable(false);
                return book.getTitle() + " is now yours!";
            } else {
                return "Book is unavailable.";
            }
        } else {
            return "You have reached the max amount of books for your account. Please return a book to check out another.";
        }
    }

    public void returnBook(Book book) {
        userBookList.remove(book);
        remainingCheckOuts ++;
        book.setAvailable(true);
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s \nUsername: %s \nPassword: %s \nBooks checked out: %s \nRemaining number of books allowed: %d",
                firstName, lastName, userName, password, getBookListString(), remainingCheckOuts);
    }
}

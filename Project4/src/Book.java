public class Book {
    private String title, author;
    private String isbn;
    private boolean isAvailable;

    public Book (String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public boolean getAvailable() {
        return this.isAvailable;
    }

    //For updating availability when checked out/returned
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public String toString() {
        String avail;
        if(this.isAvailable) {
            avail = "Yes";
        } else {
            avail = "No";
        }
        return String.format("%s By: %s ISBN: %s Available: %s\n", title, author, isbn, avail);
    }
}

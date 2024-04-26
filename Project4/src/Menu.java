import java.util.Scanner;

public class Menu {
    //Instances of scanner and library
    Library library = new Library();
    Scanner scnr = new Scanner(System.in);

    //Menu foundation/root display
    public void display() {
        while (true) {
            System.out.println("Welcome!");
            System.out.println("Please make a selection:");
            System.out.println("1) User Login");
            System.out.println("2) Staff Login");
            System.out.println("3) Create New Account");
            System.out.println("4) Exit");
            int input = Integer.parseInt(scnr.nextLine());
            if (input == 1) {
                userLogin();
            } else if (input == 2) {
                staffLogin();
            } else if (input == 3) {
                createNewAccount();
            } else if (input == 4) {
                System.out.println("Goodbye:)");
                break;
            } else {
                System.out.println("Invalid Entry, please try again.");
            }

        }
    }

    //Logins for user and staff (display() options 1 & 2)
    //Sends to userMenu()
    public void userLogin() {
            System.out.print("Please enter username: ");
            String username = scnr.nextLine();
            System.out.print("Please enter password: ");
            String password = scnr.nextLine();
            if (library.userLogin(username, password)) {
                userMenu(username, password);
            } else {
                System.out.println("Incorrect username or password.");
            }
    }

    //Sends to staffMenu()
    public void staffLogin() {
            System.out.println("Please enter username: ");
            String username = scnr.nextLine();
            System.out.println("Please enter password: ");
            String password = scnr.nextLine();
            if (library.staffLogin(username, password)) {
                staffMenu(username, password);
            } else {
                System.out.println("Incorrect username or password.");
        }
    }

    //Creating new user account (display() option 3)
    public void createNewAccount() {
        System.out.print("Please enter first name: ");
        String firstName = scnr.nextLine();
        System.out.print("Please enter last name: ");
        String lastName = scnr.nextLine();
        System.out.print("Please enter username: ");
        String username = scnr.nextLine();
        System.out.print("Please enter password: ");
        String password = scnr.nextLine();
        User newUser = new User(firstName, lastName, username, password);
        library.addUser(newUser);
        System.out.println("Welcome " + firstName + " " + lastName + "\n");
        userMenu(username, password);
    }

    //User menu and methods
    public void userMenu(String username, String password) {
        //Allows all edits to happen to the instance that logged in
        User user = library.getUser(username, password);
        //User menu display
        while (true) {
            System.out.println("\nPlease make a selection: ");
            System.out.println("1) Search catalog");
            System.out.println("2) Browse catalog");
            System.out.println("3) Check out a book");
            System.out.println("4) Return a book");
            System.out.println("5) See account info");
            System.out.println("6) Delete account");
            System.out.println("7) Exit to main menu");
            int input = Integer.parseInt(scnr.nextLine());
            if (input == 1) {
                searchCatalog();
            } else if (input == 2) {
                //No need for custom menu, call directly to Library class
                System.out.println(library.getBookList());
            } else if (input == 3) {
                checkOut(user);
            } else if (input == 4) {
                returnBook(user);
            } else if (input == 5) {
                //No need for custom menu, call directly to User class
                System.out.println(user.toString());
            } else if (input == 6){
                deleteUserAccount(user);
                break;
            } else if (input == 7){
                //Returns to display()
                break;
            } else {
                System.out.println("Invalid Entry, please try again.");
            }
        }
    }

    //userMenu() and staffMenu() option 1
    public void searchCatalog() {
        System.out.print("Enter the title to search: ");
        String search = scnr.nextLine();
        System.out.println(library.getBook(search));
    }

    //userMenu() option 3
    public void checkOut(User user) {
        System.out.print("Title: ");
        String title = scnr.nextLine();
        System.out.print("Author: ");
        String author = scnr.nextLine();
        System.out.println(user.checkOut(library.getBook(title, author)));
    }

    //userMenu() and staffMenu() option 4
    public void returnBook(User user) {
            System.out.println("Please select a book to return: \n");
            System.out.print(user.getBookListString());
            String title = scnr.nextLine();
            if (user.getBookListString().contains(title)) {
                user.returnBook(library.getBook(title));
            } else {
                System.out.println("Invalid Entry, please try again.");
            }
    }

    //userMenu() option 6
    public void deleteUserAccount(User user) {
            System.out.print("Please enter your password to confirm: ");
            String password = scnr.nextLine();
            if (user.getPassword().equals(password)) {
                library.removeUser(user);
                System.out.println("Account deleted");
            }
    }

    //Staff menu and methods
    public void staffMenu(String username, String password) {
        //Allows all edits to happen to the instance of Staff that logged in
        Staff staff = library.getStaff(username, password);
        //Staff menu display
        while (true) {
            System.out.println("\nPlease make a selection: ");
            System.out.println("1) Search catalog");
            System.out.println("2) Browse catalog");
            System.out.println("3) Check out a book");
            System.out.println("4) Return a book");
            System.out.println("5) See account info");
            System.out.println("6) Delete an account");
            System.out.println("7) Add staff");
            System.out.println("8) Add book to library");
            System.out.println("9) Remove book from library");
            System.out.println("10) Exit to main menu");
            int input = Integer.parseInt(scnr.nextLine());
            if (input == 1) {
                searchCatalog();
            } else if (input == 2) {
                //No need for custom method, calls directly to Library class
                System.out.println(library.getBookList());
            } else if (input == 3) {
                checkOut(staff);
            } else if (input == 4) {
                returnBook(staff);
            } else if (input == 5) {
                //No need for custom method, calls directly to Staff class
                System.out.println(staff.toString());
            } else if (input == 6){
                deleteStaffAccount();
            } else if (input == 7){
                addStaff();
            } else if (input == 8){
                addBook();
            } else if (input == 9) {
                removeBook();
            } else if (input == 10) {
                break;
            } else {
                System.out.println("Invalid entry, please try again.");
            }
        }
    }

    //staffMenu() option 3 (Overloaded checkOut())
    public void checkOut(Staff staff) {
        if(staff.getUserName().equals("Admin") && staff.getPassword().equals("SaferPassword")) {
            System.out.println("Cannot check out books on Admin account, please log into your staff account to check out a book.");
        } else {
            System.out.print("Title: ");
            String title = scnr.nextLine();
            System.out.print("Author: ");
            String author = scnr.nextLine();
            System.out.println(staff.checkOut(library.getBook(title, author)));
        }
    }

    //staffMenu() option 6
    public void deleteStaffAccount() {
        System.out.print("Enter staff pin: ");
        int pin = Integer.parseInt(scnr.nextLine());
        if (pin == 1234) {
            System.out.println("Unable to delete admin staff account.");
        } else {
            Staff staff = library.getStaff(pin);
            System.out.print("Confirm deletion with password: ");
            String password = scnr.nextLine();
            if (staff.getPassword().equals(password)) {
                library.removeStaff(staff);
                System.out.println("Staff successfully removed.");
            } else {
                System.out.println("Invalid password");
            }
        }
    }

    //staffMenu() option 7
    public void addStaff() {
        System.out.print("Enter first name: ");
        String firstName = scnr.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scnr.nextLine();
        System.out.print("Enter username:");
        String username = scnr.nextLine();
        System.out.print("Enter password:");
        String password = scnr.nextLine();
        System.out.print("Enter 4 digit pin:");
        int pin;
        while (true) {
            pin = Integer.parseInt(scnr.nextLine());
            if (library.getStaff(pin) != null) {
                System.out.println("Pin already exists, please choose another.");
            } else {
                break;
            }
        }
        Staff staff = new Staff(firstName, lastName, username, password, pin);
        library.addStaff(staff);
    }

    //staffMenu() option 8
    public void addBook() {
        System.out.print("Enter the title: ");
        String title = scnr.nextLine();
        System.out.print("Enter the author: ");
        String author = scnr.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scnr.nextLine();

        Book book = new Book(title, author, isbn);
        library.addBook(book);
        System.out.printf("%s By: %s added to collection.\n", title, author);
    }

    //staffMenu() option 9
    public void removeBook() {
        System.out.print("Enter the title: ");
        String title = scnr.nextLine();
        System.out.print("Enter the author: ");
        String author = scnr.nextLine();
        Book book = library.getBook(title, author);
        library.removeBook(book);
        System.out.printf("%s By: %s removed from collection.\n", title, author);
    }
}

import java.util.ArrayList;

public class Customer {
    private String firstName, lastName;
    private int pin;
    ArrayList<Account> accounts = new ArrayList<>();

    //Constructor
    public Customer(String first, String last, int pin) {
        this.firstName = first;
        this.lastName = last;
        this.pin = pin;
    }

    //Getters and setters

    public int getPin() {
        return pin;
    }

    //Add account
    public void addAccount(Account account) {
        accounts.add(account);
    }

    //Remove account
    public void closeAccount(Account account) {
        accounts.remove(account);
        System.out.println("Account number " + account.getAccNum() + " has been closed.\n");
    }

    //Get account
    public Account getAccount(int accountNum) {
        Account foundAccount = null;
        for(Account account: accounts) {
            if(account.getAccNum() == (accountNum)) {
                foundAccount = account;
                break;
            }
        }
        return foundAccount;
    }

    public String getAccountList() {
        StringBuilder sb = new StringBuilder();
        for (Account account : accounts) {
            sb.append(account.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format("Account name: %s %s     Pin: %d", firstName, lastName, pin);
    }
}

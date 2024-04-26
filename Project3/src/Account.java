public class Account {
    private double balance = 0;
    private int accNum;
    static int numAccounts = 1000;

    //Constructor
    public Account(double deposit) {
        this.balance += deposit;
        numAccounts ++;
        this.accNum = numAccounts;
    }

    //Getters and setters

    public int getAccNum() {
        return accNum;
    }

    //Deposit
    public void deposit(double deposit) {
        balance += deposit;
        System.out.printf("%.2f deposited \nAccount balance: %.2f\n", deposit, balance);
    }

    //Withdraw
    public void withdraw(double withdrawal) {
        if (withdrawal > balance) {
            System.out.println("Insufficient funds");
        } else {
            balance -= withdrawal;
            System.out.printf("%.2f withdrawn \nAccount balance: %.2f\n", withdrawal, balance);
        }
    }

    //to string
    @Override
    public String toString() {
        return String.format("Account number: %d \nAccount Balance: %.2f", accNum, balance);
    }

}

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner scnr = new Scanner(System.in);
    Bank bank = new Bank();

    //Display menu
    public void displayMenu() {
        while (true) {
            System.out.println("************Menu************");
            System.out.println("Please make a selection:");
            System.out.println("1) Access Account");
            System.out.println("2) Open Account");
            System.out.println("3) Close All Accounts");
            System.out.println("4) Exit");
            int input = Integer.parseInt(scnr.nextLine());
            if (input == 1) {
                accessAccount();
            } else if (input == 2) {
                openAccount();
            } else if (input == 3) {
                closeAccounts();
            } else if (input == 4) {
                System.out.println("Thank you for using my banking project.");
                System.out.println("Goodbye");
                break;
            } else {
                System.out.println("Invalid entry.\n");
            }
        }
    }

    //Access account
    private void accessAccount() {
        System.out.println("Enter your pin:");
        int pin = Integer.parseInt(scnr.nextLine());
        Customer customer = bank.getCustomer(pin);
        if (customer == null) {
            System.out.println("PIN is not valid\n");
            return;
        } else {
            System.out.println("*****Active Accounts*****");
            System.out.println(customer.getAccountList());
            System.out.println("Which account would you like to access?");
            int account = Integer.parseInt(scnr.nextLine());
            Account accountInfo = customer.getAccount(account);
            if (accountInfo == null) {
                System.out.println("Account Number Invalid\n");
                return;
            } else {
                //Making edits to accessed account
                while (true) {
                    System.out.println("Please make a selection: ");
                    System.out.println("1) Make a deposit");
                    System.out.println("2) Make a withdrawal");
                    System.out.println("3) See account balance");
                    System.out.println("4) Close account");
                    System.out.println("5) Exit");
                    int input = Integer.parseInt(scnr.nextLine());
                    if (input == 1) {
                        System.out.print("Enter your deposit amount:");
                        double deposit = Double.parseDouble(scnr.nextLine());
                        accountInfo.deposit(deposit);
                    } else if (input == 2) {
                        System.out.print("Enter your withdraw amount:");
                        double withdraw = Double.parseDouble(scnr.nextLine());
                        accountInfo.withdraw(withdraw);
                    } else if (input == 3) {
                        System.out.println(accountInfo);
                    } else if (input == 4) {
                        customer.closeAccount(accountInfo);
                    } else if (input == 5) {
                        break;
                    } else {
                        System.out.println("Invalid Entry\n");
                    }
                }
            }
        }
    }

    //Opens accounts
    private void openAccount() {
        System.out.println("Are you a new customer?");
        System.out.println("1) Yes");
        System.out.println("2) No");
        int input = Integer.parseInt(scnr.nextLine());
        //New User
        if (input == 1) {
            createNewCustomer();
            System.out.print("Please re-enter your PIN: ");
            int pin = Integer.parseInt(scnr.nextLine());
            System.out.print("Enter deposit amount: ");
            bank.getCustomer(pin).addAccount(new Account(Double.parseDouble(scnr.nextLine())));
            System.out.print("New Account Opened \nAccount Number: " + Account.numAccounts + "\n\n");
        } else if (input == 2) {
            //Returning customer
            System.out.print("Please enter your PIN: ");
            int pin = Integer.parseInt(scnr.nextLine());
            if (bank.getCustomer(pin) == null) {
                System.out.println("Invalid PIN");
                return;
            } else {
                System.out.print("Enter deposit amount:");
                bank.getCustomer(pin).addAccount(new Account(Double.parseDouble(scnr.nextLine())));
                System.out.print("New Account Opened \nAccount Number: " + Account.numAccounts + "\n\n");
            }

        } else {
            return;
        }
    }

    //New customer
    private Customer createNewCustomer() {
        System.out.print("Enter first name:");
        String first = scnr.nextLine();
        System.out.print("Enter last name:");
        String last = scnr.nextLine();
        System.out.print("Enter custom PIN:");
        int pin = Integer.parseInt(scnr.nextLine());
        Customer customer = new Customer(first, last, pin);
        bank.addCustomer(customer);
        return customer;
    }

    //Closing accounts and removed from system
    private void closeAccounts() {
        System.out.print("Please enter your PIN: ");
        int pin = Integer.parseInt(scnr.nextLine());
        if (bank.getCustomer(pin) == null) {
            return;
        } else {
            Customer customer = bank.getCustomer(pin);
            bank.removeCustomer(customer);
            System.out.println("Customer removed from bank registry.\n");
        }
    }
}

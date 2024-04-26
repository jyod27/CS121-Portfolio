import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> customerArrayList = new ArrayList<>();

    //Adds customer
    public void addCustomer(Customer customer) {
        customerArrayList.add(customer);
    }

    //Removes customer
    public void removeCustomer(Customer customer) {
        customerArrayList.remove(customer);
    }

    //Get customer by pin
    public Customer getCustomer(int pin) {
        Customer customerFound = null;
        for (Customer customer : customerArrayList) {
            if(customer.getPin() == pin) {
                customerFound = customer;
                break;
            }
        }
        return customerFound;
    }

    //Gets customer info
    public String getCustomerInfo(Customer customer) {
        return customer.toString();
    }


}

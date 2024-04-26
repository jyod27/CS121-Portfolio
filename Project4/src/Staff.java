public class Staff extends User{
    private int pin;

    public Staff (String firstName, String lastName, String userName, String password, int pin) {
        super(firstName, lastName, userName, password);
        this.pin = pin;
    }

    public int getPin() {
        return this.pin;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\nPin: %d", pin);
    }

}

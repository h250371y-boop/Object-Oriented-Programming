/**
 * Abstract class representing a bank account.
 * Demonstrates abstraction and encapsulation in Java.
 */
public abstract class Account {
    // Unique identifier for the account
    protected String accountNumber;
    // Current balance of the account
    protected double balance;

    // Constructor
    /**
     * @param accountNumber Unique account identifier
     * @param balance Initial balance
     */
    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Concrete deposit method
    /**
     * Deposit money into the account.
     * Rejects deposits of zero or negative amounts.
     * @param amount Amount to deposit
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit rejected: Amount must be greater than 0.");
        } else {
            balance += amount;
            System.out.println("Deposit successful: $" + amount);
        }
    }

    // Concrete getBalance method
    /**
     * Get the current balance of the account.
     * @return Current balance
     */
    public double getBalance() {
        return balance;
    }
        /**
     * Get the account number.
     * @return Account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    // Abstract methods
    // Abstract methods to be implemented by subclasses
    /**
     * Withdraw money from the account.
     * @param amount Amount to withdraw
     */
    public abstract void withdraw(double amount);
    /**
     * Perform end-of-month operations (e.g., interest, fees).
     */
    public abstract void endOfMonth();
}
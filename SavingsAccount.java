/**
 * SavingsAccount class extends Account.
 * Represents a savings account with minimum balance rules
 * and monthly interest calculations.
 */
public class SavingsAccount extends Account {

    // Minimum balance required to maintain the account
    private final double minimumBalance = 200.00;

    // Monthly interest rate applied to the account balance
    private final double interestRate = 0.02;

    /**
     * Constructor to initialize a SavingsAccount.
     * @param accountNumber Unique account identifier
     * @param balance Initial balance
     */
    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /**
     * Withdraw money from the savings account.
     * Rules:
     * - Rejects withdrawals of zero or negative amounts.
     * - Rejects withdrawals that would reduce balance below minimum.
     * - Otherwise deducts amount from balance.
     * @param amount Amount to withdraw
     */
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal rejected: Amount must be greater than 0.");
        }
        else if (balance - amount < minimumBalance) {
            System.out.println("Savings withdrawal rejected: "
                + "Balance cannot fall below minimum of $"
                + minimumBalance);
        }
        else {
            balance -= amount;
            System.out.println("Savings withdrawal successful: $" + amount);
        }
    }

    /**
     * End-of-month processing for savings accounts.
     * Adds interest to the balance based on the interest rate.
     */
    @Override
    public void endOfMonth() {
        double interest = balance * interestRate;
        balance += interest;

        System.out.println("Savings Account interest added: $"
            + String.format("%.2f", interest));
    }
}

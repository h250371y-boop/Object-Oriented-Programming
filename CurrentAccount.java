/**
 * CurrentAccount class extends Account.
 * Represents a current account with overdraft facilities
 * and monthly maintenance fees.
 */
public class CurrentAccount extends Account {

    // Maximum overdraft limit allowed
    private final double overdraftLimit = 300.00;

    // Monthly maintenance fee charged to the account
    private final double monthlyFee = 25.00;

    /**
     * Constructor to initialize a CurrentAccount.
     * @param accountNumber Unique account identifier
     * @param balance Initial balance
     */
    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /**
     * Withdraw money from the current account.
     * Rules:
     * - Rejects withdrawals of zero or negative amounts.
     * - Rejects withdrawals that exceed overdraft limit.
     * - Otherwise deducts amount from balance.
     * @param amount Amount to withdraw
     */
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal rejected: Amount must be greater than 0.");
        }
        else if (balance - amount < -overdraftLimit) {
            System.out.println("Current withdrawal rejected: "
                + "Overdraft limit of $" + overdraftLimit + " exceeded.");
        }
        else {
            balance -= amount;
            System.out.println("Current withdrawal successful: $" + amount);
        }
    }

    /**
     * End-of-month processing for current accounts.
     * Deducts a fixed monthly maintenance fee from the balance.
     */
    @Override
    public void endOfMonth() {
        balance -= monthlyFee;

        System.out.println("Current Account maintenance fee deducted: $"
            + String.format("%.2f", monthlyFee));
    }
}

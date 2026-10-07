import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates polymorphism using a hierarchy of bank account types.
 *
 * A single List<Account> holds different account subclasses
 * (SavingsAccount, CurrentAccount). Calls to withdraw() and endOfMonth()
 * are resolved at runtime, so each account type applies its own rules
 * without this class needing to know which type it is dealing with.
 */
public class BankDemo {

    /**
     * Entry point: creates accounts, shows balances, performs withdrawals
     * and runs the end-of-month processing.
     */
    public static void main(String[] args) {

        // Create a list typed to the parent class (Account), so it can hold
        // any subclass of Account
        List<Account> accounts = new ArrayList<>();

        // Add different account types; each is stored as a plain Account reference
        accounts.add(new SavingsAccount("SAV001", 1000.00)); // account number, opening balance
        accounts.add(new CurrentAccount("CUR001", 500.00));  // account number, opening balance

        System.out.println("========== BANK ACCOUNT DEMO ==========\n");

        // Display initial balances.
        // Only methods defined on Account are used here, so this works for every type.
        for (Account account : accounts) {
            System.out.println("Account: " + account.getAccountNumber());
            // Format the balance to 2 decimal places for currency display
            System.out.println("Initial Balance: $"
                    + String.format("%.2f", account.getBalance()));
            System.out.println();
        }

        System.out.println("========== WITHDRAWALS ==========\n");

        // Savings withdrawal - should be rejected
        // (index 0 is the SavingsAccount added above; the withdrawal is
        // expected to violate SavingsAccount's rules, so the balance should not change)
        Account savings = accounts.get(0);

        System.out.println("Savings Account:");
        savings.withdraw(850.00); // SavingsAccount's version of withdraw() runs

        // Show the balance afterwards to confirm whether the withdrawal was applied
        System.out.println("Balance: $"
                + String.format("%.2f", savings.getBalance()));

        System.out.println();

        // Current withdrawal - should go into overdraft
        // (index 1 is the CurrentAccount; withdrawing more than the balance
        // is expected to be allowed, leaving the account overdrawn)
        Account current = accounts.get(1);

        System.out.println("Current Account:");
        current.withdraw(700.00); // CurrentAccount's version of withdraw() runs

        // A negative balance here indicates the account is in overdraft
        System.out.println("Balance: $"
                + String.format("%.2f", current.getBalance()));

        System.out.println();

        System.out.println("========== END OF MONTH ==========\n");

        // Polymorphic loop: the same endOfMonth() call behaves differently
        // depending on the actual object type (e.g. interest for savings,
        // overdraft charges for current accounts)
        for (Account account : accounts) {

            System.out.println("Account: " + account.getAccountNumber());

            // Runtime dispatch picks the correct subclass implementation
            account.endOfMonth();

            // Display the balance after end-of-month adjustments
            System.out.println("Final Balance: $"
                    + String.format("%.2f", account.getBalance()));

            System.out.println();
        }
    }
}
# Bank Account Management System (Java)

A small object-oriented Java project that models savings and current accounts. It demonstrates **abstraction**, **encapsulation**, **inheritance**, and **runtime polymorphism**.

## Features

- `Account` is an abstract base class with shared account data, deposit and balance methods, and abstract withdrawal and month-end operations.
- `SavingsAccount` enforces a minimum balance of $200 and earns 2% monthly interest.
- `CurrentAccount` supports an overdraft of up to $300 and charges a $25 monthly maintenance fee.
- `BankDemo` stores both account types in a `List<Account>` and invokes overridden methods polymorphically.
- Withdrawal and deposit rules reject zero or negative amounts.

## Project files

| File | Purpose |
| --- | --- |
| `Account.java` | Abstract account superclass and shared operations |
| `SavingsAccount.java` | Savings rules, withdrawals, and interest calculation |
| `CurrentAccount.java` | Overdraft rules, withdrawals, and monthly fee |
| `BankDemo.java` | Demonstrates the account types and polymorphic behavior |
| `Sample Output.docx` | Reference output supplied with the project |

The `.class` files are compiled Java bytecode. The `.java` files are the editable source code.

## Requirements

Install a JDK (Java Development Kit) and make `java` and `javac` available from your terminal. Check with:

```shell
java -version
javac -version
```

## Compile and run

Open a terminal in the project folder and compile all source files:

```shell
javac Account.java SavingsAccount.java CurrentAccount.java BankDemo.java
```

Then run the demo:

```shell
java BankDemo
```

## What the demo does

1. Creates a savings account with an opening balance of **$1,000.00** and a current account with **$500.00**.
2. Attempts to withdraw **$850.00** from savings. The withdrawal is rejected because it would leave less than the $200 minimum; the balance remains $1,000.00.
3. Withdraws **$700.00** from the current account. The account goes to **−$200.00**, which is within the $300 overdraft limit.
4. Runs month-end processing. Savings receives **$20.00** interest and ends at **$1,020.00**. The current account is charged **$25.00** and ends at **−$225.00**.

Balances are displayed to two decimal places. The exact messages and formatting are defined in `BankDemo.java`, `SavingsAccount.java`, and `CurrentAccount.java`.

## OOP concepts shown

- **Abstraction:** `Account` declares account operations without prescribing each account's rules.
- **Inheritance:** both account types extend `Account` and reuse its shared balance and account-number state.
- **Polymorphism:** calls to `withdraw()` and `endOfMonth()` on an `Account` reference run the implementation for the actual account object.
- **Encapsulation:** account operations update the balance through methods rather than changing it from the demo.

## Notes

This is an educational console example. It uses `double` for money and prints messages instead of returning transaction results; real financial software should use `BigDecimal` and a more robust transaction/error model.

abstract class Account {
    private String accountNumber;
    protected long balance;

    public Account(String accountNumber, long initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public abstract double interestRate();
    public abstract boolean canWithdraw(long amount);

    public void deposit(long amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(long amount) {
        if (amount > 0 && canWithdraw(amount)) {
            balance -= amount;
            System.out.println("Withdrew " + amount + " successfully.");
        } else {
            System.out.println("Withdrawal of " + amount + " REJECTED due to account rules.");
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }
}

class SavingsAccount extends Account {
    private long minBalance;

    public SavingsAccount(String accountNumber, long initialBalance, long minBalance) {
        super(accountNumber, initialBalance);
        this.minBalance = minBalance;
    }

    @Override
    public double interestRate() {
        return 4.0;
    }

    @Override
    public boolean canWithdraw(long amount) {
        return (balance - amount) >= minBalance;
    }
}

class CurrentAccount extends Account {
    private long overdraftLimit;

    public CurrentAccount(String accountNumber, long initialBalance, long overdraftLimit) {
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double interestRate() {
        return 0.0;
    }

    @Override
    public boolean canWithdraw(long amount) {
        return (balance - amount) >= -overdraftLimit;
    }
}

class FixedDepositAccount extends Account {
    public FixedDepositAccount(String accountNumber, long initialBalance) {
        super(accountNumber, initialBalance);
    }

    @Override
    public double interestRate() {
        return 7.0;
    }

    @Override
    public boolean canWithdraw(long amount) {
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Account[] accounts = new Account[] {
            new SavingsAccount("SAV-101", 5000, 1000),
            new CurrentAccount("CUR-202", 2000, 3000),
            new FixedDepositAccount("FIX-303", 10000)
        };

        System.out.println("=== MiniBank Processing ===");

        for (Account acc : accounts) {
            System.out.println("------------------------------------------");
            System.out.printf("Account No: %s | Current Balance: %d%n",
                    acc.getAccountNumber(), acc.getBalance());

            System.out.printf("Interest Rate: %.1f%%%n", acc.interestRate());

            System.out.print("Attempting to withdraw 4500: ");
            acc.withdraw(4500);

            if (acc instanceof FixedDepositAccount fdAcc) {
                System.out.println("-> SPECIAL NOTE: This is a Fixed Deposit Account. Funds are safely locked away!");
            }
        }

        System.out.println("------------------------------------------");
    }
}
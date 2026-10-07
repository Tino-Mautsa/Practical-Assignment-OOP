
class SavingsAccount extends Account {
    private double minimumBalance = 100.0;
    private double interestRate = 0.03;

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount < minimumBalance) {
            System.out.println("Account " + accountNumber + ": Withdrawal of " + amount
                    + " rejected. Balance cannot go below the minimum of " + minimumBalance + ".");
        } else {
            balance -= amount;
            System.out.println("Account " + accountNumber + ": Withdrew " + amount + ": New balance: " + balance);
        }
    }

    @Override
    public void endOfMonth() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Account " + accountNumber + ": Interest added: " + interest + ": New balance: " + balance);
    }
}

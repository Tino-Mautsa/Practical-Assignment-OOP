
class CurrentAccount extends Account {
    private double overdraftLimit = 500.0;
    private double monthlyFee = 20.0;

    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount < -overdraftLimit) {
            System.out.println("Account " + accountNumber + ": Withdrawal of " + amount
                    + " rejected. It would exceed the overdraft limit of " + overdraftLimit + ".");
        } else {
            balance -= amount;
            System.out.println("Account " + accountNumber + ": Withdrew " + amount + ": New balance: " + balance);
        }
    }

    @Override
    public void endOfMonth() {
        balance -= monthlyFee;
        System.out.println("Account " + accountNumber + ": Maintenance fee of " + monthlyFee
                + " deducted New balance: " + balance);
    }
}

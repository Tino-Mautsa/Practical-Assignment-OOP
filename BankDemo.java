import java.util.ArrayList;
import java.util.List;


public class BankDemo {
    public static void main(String[] args) {


        List<Account> accounts = new ArrayList<Account>();
        accounts.add(new SavingsAccount("SAV-001", 500.0));
        accounts.add(new CurrentAccount("CUR-001", 200.0));
        accounts.add(new SavingsAccount("SAV-002", 1000.0));
        accounts.add(new CurrentAccount("CUR-002", 50.0));


        System.out.println("=== Deposits ===");
        for (Account acc : accounts) {
            acc.deposit(100.0);
        }


        System.out.println("\n=== Withdrawals (polymorphic loop) ===");
        for (Account acc : accounts) {
            acc.withdraw(550.0);
        }


        System.out.println("\n=== End of Month (polymorphic loop) ===");
        for (Account acc : accounts) {
            acc.endOfMonth();
        }


        System.out.println("\n=== Final Balances ===");
        for (Account acc : accounts) {
            System.out.println("Balance: " + acc.getBalance());
        }


        System.out.println("\n=== Edge Case 1: Savings withdrawal below minimum ===");
        Account sav = new SavingsAccount("SAV-003", 150.0);
        sav.withdraw(100.0);


        System.out.println("\n=== Edge Case 2: Current account into overdraft ===");
        Account cur = new CurrentAccount("CUR-003", 100.0);
        cur.withdraw(400.0);
    }
}

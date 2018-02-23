import domain.Account;
import domain.CashMachine;

public class App {

    public static void main(String[] args) {

        Account account = new Account(100);
        CashMachine machine = new CashMachine(50);

        System.out.println(account + System.lineSeparator() + machine);

        transactionalWithdrawal(account, machine, 60);

        System.out.println(account + System.lineSeparator() + machine);

    }

    private static void transactionalWithdrawal(Account account, CashMachine machine, int amount) {

        // stan systemu przed wykonaniem operacji
        Account accountBackup = account.copy();
        CashMachine machineBackup = machine.copy();

        try {
            account.withdraw(amount);
            machine.withdraw(amount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Coś poszło nie tak. Przywracam stan systemu");
            account.recreate(accountBackup);
            machine.recreate(machineBackup);
        }


    }
}

package domain;

public class Account {

    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public void withdraw(int amount) {
        this.balance-=amount;
    }

    public void deposit(int amount) {
        this.balance+=amount;
    }

    @Override
    public String toString() {
        return "Aktualny stan konta: " + this.balance;
    }

    public Account copy() {
        return new Account(this.balance);
    }

    public void recreate(Account account) {
        this.balance = account.balance;
    }
}

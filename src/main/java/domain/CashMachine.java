package domain;

public class CashMachine {

    private int cashAmount;

    public CashMachine(int cashAmount) {
        this.cashAmount = cashAmount;
    }

    public void withdraw(int amount) {
        if(this.cashAmount-amount<0) {
            throw new IllegalStateException("Brak dostatecznej ilosci gotówki.");
        }
        this.cashAmount-=amount;
    }

    @Override
    public String toString() {
        return "Pozostała gotówka: " + this.cashAmount;
    }

    public CashMachine copy() {
        return new CashMachine(this.cashAmount);
    }

    public void recreate(CashMachine machine) {
        this.cashAmount = machine.cashAmount;
    }
}

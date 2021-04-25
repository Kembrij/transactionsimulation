package transactionsimulation;

public class Balance {

    private double amount;

    public Balance() {
        this.amount = 0.0;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean addToAmount(double amount) {
        if (amount >= 0) {
            this.amount += amount;
            return true;
        } else return false;

    }

    public boolean substractFromAmount(double amount) {
        if (this.amount >= amount) {
            this.amount -= amount;
            return true;
        }
        else {
            this.amount = 0;
            return true;
        }

    }

    public double getAmount() {
        return amount;
    }
}

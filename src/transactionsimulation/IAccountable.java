package transactionsimulation;

public interface IAccountable {

    public boolean deposit(double amount);

    public boolean withdraw(double amount);
}

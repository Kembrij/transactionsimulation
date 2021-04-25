package transactionsimulation;

public interface ITransaction {
    boolean transfer() throws InterruptedException;
    void setTransactionId(int transactionId);
}

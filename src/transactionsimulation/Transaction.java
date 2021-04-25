package transactionsimulation;

import java.time.LocalDateTime;

public class Transaction implements ITransaction, Runnable {

    private Integer transactionId;
    private LocalDateTime currentTime;
    private double amount;
    private IAccountable originalAcc;
    private IAccountable targetAcc;

    public LocalDateTime getCurrentTime() {
        return currentTime;
    }


    public Transaction(IAccountable originalAcc, IAccountable targetAcc, double amount) {
        this.originalAcc = originalAcc;
        this.targetAcc = targetAcc;
        this.amount = amount;
        currentTime = LocalDateTime.now();
    }

    public void setTransactionId(int transactionId) {
        if (this.transactionId == null)
            this.transactionId = transactionId;
    }

    @Override
     public boolean transfer() throws InterruptedException {
        if (originalAcc.withdraw(amount)) {
            //Thread.sleep(300);
            if (targetAcc.deposit(amount))
                return true;
        }
        return false;
    }


    @Override
    public void run() {
        try {
            this.transfer();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

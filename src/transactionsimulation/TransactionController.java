package transactionsimulation;

import java.util.ArrayDeque;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TransactionController implements IController<ITransaction> {

    private static AppConfig appConfig = AppConfig.getInstance();
    private static int numOfThread = Integer.parseInt(appConfig.getConfParamValue("numberOfThread"));

    ArrayDeque<ITransaction> arrayDeque = new ArrayDeque<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    static Thread createNewThread(Transaction transaction) {
            return new Thread(transaction);

    }

    @Override
    public ITransaction getRandom() {
        return null;
    }

    @Override
    public ITransaction getById( String st) {
        return null;
    }

    int getTransactionNum() {
        return arrayDeque.size();
    }

    @Override
    public void add(ITransaction accountable) {
        lock.writeLock().lock();
        try {
            arrayDeque.add(accountable);
        }finally {
            lock.writeLock().unlock();
        }

    }

}

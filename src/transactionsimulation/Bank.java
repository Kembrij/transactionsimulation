package transactionsimulation;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ThreadFactory;

public class Bank {
    private final AccountController accountController;
    private final ClientController clientController;
    private final TransactionController transController;
    String name;

    public Bank(String name) {
        this.name = name;
        this.accountController = new AccountController();
        this.clientController = new ClientController();
        this.transController = new TransactionController();
    }

    void addIAccountable(IAccountable accountable) {
        accountController.add(accountable);
    }

    void prinListOfAccounts() {
        Map<String, IAccountable> map = accountController.getiAccountableHashMap();
        Set<String> keyset = map.keySet();
        Account iAcc = null;
        for (String key : keyset) {
            iAcc = (Account) map.get(key);
            System.out.println("Client: " + iAcc.getOwnerFirstName() +
                    " " + iAcc.ownerSureName +
                    " " + "accountId : " +iAcc.accountId +
                    " " + "balance : " +iAcc.getBalance().getAmount());
        }
    }

    void randomTransaction(double amount) {
        IAccountable from = accountController.getRandom();
        IAccountable to = accountController.getRandom();
        Transaction transaction = new Transaction(from, to, amount);
        Thread thread = TransactionController.createNewThread(transaction);
        thread.start();


    }
}


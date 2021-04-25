package transactionsimulation;

import java.util.Random;

public class PersonalAccount extends Account implements IAccountable {


    public PersonalAccount(String ownerFirstName, String ownerSureName) {
        super.ownerFirstName = ownerFirstName;
        super.ownerSureName = ownerSureName;
        super.accountId = 100000 + new Random().nextInt(900000);
        super.balance = new Balance();
    }

    @Override
    public synchronized boolean deposit(double amount) {
        double oldbalance = super.balance.getAmount();
        if (super.balance.addToAmount(amount)) {
            System.out.println(Thread.currentThread().getName() + " " + "У клиента " + super.ownerFirstName
                    + " " + super.ownerSureName + " произошло зачисление на счет с id " + super.accountId +
                    " суммы " + amount+" баланс был: "+oldbalance+" стал: "+super.balance.getAmount());

            return true;
        } else return false;

    }

    @Override
    public synchronized boolean withdraw(double amount) {
        double oldbalance = super.balance.getAmount();
        if (super.balance.substractFromAmount(amount)) {
            System.out.println(Thread.currentThread().getName() + " " + "У клиента " + super.ownerFirstName
                    + " " + super.ownerSureName + " произошло списание со счета с id " + super.accountId +
                    " суммы " + amount+" баланс был: "+oldbalance+" стал: "+super.balance.getAmount());
            return true;
        } else return false;


    }

    @Override
    public String toString() {
        return ownerFirstName + ownerSureName + accountId;
    }

}

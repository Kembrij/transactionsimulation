package transactionsimulation;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        Bank bank = new Bank("Bank1");
        bank.prinListOfAccounts();
        AppConfig appConfig = AppConfig.getInstance();

        int numberOfAccounts = Integer.parseInt(appConfig.getConfParamValue("numberOfAccounts"));
        int numOfThread = Integer.parseInt(appConfig.getConfParamValue("numberOfThread"));
        for (int i = 0; i < numberOfAccounts; i++) {
            bank.addIAccountable(
                    new PersonalAccount(
                            "Ivan" + i, "Ivanov" + i)
            );
        }
        bank.prinListOfAccounts();
        for (int i = 0; i < numOfThread; i++ ) {
            double amount = 100 + new Random().nextInt(10) * 10;
            bank.randomTransaction(amount);
        }


    }
}


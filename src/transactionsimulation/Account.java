package transactionsimulation;

abstract class Account {

    String ownerFirstName;
    String ownerSureName;
    Integer accountId;
    Balance balance;

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public String getOwnerSureName() {
        return ownerSureName;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public Balance getBalance() {
        return balance;
    }
}

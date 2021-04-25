package transactionsimulation;

import java.util.*;

public class AccountController implements IController<IAccountable> {

    public Map<String, IAccountable> getiAccountableHashMap() {
        return iAccountableHashMap;
    }

    Map<String, IAccountable> iAccountableHashMap;

    public AccountController() {
        this.iAccountableHashMap = new HashMap<>();
    }

    @Override
    public IAccountable getRandom() {
        Set<String> set = getiAccountableHashMap().keySet();
        ArrayList<String> arrayList = new ArrayList<>(set);
        int i = new Random().nextInt(arrayList.size());
        return iAccountableHashMap.get(arrayList.get(i));
    }

    @Override
    public IAccountable getById(String k) {
        return getiAccountableHashMap().get(k);
    }

    @Override
    public void add(IAccountable accountable) {
        double deposit = 1000 + new Random().nextInt(10) * 100;
        if (deposit > 1600) {
            deposit *= 1 + new Random().nextInt(9);
        }
        accountable.deposit(deposit);
        iAccountableHashMap.put(accountable.toString(), accountable);

    }
}

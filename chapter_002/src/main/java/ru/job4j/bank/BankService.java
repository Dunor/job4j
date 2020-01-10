package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {

    //private Map<User, List<Account>> clients = new HashMap<>();
    private Map<User, List<Account>> users = new HashMap<>();

    //добавление пользователя.
    public void addUser(User user) {
        users.putIfAbsent(user,  new ArrayList<>());
    }

    //добавить счёт пользователю.
    public void addAccount(String passport, Account account) {
        users.get(this.findByPassport(passport)).add(account);
    }

    //поиск пользователя по паспорту
    public User findByPassport(String passport) {
        User user = null;
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                user = entry.getKey();
            }
        }
        return user;
    }

    //поиск счета по реквизитам
    public Account findByRequisite(String passport, String requisite) {
        Account account = null;
        User user = findByPassport(passport);
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            if (entry.getKey().equals(user)) {
                for ( Account tmpAccount : entry.getValue()) {
                    if (tmpAccount.getRequisite().equals(requisite)) {
                        account = tmpAccount;
                        break;
                    }
                }
            }
        }
        return account;
    }

    // удаление пользователя.
    public void deleteUser(User user) {
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            if (entry.getKey().equals(user)) {
                users.remove(user);
            }
        }
    }

    //метод для перечисления денег с одного счёта на другой счёт
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dеstRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account dstAccount = findByRequisite(destPassport, dеstRequisite);
        if (srcAccount != null && dstAccount != null) {
            if (srcAccount.getBalance() >= amount) {
                dstAccount.setBalance(dstAccount.getBalance() + amount);
                srcAccount.setBalance(srcAccount.getBalance() - amount);
                rsl = true;
            }
        }
        return rsl;
    }
}

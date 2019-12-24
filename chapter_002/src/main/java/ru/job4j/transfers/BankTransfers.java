package ru.job4j.transfers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankTransfers {
    private List<Account> accounts = new ArrayList<>();
    private Map<User, List<Account>> clients = new HashMap<>();

    //добавление пользователя.
    public void addUser(User user) {
        clients.putIfAbsent(user,  accounts);
    }

    // удаление пользователя.
    public void deleteUser(User user) {
        for (Map.Entry<User, List<Account>> entry : clients.entrySet()) {
            if (entry.getKey().equals(user)) {
                clients.remove(user);
            }
        }
    }

    //добавить счёт пользователю.
    public void addAccountToUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> entry : clients.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                entry.getValue().add(account);
            }
        }

    }

    //удалить один счёт пользователя.
    public void deleteAccountFromUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> entry : clients.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                entry.getValue().remove(account);
            }
        }

    }

    //получить список счетов для пользователя.
    public List<Account> getUserAccounts (String passport) {
        List<Account> list = null;
        for (Map.Entry<User, List<Account>> entry : clients.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                list = entry.getValue();
            }
        }
        return list;
    }

    //метод для перечисления денег с одного счёта на другой счёт
    public boolean transferMoney (String srcPassport, String srcRequisite,
                                  String destPassport, String dstRequisite,
                                  double amount) {
        boolean result = false;
        Account srcAccount = null;
        Account dstAccount = null;

        for (Map.Entry<User, List<Account>> entry : clients.entrySet()) {
            if (entry.getKey().getPassport().equals(srcPassport) || entry.getKey().getPassport().equals(destPassport)) {
                for ( Account account : entry.getValue()) {
                    if (account.getRequisites().equals(srcRequisite)) {
                        srcAccount = account;
                    } else if ((account.getRequisites().equals(dstRequisite))) {
                        dstAccount = account;
                    }
                }
            }
        }
        if (srcAccount != null && dstAccount != null && srcAccount.getValue() > amount) {
            dstAccount.setValue(dstAccount.getValue() + amount);
            srcAccount.setValue(srcAccount.getValue() - amount);
            result = true;
        }
        return result;
    }

    public Map<User, List<Account>> getClients() {
        return clients;
    }
}

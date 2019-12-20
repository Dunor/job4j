package ru.job4j.transfers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BankTransfersTest {

    @Test
    public void addUser() {
        BankTransfers bankTransfers = new BankTransfers();
        User user = new User("Person1", "12345");
        bankTransfers.addUser(user);
        assertTrue(bankTransfers.getClients().containsKey(user));
    }

    @Test
    public void deleteUser() {
        BankTransfers bankTransfers = new BankTransfers();
        User user = new User("Person1", "12345");
        bankTransfers.addUser(user);
        bankTransfers.deleteUser(user);
        assertFalse(bankTransfers.getClients().containsKey(user));
    }

    @Test
    public void addAccountToUser() {
        BankTransfers bankTransfers = new BankTransfers();
        User user = new User("Person1", "12345");
        Account account = new Account(250, "aa222aa");
        bankTransfers.addUser(user);
        bankTransfers.addAccountToUser("12345", account);
        assertThat(bankTransfers.getClients().get(user).get(0), is(account));
    }

    @Test
    public void deleteAccountFromUser() {
        BankTransfers bankTransfers = new BankTransfers();
        User user = new User("Person1", "12345");
        Account account = new Account(250, "aa222aa");
        bankTransfers.addUser(user);
        bankTransfers.addAccountToUser("12345", account);
        bankTransfers.deleteAccountFromUser("12345", account);
        assertFalse(bankTransfers.getClients().get(user).contains(account));
    }

    @Test
    public void getUserAccounts() {
        BankTransfers bankTransfers = new BankTransfers();
        List<Account> accounts = new ArrayList<>();
        User user = new User("Person1", "12345");
        Account account1 = new Account(250, "aa222aa");
        Account account2 = new Account(1000, "bb123bb");
        bankTransfers.addUser(user);
        bankTransfers.addAccountToUser("12345", account1);
        bankTransfers.addAccountToUser("12345", account2);
        accounts.add(account1);
        accounts.add(account2);
        assertThat(bankTransfers.getUserAccounts("12345"), is(accounts));
    }

    @Test
    public void transferMoney() {
        BankTransfers bankTransfers = new BankTransfers();
        User user = new User("Person1", "12345");
        Account account1 = new Account(250, "aa222aa");
        Account account2 = new Account(1000, "bb123bb");
        bankTransfers.addUser(user);
        bankTransfers.addAccountToUser("12345", account1);
        bankTransfers.addAccountToUser("12345", account2);
        boolean rst = bankTransfers.transferMoney("12345", "aa222aa",
                "12345", "bb123bb", 200);
        System.out.println(rst);
        //assertTrue(bankTransfers.transferMoney("12345", "aa222aa",
         //       "12345", "bb123bb", 200));
    }


}
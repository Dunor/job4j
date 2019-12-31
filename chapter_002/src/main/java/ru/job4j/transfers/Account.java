package ru.job4j.transfers;

public class Account {
    private double value;
    private String requisite;

    public Account(double value, String requisite) {
        this.value = value;
        this.requisite = requisite;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getRequisites() {
        return requisite;
    }

    public void setRequisites(String requisite) {
        this.requisite = requisite;
    }

    public void transfer(Account account, double amount) {
        this.setValue(this.getValue() + amount);
        account.setValue(account.getValue() - amount);
    }
}

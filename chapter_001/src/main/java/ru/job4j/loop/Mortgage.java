package ru.job4j.loop;

public class Mortgage {
    public int year(int amount, int monthly, double percent) {
        int year = 1;
        double amountWithPercent = amount + amount * percent / 100; // сколько нужно заплатить за год с процентами
        int annualPayment = monthly * 12; // сколько заплачу за год
        while (amountWithPercent > annualPayment){
            amountWithPercent = (amountWithPercent - annualPayment) * percent / 100;
            year++;
        }
        return year;
    }
}

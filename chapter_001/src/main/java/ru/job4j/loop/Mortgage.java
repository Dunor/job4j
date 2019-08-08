package ru.job4j.loop;

/**
 * Ипотека.
 * @author - Максим К. (dunor@mail.ru)
 */
public class Mortgage {
    /**
     * Расчет количества лет для погашения кредита.
     * @param amount - сумма выданная по кредиту.
     * @param monthly - ежемесячный платеж.
     * @param percent- процентная ставка по кредиту.
     * @return - количество лет.
     */
    public int year(int amount, int monthly, double percent) {
        int year = 1;
        double amountWithPercent = amount + amount * percent / 100; // сколько нужно заплатить за год с процентами
        int annualPayment = monthly * 12; // сколько заплачу за год
        while (amountWithPercent > annualPayment) {
            amountWithPercent = (amountWithPercent - annualPayment) * percent / 100;
            year++;
        }
        return year;
    }
}

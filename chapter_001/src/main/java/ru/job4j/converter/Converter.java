package ru.job4j.converter;

/**
 * Конвертер валюты.
 * @author - Максим К. (dunor@mail.ru)
 */
public class Converter {
    /**
     * Конвертирует рубли в евро.
     * @param value - количество рублей.
     * @return - количество евро.
     */
    public static int rubleToEuro(int value) {
        return value / 70;
    }

    /**
     * Конвертирует рубли в долары.
     * @param value - количество рублей.
     * @return - количество долларов.
     */
    public static int rubleToDollar(int value) {
        return value / 60;
    }

    /**
     * Конвертирует евро в рубли.
     * @param value - количество евро.
     * @return - количество рублей.
     */
    public static int euroToRule(int value) {
        return value * 70;
    }

    /**
     * Конвертирует доллары в рубли.
     * @param value - количество долларов.
     * @return - количество рублей.
     */
    public static int dollarToRule(int value) {
        return value * 60;
    }

    /**
     * ввод и вывод данных
     * @param args - args.
     */
    public static void main(String[] args) {
        int euro = rubleToEuro(140);
        int dollar = rubleToDollar(140);
        int rubleEuro = euroToRule(140);
        int rubleDollar = dollarToRule(140);

        System.out.println("140 rubles are " + euro + " euro.");
        System.out.println("140 rubles are " + dollar + " dollars.");
        System.out.println("140 dollars are " + rubleDollar + " rubles.");
        System.out.println("140 euro are " + rubleEuro + " euro.");

    }
}

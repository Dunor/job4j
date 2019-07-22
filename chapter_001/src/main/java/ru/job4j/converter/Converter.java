package ru.job4j.converter;

public class Converter {

    public static int rubleToEuro(int value) {
        return value / 70;
    }

    public static int rubleToDollar(int value) {
        return value / 60;
    }

    public static int euroToRule(int value){
        return value * 70;
    }

    public static int dollarToRule(int value){
        return value * 60;
    }

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

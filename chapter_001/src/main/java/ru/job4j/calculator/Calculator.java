package ru.job4j.calculator;

/**
 * Элементарный калькулятор.
 * @author - Максим К. (dunor@mail.ru)
 */
public class Calculator {
    /**
     * Делат вычисления на калькуляторе.
     * @param args - args.
     */
    public static void main(String[] args) {
        add(1, 1);
        div(4, 2);
        multiply(2, 1);
        subtrack(10, 5);
    }

    /**
     * Сложение.
     * @param first - первое слагаемое.
     * @param second - второе слагаемое.
     */
    public static void add(double first, double second) {
        double result =  first + second;
        System.out.println(first + " + " + second + " = " + result);
    }

    /**
     * Деление.
     * @param first - делимое.
     * @param second - делитель.
     */
    public static void div(double first, double second) {
        double result =  first / second;
        System.out.println(first + " / " + second + " = " + result);
    }

    /**
     * Умножение.
     * @param first - первый множитель.
     * @param second - второй множитель.
     */
    public static void multiply(double first, double second) {
        double result =  first * second;
        System.out.println(first + " * " + second + " = " + result);
    }

    /**
     * Разность.
     * @param first - уменьшаемое.
     * @param second - вычитаемое.
     */

    public static void subtrack(double first, double second) {
        double result =  first - second;
        System.out.println(first + " - " + second + " = " + result);
    }

}
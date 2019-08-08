package ru.job4j.loop;

/**
 * Факториал.
 * @author - Максим К. (dunor@mail.ru)
 */
public class Factorial {
    /**
     *Вычисляет факториал числа n.
     * @param n - число, факториал которого нужно вычислить.
     * @return - вычисленный факториал.
     */
    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

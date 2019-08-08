package ru.job4j.condition;

/**
 * Максимум из двух чисел.
 * @author - Максим К. (dunor@mail.ru)
 */
public class Max {
    /**
     * Метод maax находит максимум из двух чисел.
     * @param left - первое число.
     * @param right - второе число.
     * @return - максимальное число.
     */
    public int max(int left, int right) {
        return left > right ? left : right;
    }
}

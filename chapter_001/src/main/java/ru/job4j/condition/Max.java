package ru.job4j.condition;

/**
 * Максимум из двух, трех или четырех чисел.
 * @author - Максим К. (dunor@mail.ru)
 */
public class Max {
    /**
     * Метод maax находит максимум из двух чисел.
     * @param first - первое число.
     * @param second - второе число.
     * @return - максимальное число.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
    /**
     * Метод maax находит максимум из двух чисел.
     * @param first - первое число.
     * @param second - второе число.
     * @param third - третье число.
     * @return - максимальное число.
     */
    public int max(int first, int second, int third) {
        return max(first, max(second, third));
    }
    /**
     * Метод maax находит максимум из двух чисел.
     * @param first - первое число.
     * @param second - второе число.
     * @param third - третье число.
     * @param fourth - четвертое число.
     * @return - максимальное число.
     */
    public int max(int first, int second, int third, int fourth) {
        return max(first, max(second, third, fourth));
    }

}

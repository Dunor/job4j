package ru.job4j.condition;

/**
 * Максимум из трех чисел.
 * @author - Максим К. (dunor@mail.ru)
 */
public class MultiMax {
    /**
     * Метод находит максимум из трех чисел.
     * @param first - первое число.
     * @param second - второе число.
     * @param third - третье число.
     * @return - максимальное число.
     */
    public int max(int first, int second, int third) {
        int result = first > second ? first : second;
        return result > third ? result : third;
    }
}

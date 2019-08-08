package ru.job4j.loop;

/**
 * Простые числа.
 * @author - Максим К. (dunor@mail.ru)
 */
public class PrimeNumber {
    /**
     * Расчитывает количество простых чисел от 1 до finish.
     * @param finish - число, до которого нужно производить расчет.
     * @return - количество простых чисел.
     */
    public int calc(int finish) {
        int count = 0;
        for (int i = 2; i <= finish; i++) {
            boolean prime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                count++;
            }
        }
        return count;
    }
}

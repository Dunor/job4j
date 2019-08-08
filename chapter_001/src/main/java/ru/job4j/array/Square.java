package ru.job4j.array;

/**
 * Заполнить массив степенями чисел.
 * @author - Максим К. (dunor@mail.ru)
 */
public class Square {
    /**
     * Метод заполняет массив числами, возведенными в квадрат.
     * @param bound - размер массива
     * @return - массив, заполненный числами, возведенными в квадрат.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i < bound; i++) {
            rst[i] = (int) Math.pow(i + 1, 2);
        }
        return rst;
    }
}

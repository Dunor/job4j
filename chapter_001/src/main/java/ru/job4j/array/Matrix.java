package ru.job4j.array;

/**
 * Двухмерный массив. Таблица умножения.
 * @author - Максим К. (dunor@mail.ru)
 */
public class Matrix {
    /**
     * Таблица умножения.
     * @param size - размер таблицы.
     * @return - матрица, заполненая, как таблица умноения.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}

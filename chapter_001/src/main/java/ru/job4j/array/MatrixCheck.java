package ru.job4j.array;

/**
 * Квадратный массив заполнен true или false по диагоналям.
 * @author - Максим К. (dunor@mail.ru)
 */
public class MatrixCheck {
    /**
     * Метод проверяет, что массив заполнен true или false по диагоналям.
     * @param data - массив для проверки.
     * @return - true - если массив заполнен rue или false по диагоналям, иначе false.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        boolean left = data[0][0];
        boolean right = data[0][data.length - 1];
        for (int i = 0, j = data.length - 1; i < data.length; i++, j--) {
                if ((data[i][i] != left) || (data[i][j] != right)) {
                    result = false;
                    break;
                }
        }
        return result;
    }
}

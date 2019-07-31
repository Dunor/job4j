package ru.job4j.array;

public class MatrixCheck {
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

package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        boolean lbl = data[0][0];
        for (int i = 0, j = data.length - 1; i < data.length; i++, j--) {
                if ((data[i][i] != lbl) || (data[i][j] != lbl)) {
                    result = false;
                    break;
                }
        }
        return result;
    }
}

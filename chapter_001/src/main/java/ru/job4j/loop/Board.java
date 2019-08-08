package ru.job4j.loop;

/**
 * Шахматная доска в псевдографике.
 * @author - Максим К. (dunor@mail.ru)
 */
public class Board {
    /**
     *
     * @param width - ширина доски.
     * @param height - высота доски.
     * @return - доска в псевдографике, ввиде объединенных строк.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.getProperty("line.separator");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}

package ru.job4j.condition;

/**
 * Стороны прямоугольника.
 * @author - Максим К. (dunor@mail.ru)
 */
public class SqArea {
    /**
     * вычислить площадь прямоугольника по заданным параметрам.
     * @param p - периметр прямоугольника.
     * @param k - коффициет.
     * @return - площадь прямоугольника
     */
    public static int square(int p, int k) {
        return (p / (2 * k + 2)) * (p / (2 * k + 2)) * k;
    }

    /**
     * Main.
     * @param args - args.
     */
    public static void main(String[] args) {
        int result1 = square(6, 2);
        System.out.println(" p = 6, k = 2, s = 2, real = " + result1);
    }
}

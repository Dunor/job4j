package ru.job4j.calculator;

/**
 * Идиальный вес.
 * @author - Максим К. (dunor@mail.ru)
 */
public class Fit {
    /**
     * Вычислет идиальный вес для мужчин.
     * @param height - рост мужчины.
     * @return - идиальный вес.
     */
    public static double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    /**
     * Вычислет идиальный вес для женщин.
     * @param height - рост женщины.
     * @return - идиальный вес.
     */
    public static double womanWeight(double height) {
        return (height - 110) * 1.15;
    }

    /**
     * Ввод и вывод данных.
     * @param args - args.
     */
    public static void main(String[] args) {
        double man = manWeight(182);
        double woman = womanWeight(168);
        System.out.println("Man 182 is " + man);
        System.out.println("Woman 168 is " + woman);
    }
}

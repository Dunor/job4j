package ru.job4j.condition;

import static java.lang.Math.*;

/**
 * Расстояние между точками в системе координат.
 * @author - Максим К. (dunor@mail.ru)
 */
public class Point {

    /**
     * Это поле объекта. Оно доступно только конкретному объекту.
     */
    private int x;

    /**
     * И это поле объекта. Оно доступно только конкретному объекту.
     */
    private int y;

    /**
     * Конструтор, который принимает начальное состояние объекта "точка"
     * @param first координата x
     * @param second координата y
     */
    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    /**
     * Вычисляет расстояние между двумя точками в системе координат.
     * @param that - переменная типа Point.
     * @return - Возвращает расстояние между тчками.
     */
    public double distance(Point that) {
        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2));
    }

    /**
     * Метод info() выводит значения полей x и y в консоль.
     */
    public void info() {
        System.out.println(String.format("Point[%s, %s]", this.x, this.y));
    }
}

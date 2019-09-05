package ru.job4j.pseudo;

/**
 * @author Maksim K. (dunor@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Main {
    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.draw(new Square());
        paint.draw(new Triangle());

    }
}

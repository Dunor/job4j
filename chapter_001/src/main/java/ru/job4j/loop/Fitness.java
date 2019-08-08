package ru.job4j.loop;

/**
 * Протеиновая диета.
 * @author - Максим К. (dunor@mail.ru)
 */
public class Fitness {
    /**
     * Расчитывает количество месяцев, необхоимых, что бы Иван догнал Николая.
     * @param ivan - вес, который тянет Иван.
     * @param nik - вес, который тянет Николай.
     * @return - количество месяцев.
     */
    public int calc(int ivan, int nik) {
        int month = 0;
        while (ivan < nik) {
            ivan *= 3;
            nik *= 2;
            month++;
        }
        return month;
    }
}

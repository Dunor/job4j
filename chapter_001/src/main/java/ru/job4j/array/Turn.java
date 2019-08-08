package ru.job4j.array;

/**
 * Перевернуть массив.
 * @author - Максим К. (dunor@mail.ru)
 */
public class Turn {
    /**
     * Метод переворачивает массив задом наперёд.
     * @param array - исходный массив.
     * @return - перевернутый массив.
     */
    public int[] back(int[] array) {
        int size = array.length - 1;
        int tmp;
        for (int index = 0; index <= size; index++, size--) {
            tmp = array[index];
            array[index] = array[size];
            array[size] = tmp;
        }
        return array;
    }
}

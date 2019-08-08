package ru.job4j.array;

/**
 * Проверяет, что все элементы в массиве являются true или false
 * @author - Максим К. (dunor@mail.ru)
 */
public class Check {
    /**
     *
     * @param data - проверяемый массив.
     * @return - true, если все элемнты true или false, иначе false.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
            for (int i = 0; i < data.length - 1; i++) {
                if (data[i] != data[i + 1]) {
                    result = false;
                    break;
                }
            }
        return result;
    }
}

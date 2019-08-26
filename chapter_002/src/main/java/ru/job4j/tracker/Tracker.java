package ru.job4j.tracker;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    /**
     *Метод заменяет элемент в массиве с идентификаторм id, на элемент item
     * @param id - идентификатор элемента, который необходимо заменить.
     * @param item - элемент, которым нужно заменить.
     * @return - true - если удалось заменить, иначе false.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                item.setId(id);
                items[i] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Находит элемент в массиве по id, и удаляет его.
     * @param id - идентификатор удаляемого элемента.
     * @return - true - если удалось удалить, иначе false.
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                System.arraycopy(items, i + 1, items, i, position - i + 1);
                position--;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Возвращает копию массива this.items без null элементов.
     * @return - массив без null элементов.
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * Ищет в массиве все элементы с именем key и сохраняет их в результирующий массив.
     * @param key - искомое имя элемента.
     * @return - массив с найдеными элементами.
     */
    public Item[] findByName(String key) {
        Item[] tmp = new Item[position];
        int j = 0;
        for (int i = 0; i < position; i++) {
            if (items[i].getName().equals(key)) {
                tmp[j++] = items[i];
            }
        }
        return Arrays.copyOf(tmp, j);
    }

    /**
     * Метод проверяет все элементы массива сравнивая id с аргументом String id
     * и возвращает найденный Item. Если Item не найден - возвращает null.
     * @param id - искомый идентификатор
     * @return - Item - если парметры совпали, иначе null.
     */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                result = items[i];
                break;
            }
        }
        return result;
    }
}

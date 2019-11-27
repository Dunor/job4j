package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final List<Item> items = new ArrayList<>();

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
        items.add(this.position++, item);
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
        for (Item itm : items) {
            if (itm.getId().equals(id)) {
                item.setId(id);
                items.set(items.indexOf(itm), item);
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
        for (Item itm : items) {
            if (itm.getId().equals(id)) {
                items.remove(itm);
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
    public List<Item> findAll() {
        return items;
    }

    /**
     * Ищет в массиве все элементы с именем key и сохраняет их в результирующий массив.
     * @param key - искомое имя элемента.
     * @return - массив с найдеными элементами.
     */
    public List<Item> findByName(String key) {
        List<Item> tmp = new ArrayList<>();
        for (Item itm : items) {
            if (itm.getName().equals(key)) {
                tmp.add(itm);
            }
        }
        return tmp;
    }

    /**
     * Метод проверяет все элементы массива сравнивая id с аргументом String id
     * и возвращает найденный Item. Если Item не найден - возвращает null.
     * @param id - искомый идентификатор
     * @return - Item - если парметры совпали, иначе null.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item itm : items) {
            if (itm.getId().equals(id)) {
                result = itm;
                break;
            }
        }
        return result;
    }
}

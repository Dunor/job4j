package ru.job4j.array;

public class FindLoop {
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    public int indexOf(int[] data, int el, int start, int finish) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = start; index <= finish ; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    public int[] sort(int[] data) {
        int index = 0;
        int tmp;
        int minIndex;
        for (int i = 0; i < data.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = index; j < data.length; j++) {
                if (min > data[j]) {
                    min = data[j];
                }
            }
            tmp = data[index];
            minIndex = indexOf(data, min, index, data.length - 1);
            data[index] = data[minIndex];
            data[minIndex] = tmp;
            index++;
        }
        return data;
    }
}

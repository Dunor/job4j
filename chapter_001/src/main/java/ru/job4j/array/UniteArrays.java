package ru.job4j.array;

import java.util.Arrays;

public class UniteArrays {
    public int[] merge(int[] left, int[] right ) {
        int[] result = new int[left.length + right.length];
        int j = 0;
        int k = 0;
        for (int i = 0; i < result.length; ) {
            if (j < left.length && k < right.length) {
                if (left[j] <= right[k]) {
                    result[i] = left[j];
                    j++;
                } else {
                    result[i] = right[k];
                    k++;
                }
            } else {
                if (k < right.length){
                    result[i] = right[k];
                    k++;
                }
                if (j < left.length) {
                    result[i] = left[j];
                    j++;
                }
            }
            i++;
        }
        return result;
    }
}

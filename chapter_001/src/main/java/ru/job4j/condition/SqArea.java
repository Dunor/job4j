package ru.job4j.condition;

public class SqArea {

    public static int square(int p, int k) {
        return (p / (2 * k + 2)) * (p / (2 * k + 2)) * k;
    }

    public static void main(String[] args) {
        int result1 = square(4, 1);
        System.out.println(" p = 4, k = 1, s = 1, real = " + result1);
    }
}

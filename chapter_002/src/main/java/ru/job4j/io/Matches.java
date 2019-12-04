package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean run = true;
        int count = 11;
        boolean player = true;
        while (run) {
            System.out.println("Спичек на столе - " + count + "!");
            if (player) {
                System.out.println("Игрок 1 возьмите от 1 до 3 спичек:");
                player = false;
            } else {
                System.out.println("Игрок 2 возьмите от 1 до 3 спичек:");
                player = true;
            }
            int num = Integer.valueOf(input.nextLine());
            count -= num;
            if (count <= 0) {
                run = false;
                if (player) {
                    System.out.println("Игрок 2 победил!");
                } else {
                    System.out.println("Игрок 1 победил!");
                }
            }
        }
    }
}

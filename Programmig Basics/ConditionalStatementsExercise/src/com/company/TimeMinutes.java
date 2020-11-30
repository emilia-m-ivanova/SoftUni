package com.company;

import java.util.Scanner;

public class TimeMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());
        int hours15;
        int minutes15 = minutes + 15;
        if (minutes + 15 >= 60) {
            hours15 = hours + 1;
            minutes15 = minutes15 - 60;
        } else {
            hours15 = hours;
        }
        if (hours15 >= 24) {
            hours15 = 0 + (hours15 - 24);
        }
        if (minutes15 < 10) {
            System.out.printf("%d:0%d", hours15, minutes15);
        } else {
            System.out.printf("%d:%d", hours15, minutes15);
        }
    }
}


package com.company;

import java.util.Scanner;

public class ExcellentResult {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double score = Double.parseDouble(scanner.nextLine());
        if (score >= 5.5){
            System.out.println("Excellent!");
        }

    }
}

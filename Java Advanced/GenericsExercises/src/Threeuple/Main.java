package Threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input1 = scanner.nextLine().split("\\s+");
        String[] input2 = scanner.nextLine().split("\\s+");
        String[] input3 = scanner.nextLine().split("\\s+");
        Threeuple<String,String,String> tuple1 = new Threeuple<>(input1[0] + " " + input1[1],input1[2],input1[3]);
        Threeuple<String,Integer,Boolean> tuple2 = new Threeuple<>(input2[0], Integer.parseInt(input2[1]),input2[2].equals("drunk"));
        Threeuple<String,Double,String> tuple3 = new Threeuple<>(input3[0],Double.parseDouble(input3[1]),input3[2]);
        System.out.println(tuple1);
        System.out.println(tuple2);
        System.out.println(tuple3);
    }
}

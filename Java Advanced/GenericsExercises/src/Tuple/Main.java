package Tuple;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input1 = scanner.nextLine().split("\\s+");
        String[] input2 = scanner.nextLine().split("\\s+");
        String[] input3 = scanner.nextLine().split("\\s+");
        Tuple<String,String> tuple1 = new Tuple<>(input1[0] + " " + input1[1],input1[2]);
        Tuple<String,Integer> tuple2 = new Tuple<>(input2[0], Integer.parseInt(input2[1]));
        Tuple<String,Double> tuple3 = new Tuple<>(input3[0],Double.parseDouble(input3[1]));
        System.out.println(tuple1);
        System.out.println(tuple2);
        System.out.println(tuple3);
    }
}

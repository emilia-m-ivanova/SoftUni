package StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Stack stack = new Stack();
        while (!input.equals("END")) {
            if (input.equals("Pop")) {
                if (stack.pop() == null) {
                    System.out.println("No elements");
                }
            } else {
                Arrays.stream(input.split(",*\\s+"))
                        .skip(1)
                        .mapToInt(Integer::parseInt)
                        .forEach(stack::push);
            }
            input = scanner.nextLine();
        }
        stack.forEach(System.out::println);
        stack.forEach(System.out::println);
    }
}

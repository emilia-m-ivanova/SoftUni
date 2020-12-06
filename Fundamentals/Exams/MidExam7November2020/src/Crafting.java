import java.util.Scanner;

public class Crafting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split("\\|");
        String input = scanner.nextLine();
        while (!input.equals("Done")) {
            String[] command = input.split("\\s+");
            switch (command[0]) {
                case "Move":
                    switch (command[1]) {
                        case "Left":
                            if (Integer.parseInt(command[2]) - 1 >= 0 && Integer.parseInt(command[2]) - 1 < array.length) {
                                String temp = array[Integer.parseInt(command[2])];
                                array[Integer.parseInt(command[2])] = array[Integer.parseInt(command[2]) - 1];
                                array[Integer.parseInt(command[2]) - 1] = temp;
                            }
                            break;
                        case "Right":
                            if (Integer.parseInt(command[2]) + 1 >= 0 && Integer.parseInt(command[2]) + 1 < array.length) {
                                String temp = array[Integer.parseInt(command[2])];
                                array[Integer.parseInt(command[2])] = array[Integer.parseInt(command[2]) + 1];
                                array[Integer.parseInt(command[2]) + 1] = temp;
                            }
                            break;
                    }
                    break;
                case "Check":
                    switch (command[1]) {
                        case "Even":
                            for (int i = 0; i < array.length; i++) {
                                if (i % 2 == 0) {
                                    System.out.print(array[i] + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case "Odd":
                            for (int i = 0; i < array.length; i++) {
                                if (i % 2 != 0) {
                                    System.out.print(array[i] + " ");
                                }
                            }
                            System.out.println();
                            break;
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.print("You crafted " + String.join("", array) + "!");
    }
}

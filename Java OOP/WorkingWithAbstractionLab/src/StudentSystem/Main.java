package StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        String input = scanner.nextLine();
        while (!input.equals("Exit"))
        {
            String[] tokens = input.split(" ");
            studentSystem.ParseCommand(tokens);
            input = scanner.nextLine();
        }
    }
}
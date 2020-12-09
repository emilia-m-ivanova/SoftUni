import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder();
        ArrayDeque<String> stackOfCommands = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            switch (input[0]) {
                case "1":
                    stackOfCommands.push(String.valueOf(text));
                    text.append(input[1]);
                    break;
                case "2":
                    stackOfCommands.push(String.valueOf(text));
                    int count = Integer.parseInt(input[1]);
                    text.delete(text.length() - count, text.length());
                    break;
                case "3":
                    System.out.println(text.charAt(Integer.parseInt(input[1])-1));
                    break;
                case "4":
                    text.setLength(0);
                    text.append(stackOfCommands.pop());
                    break;
            }
        }
    }
}

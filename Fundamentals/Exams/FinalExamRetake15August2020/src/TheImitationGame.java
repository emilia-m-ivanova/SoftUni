import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        StringBuilder decrypted = new StringBuilder(message);
        String input = scanner.nextLine();
        while (!input.equals("Decode")) {
            String[] command = input.split("\\|");
            switch (command[0]) {
                case "Move":
                    int n = Integer.parseInt(command[1]);
                    String substring = decrypted.substring(0, n);
                    decrypted.delete(0, n);
                    decrypted.append(substring);
                    break;
                case "Insert":
                    int index = Integer.parseInt(command[1]);
                    String value = command[2];
                    decrypted.insert(index, value);
                    break;
                case "ChangeAll":
                    String oldString = command[1];
                    String newString = command[2];
                    while (decrypted.indexOf(oldString) != -1) {
                        decrypted.replace(decrypted.indexOf(oldString),
                                decrypted.indexOf(oldString) + oldString.length(),
                                newString);
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println("The decrypted message is: " + decrypted);
    }
}

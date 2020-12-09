import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();
        String currentURL = "";
        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (stack.isEmpty()) {
                    System.out.println("no previous URLs");
                } else {
                    currentURL = stack.peek();
                    System.out.println(stack.pop());
                }
            } else {
                if (!currentURL.equals("")) {
                    stack.push(currentURL);
                }
                System.out.println(input);
                currentURL = input;
            }
            input = scanner.nextLine();
        }
    }
}

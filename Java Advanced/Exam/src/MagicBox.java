import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBox = new ArrayDeque<>();
        ArrayDeque<Integer> secondBox = new ArrayDeque<>();

        //queue
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(firstBox::offer);

        //stack
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondBox::push);

        int value = 0;
        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {

            int sum = firstBox.peek() + secondBox.peek();

            if (sum % 2 == 0) {
                value += sum;
                firstBox.poll();
                secondBox.pop();
            } else {
                firstBox.offer(secondBox.pop());
            }

        }

        System.out.println(firstBox.isEmpty() ? "First magic box is empty." : "Second magic box is empty.");
        System.out.println(value>=90?"Wow, your prey was epic! Value: " + value: "Poor prey... Value: " + value);
    }
}

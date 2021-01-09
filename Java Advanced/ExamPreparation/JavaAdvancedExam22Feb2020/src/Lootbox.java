import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBox = new ArrayDeque<>();
        ArrayDeque<Integer> secondBox = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(firstBox::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondBox::push);

        int loot = 0;

        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {

            int sum = firstBox.peek() + secondBox.peek();
            if (sum % 2 == 0) {
                loot += sum;
                firstBox.poll();
                secondBox.pop();
            } else {
                firstBox.offer(secondBox.pop());
            }

        }

        System.out.println(firstBox.isEmpty() ? "First lootbox is empty"
                : "Second lootbox is empty");
        System.out.println((loot >= 100 ? "Your loot was epic! Value: "
                : "Your loot was poor... Value: ") + loot);
    }
}

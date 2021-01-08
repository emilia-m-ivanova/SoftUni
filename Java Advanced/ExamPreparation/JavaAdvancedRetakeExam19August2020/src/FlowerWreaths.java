import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        ArrayDeque<Integer> roses = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(lilies::push);
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(roses::offer);
        int wreaths = 0;
        int remainingFlowers = 0;
        while (!roses.isEmpty() && !lilies.isEmpty()) {
            int sum = roses.peek() + lilies.peek();
            while (sum > 15) {
                lilies.push(lilies.pop() - 2);
                sum = roses.peek() + lilies.peek();
            }
            if (sum < 15) {
                remainingFlowers += sum;
            } else {
                wreaths++;
            }
            roses.poll();
            lilies.pop();
        }
        while (remainingFlowers >=15){
            remainingFlowers-=15;
            wreaths++;
        }

        if (wreaths >= 5) {
            System.out.println("You made it, you are going to the competition with " + wreaths + " wreaths!");
        } else {
            System.out.println("You didn't make it, you need " + (5 - wreaths) + " wreaths more!");
        }
    }
}

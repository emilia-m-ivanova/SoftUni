import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> bombEffects = new ArrayDeque<>();
        ArrayDeque<Integer> bombCasing = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(bombEffects::offer);
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(bombCasing::push);
        int datura = 0;
        int cherry = 0;
        int smoke = 0;

        while ((!bombEffects.isEmpty() && !bombCasing.isEmpty()) &&
                (datura < 3 || cherry < 3 || smoke < 3)) {
            int sum = bombEffects.peek() + bombCasing.peek();
            while (sum >= 40) {
                if (sum == 120) {
                    smoke++;
                    break;
                } else if (sum == 60) {
                    cherry++;
                    break;
                } else if (sum == 40) {
                    datura++;
                    break;
                }
                bombCasing.push(bombCasing.pop() - 5);
                sum = bombEffects.peek() + bombCasing.peek();
            }
            bombEffects.poll();
            bombCasing.pop();
        }
        if (datura >= 3 && cherry >= 3 && smoke >= 3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        System.out.print("Bomb Effects: ");
        printArrayDeque(bombEffects);
        System.out.print("Bomb Casings: ");
        printArrayDeque(bombCasing);
        System.out.printf("Cherry Bombs: %d%nDatura Bombs: %d%nSmoke Decoy Bombs: %d%n",cherry,datura,smoke);
    }

    private static void printArrayDeque(ArrayDeque<Integer> arrayDeque) {
        if (arrayDeque.isEmpty()) {
            System.out.println("empty");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Integer element : arrayDeque) {
            sb.append(element).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb);
    }
}

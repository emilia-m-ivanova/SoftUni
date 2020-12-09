import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String [] input = scanner.nextLine().split(" ");
            switch(input[0]){
                case "1":
                    int number = Integer.parseInt(input[1]);
                    stack.push(number);
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    System.out.println(stack.stream().max(Comparator.naturalOrder()).get());
                    break;
            }
        }
    }
}

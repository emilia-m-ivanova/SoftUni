import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            stack.offer(scanner.nextInt());
        }
        for (int i = 0; i < s; i++) {
            stack.poll();
        }
        if(stack.contains(x)){
            System.out.println("true");
        }else if(stack.isEmpty()){
            System.out.println(0);
        }else{
            System.out.println(stack.stream().min(Comparator.naturalOrder()).get());
        }

    }
}

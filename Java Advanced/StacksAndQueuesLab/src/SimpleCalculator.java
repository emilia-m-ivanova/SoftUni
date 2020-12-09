import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] input = scanner.nextLine().split(" ");
        ArrayDeque <String> stack = new ArrayDeque<>();
        stack.addAll(Arrays.asList(input));
        while(stack.size()>1){
            int firstNum = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secondNum = Integer.parseInt(stack.pop());
            switch (operator){
                case "+":
                    stack.push(String.valueOf(firstNum+secondNum));
                    break;
                case "-":
                    stack.push(String.valueOf(firstNum-secondNum));
                    break;
            }
        }
        System.out.println(stack.pop());
    }
}

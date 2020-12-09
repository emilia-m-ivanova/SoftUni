import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i)=='('){
                stack.push(i);
            }else if(input.charAt(i)==')'){
                int start = stack.pop();
                int end = i+1;
                System.out.println(input.substring(start,end));
            }
        }
    }
}

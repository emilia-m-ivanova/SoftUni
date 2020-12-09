import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.length() % 2 == 1) {
            System.out.println("NO");
            return;
        }
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean isBalanced = true;
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i)=='['||input.charAt(i)=='('||input.charAt(i)=='{'){
                stack.push(input.charAt(i));
            }else{
                if(stack.isEmpty()){
                    isBalanced=false;
                    break;
                }
                char lastParentheses = stack.pop();
                switch (lastParentheses){
                    case '[':
                        if (input.charAt(i)!=']'){
                            isBalanced = false;
                        }
                        break;
                    case '{':
                        if (input.charAt(i)!='}'){
                            isBalanced = false;
                        }
                        break;
                    case '(':
                        if (input.charAt(i)!=')'){
                            isBalanced = false;
                        }
                        break;
                }
            }
            if(!isBalanced){
                break;
            }
        }
        if(isBalanced&&stack.isEmpty()){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}

import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String brackets = "";
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            if(input.equals("(")||input.equals(")")){
                brackets+=input;
            }
            if (brackets.equals("()")){
                brackets="";
            }
        }
        if (brackets.equals("")) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}


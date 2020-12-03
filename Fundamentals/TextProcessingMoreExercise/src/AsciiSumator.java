import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);
        String input = scanner.nextLine();
        int sum = 0;
        for (char c: input.toCharArray()) {
            if(firstChar<c&&c<secondChar){
                sum+=c;
            }
        }
        System.out.println(sum);
    }
}

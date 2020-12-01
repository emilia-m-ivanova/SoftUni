import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        String message = "";
        for (int i = 1; i <= count; i++) {
            int mainDigit = Integer.parseInt(String.valueOf(input.charAt(input.length() - 1)));
            int offset = (mainDigit - 2) * 3;
            if (mainDigit == 8 || mainDigit == 9) {
                offset += 1;
            }else if(mainDigit==0){
                offset=-65;
            }
            int index = offset + input.length() - 1;
            char letter = (char) (index + 97);
            message+=letter;
            if(i==count){
                break;
            }
            input = scanner.nextLine();
        }
        System.out.println(message);
    }
}

import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String bigNumber = scanner.nextLine();
        int num = Integer.parseInt(scanner.nextLine());
        int startIndex = 0;
        for (int i = 0; i < bigNumber.length(); i++) {
            if(bigNumber.charAt(i)!='0'){
                startIndex = i;
                break;
            }
        }
        System.out.println(multiplyNumbers(bigNumber.substring(startIndex), num));
    }

    private static StringBuilder multiplyNumbers(String bigNumber, int num) {
        StringBuilder sb = new StringBuilder();
        if (num == 0) {
            return sb.append(0);
        }
        int remain = 0;
        for (int i = bigNumber.length() - 1; i >= 0; i--) {
            char character = bigNumber.charAt(i);
            int n = Integer.parseInt(String.valueOf(character));
            int result = n * num + remain;
                if (result > 9) {
                    sb.insert(0, result % 10);
                    remain = result / 10;
                } else {
                    sb.insert(0, result);
                    remain = 0;
                }
        }
        if (remain != 0) {
            sb.insert(0, remain);
        }
        return sb;
    }
}

import java.util.Scanner;

public class Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] integerArray = scanner.nextLine().split(" ");
        String string = scanner.nextLine();
        String output = "";
        for (String element : integerArray) {
            int sum = 0;
            for (int i = 0; i < element.length(); i++) {
                int digit = Integer.parseInt(String.valueOf(element.charAt(i)));
                sum+=digit;
            }
            if(sum>string.length()-1){
                sum-=string.length();
            }
            output+=String.valueOf(string.charAt(sum));
            String newString = "";
            for (int i = 0; i < string.length(); i++) {
                if(i!=sum){
                    newString+=String.valueOf(string.charAt(i));
                }
            }
            string=newString;
        }
        System.out.println(output);
    }
}

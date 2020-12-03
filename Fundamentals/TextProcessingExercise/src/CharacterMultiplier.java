import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string1 = scanner.next();
        String string2 = scanner.next();
        int sum = multiplyChars(string1,string2);
        System.out.println(sum);
    }

    private static int multiplyChars(String string1, String string2) {
        int sum = 0;
        if(string1.length()>string2.length()){
            for (int i = 0; i < string2.length(); i++) {
                sum+=string1.charAt(i)*string2.charAt(i);
            }
            for (int i = string2.length(); i < string1.length(); i++) {
                sum+=string1.charAt(i);
            }
        }else{
            for (int i = 0; i < string1.length(); i++) {
                sum+=string1.charAt(i)*string2.charAt(i);
            }
            for (int i = string1.length(); i < string2.length(); i++) {
                sum+=string2.charAt(i);
            }
        }
        return sum;
    }
}

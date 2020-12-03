import java.util.Scanner;

public class DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder letters = new StringBuilder();
        StringBuilder numbers = new StringBuilder();
        StringBuilder other = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if(Character.isLetter(current)){
               letters.append(current);
            } else if(Character.isDigit(current)){
               numbers.append(current);
            }else{
               other.append(current);
            }
        }
        System.out.println(numbers);
        System.out.println(letters);
        System.out.println(other);
    }
}

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        printMiddleCharacter(input);
    }

    private static void printMiddleCharacter(String input) {
        if(input.length()%2==1){
            System.out.println(input.charAt(input.length()/2));
        }else{
            System.out.printf("%c%c",input.charAt((input.length()/2)-1),input.charAt(input.length()/2));
        }
    }
}

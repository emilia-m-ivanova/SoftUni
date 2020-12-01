import java.util.Scanner;

public class TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (char i = 0; i < n; i++) {
            for (char j = 0; j < n; j++) {
                for (char k = 0; k < n; k++) {
                    System.out.printf("%c%c%c%n",i+97,j+97,k+97);
                }
                
            }
        }
    }
}

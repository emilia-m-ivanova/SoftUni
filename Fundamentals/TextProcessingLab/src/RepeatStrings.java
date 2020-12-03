import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        for (int i = 0; i < array.length; i++) {
            String current = array[i];
            for (int j = 1; j < current.length(); j++) {
                array[i]=array[i].concat(current);
            }
        }
        System.out.println(String.join("",array));
    }
}

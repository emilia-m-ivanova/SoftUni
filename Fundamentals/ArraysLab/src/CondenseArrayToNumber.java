import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] arrayAsString = input.split(" ");
        int [] array = new int[arrayAsString.length];
        for (int i = 0; i < array.length; i++) {
            array[i]=Integer.parseInt(arrayAsString[i]);
        }
        int currentLength = array.length;
        while (currentLength>1){
            for (int i = 0; i < currentLength-1; i++) {
                array[i]=array[i]+array[i+1];
            }
            currentLength--;
        }
        System.out.println(array[0]);
    }
}

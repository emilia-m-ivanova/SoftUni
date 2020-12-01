import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] arrayAsString = line.split(" ");
        int[] array = new int[arrayAsString.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(arrayAsString[i]);
        }
        for (int i = 0; i < array.length; i++) {
            int sumLeft = 0;
            int sumRight = 0;
            for (int j = i+1; j < array.length ; j++) {
                sumRight+=array[j];
            }
            for (int j = i-1; j >= 0; j--) {
                sumLeft+=array[j];
            }
            if(sumLeft==sumRight){
                System.out.println(i);
                return;
            }
        }
        System.out.println("no");
    }
}

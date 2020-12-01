import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(element->Integer.parseInt(element)).toArray();
        int [] longest = new int[array.length];
        int counterLongest = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(array[j]>array[i]){

                }
            }
        }

        for (int element:longest) {
            System.out.print(element+" ");
        }
    }
}

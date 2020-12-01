import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String [] numbersAsString = input.split(" ");
        int [] array = new int[numbersAsString.length];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            array[i]=Integer.parseInt(numbersAsString[i]);
            if(array[i]%2==0){
                sum+=array[i];
            }
        }
        System.out.println(sum);
    }
}

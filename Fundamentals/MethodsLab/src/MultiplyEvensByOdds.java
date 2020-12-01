import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Math.abs(Integer.parseInt(scanner.nextLine()));
        int output = getMultipleOfEvensAndOdds(number);
        System.out.println(output);
    }

    private static int getMultipleOfEvensAndOdds(int number) {
        int sumEven = getSumEven(number);
        int sumOdd = getSumOdd(number);
        return sumEven * sumOdd;
    }

    private static int getSumOdd(int number) {
        int sum = 0;
        while (number > 0) {
            if (number % 2 == 1) {
                sum += number % 10;
            }
            number /= 10;
        }
        return sum;
    }

    private static int getSumEven(int number) {
        int sum = 0;
        while (number > 0) {
            if (number % 2 == 0) {
                sum += number % 10;
            }
            number /= 10;
        }
        return sum;
    }
}

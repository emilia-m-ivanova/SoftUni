import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        double highestValue = 0;
        String output = "";
        for (int i = 0; i < n; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());
            double snowballValue = Math.pow(((double) snowballSnow/snowballTime),snowballQuality);
            if(snowballValue>highestValue){
                highestValue=snowballValue;
                output=String.format("%d : %d = %.0f (%d)",snowballSnow,snowballTime,snowballValue,snowballQuality);
            }
        }
        System.out.println(output);
    }
}

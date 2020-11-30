import java.util.Scanner;

public class MountainRun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double recordSec = Double.parseDouble(scanner.nextLine());
        double distanceMeters = Double.parseDouble(scanner.nextLine());
        double timeInSec1m = Double.parseDouble(scanner.nextLine());
        double secondsSlow = (Math.floor(distanceMeters/50))*30;
        double result = distanceMeters*timeInSec1m+secondsSlow;
        double diff = Math.abs(result-recordSec);

        if(result<recordSec){
            System.out.printf("Yes! The new record is %.2f seconds.",result);
        }else{
            System.out.printf("No! He was %.2f seconds slower.",diff);
        }
    }
}

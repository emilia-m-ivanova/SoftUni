import java.util.Scanner;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] numbersAsStrings = scanner.nextLine().split("@");
        int [] arrayOfNumbers = new int[numbersAsStrings.length];
        for (int i = 0; i < numbersAsStrings.length; i++) {
            arrayOfNumbers[i] = Integer.parseInt(numbersAsStrings[i]);
        }
        String input = scanner.nextLine();
        int currentPosition = 0;
        while (!input.equals("Love!")){
            String [] command = input.split(" ");
            int length = Integer.parseInt(command[1]);
            currentPosition+=length;
            if(currentPosition> arrayOfNumbers.length-1){
                currentPosition=0;
            }
            if(arrayOfNumbers[currentPosition]>0){
                arrayOfNumbers[currentPosition]-=2;
                if(arrayOfNumbers[currentPosition]==0){
                    System.out.printf("Place %d has Valentine's day.%n",currentPosition);
                }
            }else{
                System.out.printf("Place %d already had Valentine's day.%n",currentPosition);
            }

            input = scanner.nextLine();
        }
        System.out.printf("Cupid's last position was %d.%n",currentPosition);
        int failed = 0;
        for (int element : arrayOfNumbers) {
            if(element!=0){
                failed++;
            }
        }
        if(failed>0){
            System.out.printf("Cupid has failed %d places.",failed);
        }else{
            System.out.print("Mission was successful.");
        }

    }
}

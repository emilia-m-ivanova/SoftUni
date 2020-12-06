import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleWaiting = Integer.parseInt(scanner.nextLine());
        String[] integerAsString = scanner.nextLine().split("\\s+");
        int[] wagons = new int[integerAsString.length];
        for (int i = 0; i < wagons.length; i++) {
            wagons[i] = Integer.parseInt(integerAsString[i]);
        }
        int index = 0;
        while (peopleWaiting != 0) {
            if (index < wagons.length) {
                while (wagons[index] < 4 && peopleWaiting != 0) {
                    wagons[index]++;
                    peopleWaiting--;
                }
                index++;
            } else {
                break;
            }
        }
        int emptySpots = 0;
        for (int wagon : wagons) {
            if(wagon<4){
                emptySpots++;
            }
        }

        if (peopleWaiting != 0) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", peopleWaiting);
        } else if(emptySpots!=0){
            System.out.println("The lift has empty spots!");
        }
        for (int wagon : wagons) {
            System.out.print(wagon + " ");
        }

    }
}

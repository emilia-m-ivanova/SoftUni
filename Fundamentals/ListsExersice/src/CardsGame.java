import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstPlayer = readList(scanner);
        List<Integer> secondPlayer = readList(scanner);
        while (!firstPlayer.isEmpty() && !secondPlayer.isEmpty()) {
            if (firstPlayer.get(0) > secondPlayer.get(0)) {
                firstPlayer.add(firstPlayer.get(0));
                firstPlayer.add(secondPlayer.get(0));
            } else if (secondPlayer.get(0) > firstPlayer.get(0)) {
                secondPlayer.add(secondPlayer.get(0));
                secondPlayer.add(firstPlayer.get(0));
            }
            firstPlayer.remove(0);
            secondPlayer.remove(0);
        }
            int sum = 0;
        if(!firstPlayer.isEmpty()){
            for (Integer element : firstPlayer) {
                sum+=element;
            }
            System.out.printf("First player wins! Sum: %d",sum);
        }else{
            for (Integer element : secondPlayer) {
                sum+=element;
            }
            System.out.printf("Second player wins! Sum: %d",sum);
        }
    }

    private static List<Integer> readList(Scanner scanner) {
        String[] numbersAsString = scanner.nextLine().split(" ");
        List<Integer> integerList = new ArrayList<>();
        for (String element : numbersAsString) {
            integerList.add(Integer.parseInt(element));
        }
        return integerList;
    }
}

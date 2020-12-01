import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double money = Double.parseDouble(scanner.nextLine());
        List<Integer> drumInitialQuality = readList(scanner);
        List<Integer> drumCurrentQuality = new ArrayList<>();
        for (Integer integer : drumInitialQuality) {
            drumCurrentQuality.add(integer);
        }

        String input = scanner.nextLine();
        while (!input.equals("Hit it again, Gabsy!")) {
            int hitPower = Integer.parseInt(input);
            for (int i = 0; i < drumCurrentQuality.size(); i++) {
                int element = drumCurrentQuality.get(i);
                drumCurrentQuality.set(i, element - hitPower);
                int initialQuality = drumInitialQuality.get(i);
                if (hitPower >= element && element > 0) {
                    if ((money - initialQuality * 3) >= 0) {
                        money -= initialQuality * 3;
                        drumCurrentQuality.set(i, initialQuality);
                    } else {
                        drumCurrentQuality.set(i, 0);
                    }
                }
            }
            input = scanner.nextLine();
        }
        for (Integer integer : drumCurrentQuality) {
            if (integer > 0) {
                System.out.print(integer + " ");
            }
        }
        System.out.printf("%nGabsy has %.2flv.", money);

    }

    private static List<Integer> readList(Scanner scanner) {
        String[] arrayAsString = scanner.nextLine().split(" ");
        List<Integer> integerList = new ArrayList<>();
        for (String s : arrayAsString) {
            integerList.add(Integer.parseInt(s));
        }
        return integerList;
    }
}

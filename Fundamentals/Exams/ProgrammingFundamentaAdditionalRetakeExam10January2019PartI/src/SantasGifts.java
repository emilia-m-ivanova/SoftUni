import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SantasGifts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split("\\s+");
        List<String> houses = new ArrayList<>(Arrays.asList(input));
        int position = 0;
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(" ");
            switch (command[0]) {
                case "Forward":
                    if (position + Integer.parseInt(command[1]) >= 0
                            && position + Integer.parseInt(command[1]) < houses.size()) {
                        position += Integer.parseInt(command[1]);
                        houses.remove(position);
                    }
                    break;
                case "Back":
                    if (position - Integer.parseInt(command[1]) >= 0
                            && position - Integer.parseInt(command[1]) < houses.size()) {
                        position -= Integer.parseInt(command[1]);
                        houses.remove(position);
                    }
                    break;
                case "Gift":
                    if (Integer.parseInt(command[1]) >= 0 && Integer.parseInt(command[1]) < houses.size()) {
                        houses.add(Integer.parseInt(command[1]), command[2]);
                        position = Integer.parseInt(command[1]);
                    }
                    break;
                case "Swap":
                    int firstIndex = houses.indexOf(command[1]);
                    int secondIndex = houses.indexOf(command[2]);
                    if (firstIndex >= 0 && firstIndex < houses.size()
                            && secondIndex >= 0 && secondIndex < houses.size()) {
                        houses.set(firstIndex, command[2]);
                        houses.set(secondIndex, command[1]);
                    }
                    break;
            }
        }
        System.out.println("Position: " + position);
        System.out.println(String.join(", ", houses));

    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> targetList = readList(scanner);
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] command = input.split(" ");
            int index = Integer.parseInt(command[1]);
            int value = Integer.parseInt(command[2]);
            switch (command[0]) {
                case "Shoot":
                    if (0 <= index && index < targetList.size()) {
                        targetList.set(index, targetList.get(index) - value);
                        if (targetList.get(index) <= 0) {
                            targetList.remove(index);
                        }
                    }
                    break;
                case "Add":
                    if (0 <= index && index < targetList.size()) {
                        targetList.add(index, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }

                    break;
                case "Strike":
                    int startIndex = index - value;
                    int endIndex = index + value;
                    if (startIndex >= 0 && endIndex < targetList.size()) {
                        for (int i = 0; i < value * 2 + 1; i++) {
                            targetList.remove(startIndex);
                        }
                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println(listToString("|", targetList));
    }

    private static String listToString(String regex, List<Integer> integerList) {
        String output = "";
        for (int i = 0; i < integerList.size(); i++) {
            if (i != integerList.size() - 1) {
                output += integerList.get(i) + regex;
            }else{
                output+= integerList.get(i);
            }
        }
        return output;
    }

    private static List<Integer> readList(Scanner scanner) {
        String[] integersAsString = scanner.nextLine().split(" ");
        List<Integer> integerList = new ArrayList<>();
        for (String element : integersAsString) {
            integerList.add(Integer.parseInt(element));
        }
        return integerList;
    }
}

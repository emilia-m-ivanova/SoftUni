import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> stringList = readList(scanner);
        String input = scanner.nextLine();
        while (!input.equals("Craft!")){
            String[]command = input.split(" - ");
            switch (command[0]){
                case "Collect":
                    if(!stringList.contains(command[1])){
                        stringList.add(command[1]);
                    }
                    break;
                case "Drop":
                    stringList.remove(command[1]);
                    break;
                case "Combine Items":
                    String[]items = command[1].split(":");
                    for (int i = 0; i < stringList.size(); i++) {
                        String element = stringList.get(i);
                        if(element.equals(items[0])){
                            stringList.add(i+1,items[1]);
                            break;
                        }
                    }
                    break;
                case "Renew":
                    if(stringList.contains(command[1])){
                        stringList.remove(command[1]);
                        stringList.add(command[1]);
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println(String.join(", ",stringList));
    }

    private static List<String> readList(Scanner scanner) {
        String[] array = scanner.nextLine().split(", ");
        List<String> stringList = new ArrayList<>();
        for (String s : array) {
            stringList.add(s);
        }
        return stringList;
    }
}

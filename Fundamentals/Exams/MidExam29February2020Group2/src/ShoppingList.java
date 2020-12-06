import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List <String> shoppingList = readList(scanner);
        String input = scanner.nextLine();
        while (!input.equals("Go Shopping!")){
            String [] command = input.split("\\s+");
            switch (command[0]){
                case "Urgent":
                    if(!shoppingList.contains(command[1])){
                        shoppingList.add(0,command[1]);
                    }
                    break;
                case "Unnecessary":
                    shoppingList.remove(command[1]);
                    break;
                case "Correct":
                    if(shoppingList.contains(command[1])){
                        shoppingList.set(shoppingList.indexOf(command[1]),command[2]);
                    }
                    break;
                case "Rearrange":
                    if(shoppingList.contains(command[1])){
                        shoppingList.remove(command[1]);
                        shoppingList.add(command[1]);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.print(String.join(", ",shoppingList));
    }

    private static List<String> readList(Scanner scanner) {
        String [] arrayOfStrings = scanner.nextLine().split("!");
        List <String> listOfStrings = new ArrayList<>();
        for (String element : arrayOfStrings) {
            listOfStrings.add(element);
        }
        return listOfStrings;
    }
}

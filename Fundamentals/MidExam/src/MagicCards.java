import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MagicCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] array = scanner.nextLine().split(":");
        List<String> cards = new ArrayList<>();
        for (String s : array) {
            cards.add(s);
        }
        List <String> deck = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("Ready")){
            String [] command = input.split(" ");
            String cardName = command[1];
            switch (command[0]){
                case "Add":
                    if(cards.contains(cardName)){
                        deck.add(cardName);
                    }else{
                        System.out.println("Card not found.");
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(command[2]);
                    if(0<=index&&index<deck.size()&&cards.contains(cardName)){
                        deck.add(index,cardName);
                    }else{
                        System.out.println("Error!");
                    }
                    break;
                case "Remove":
                    if(deck.contains(cardName)){
                        deck.remove(cardName);
                    }else{
                        System.out.println("Card not found.");
                    }
                    break;
                case "Swap":
                    String card2 = command[2];
                    int index2 = deck.indexOf(card2);
                    int index1 = deck.indexOf(cardName);
                    deck.set(index1,card2);
                    deck.set(index2,cardName);
                    break;
                case "Shuffle":
                    Collections.reverse(deck);
                    break;
            }
            input = scanner.nextLine();
        }
        for (String element : deck) {
            System.out.print(element+" ");
        }

    }
}

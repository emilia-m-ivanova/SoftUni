import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EasterGifts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> gifts = new ArrayList<>();
        String [] array = scanner.nextLine().split(" ");
        for (String element : array) {
            gifts.add(element);
        }
        String input = scanner.nextLine();
        while (!input.equals("No Money")){
            String [] command = input.split(" ");
            String gift = command[1];
            switch (command[0]){
                case "OutOfStock":
                    while (gifts.contains(gift)){
                        gifts.set(gifts.indexOf(gift),"None");
                    }
                    break;
                case "Required":
                    int index = Integer.parseInt(command[2]);
                    if(0<=index&&index<gifts.size()){
                        gifts.set(index,gift);
                    }
                    break;
                case "JustInCase":
                    gifts.set(gifts.size()-1,gift);
                    break;
            }
            input = scanner.nextLine();
        }
        for (String gift : gifts) {
            if(!gift.equals("None")){
                System.out.print(gift+" ");
            }
        }

    }
}

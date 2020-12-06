import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> elements = new ArrayList<>();
        String[] array = scanner.nextLine().split("\\s+");
        for (String s : array) {
            elements.add(s);
        }
        String input = scanner.nextLine();
        int moves = 0;
        while (!input.equals("end")) {
            String[] indexes = input.split(" ");
            int index1 = Integer.parseInt(indexes[0]);
            int index2 = Integer.parseInt(indexes[1]);
            moves++;
            if (index1 == index2 || 0 > index1 || index1 > elements.size()
            || 0>index2 || index2 >= elements.size()){
                System.out.printf("Invalid input! Adding additional elements to the board%n");
                elements.add(elements.size()/2,"-"+moves+"a");
                elements.add(elements.size()/2,"-"+moves+"a");
            }else{
                if(elements.get(index1).equals(elements.get(index2))){
                    System.out.printf("Congrats! You have found matching elements - %s!%n",elements.get(index1));
                    if(index1>index2){
                        elements.remove(index1);
                        elements.remove(index2);
                    }else {
                        elements.remove(index2);
                        elements.remove(index1);
                    }
                }else{
                    System.out.println("Try again!");
                }
            }
            if(elements.isEmpty()){
                System.out.printf("You have won in %d turns!",moves);
                return;
            }
                input = scanner.nextLine();
        }
        System.out.println("Sorry you lose :(");
        for (String element : elements) {
            System.out.print(element + " ");
        }

    }
}

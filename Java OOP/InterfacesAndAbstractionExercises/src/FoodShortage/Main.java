package FoodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Buyer> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            if(tokens.length==3){
                people.add(new Rebel(tokens[0],Integer.parseInt(tokens[1]),tokens[2]));
            }else{
                people.add(new Citizen(tokens[0],Integer.parseInt(tokens[1]),tokens[2],tokens[3]));
            }
        }

        String name = scanner.nextLine();
        while (!name.equals("End")){
            String finalName = name;
            people.stream()
                    .filter(e->e.getName().equals(finalName))
                    .forEach(Buyer::buyFood);
            name = scanner.nextLine();
        }
        System.out.println(people.stream()
                .mapToInt(Buyer::getFood)
                .sum());
    }
}

package BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Birthable> list = new ArrayList<>();
        while (!input.equals("End")){
            String[] tokens = input.split("\\s+");
            switch (tokens[0]){
                case "Citizen":
                    list.add(new Citizen(tokens[1],Integer.parseInt(tokens[2]),tokens[3],tokens[4]));
                    break;
                case "Pet":
                    list.add(new Pet(tokens[1],tokens[2]));
                    break;
            }
            input = scanner.nextLine();
        }
        String birthDayToSearch = scanner.nextLine();
        list.removeIf(e->!e.getBirthDate().endsWith(birthDayToSearch));
        list.forEach(e-> System.out.println(e.getBirthDate()));
    }
}

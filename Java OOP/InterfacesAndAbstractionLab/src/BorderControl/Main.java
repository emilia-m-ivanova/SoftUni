package BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Identifiable> peopleAndRobots = new ArrayList<>();
        while (!input.equals("End")){
            String[] tokens = input.split("\\s+");
            if(tokens.length==3){
                peopleAndRobots.add(new Citizen(tokens[0],Integer.parseInt(tokens[1]),tokens[2]));
            }else{
                peopleAndRobots.add(new Robot(tokens[0],tokens[1]));
            }
            input = scanner.nextLine();
        }
        String idSuffixToFind = scanner.nextLine();

        peopleAndRobots.stream()
                .filter(e->e.getId().endsWith(idSuffixToFind))
                .forEach(e-> System.out.println(e.getId()));
    }
}

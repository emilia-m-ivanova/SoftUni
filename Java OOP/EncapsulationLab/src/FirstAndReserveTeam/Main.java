package FirstAndReserveTeam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Team team = new Team("Beroe");
        List<Person> players = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            players.add(new Person(input[0],input[1],Integer.parseInt(input[2]),Double.parseDouble(input[3])));
        }

        for (Person player : players) {
            team.addPlayer(player);
        }

        System.out.println("First team has " + team.getFirstTeam().size() + " players");
        System.out.println("Reserve team has " + team.getReserveTeam().size() + " players");

    }
}

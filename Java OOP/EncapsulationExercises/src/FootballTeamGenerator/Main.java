package FootballTeamGenerator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Team> teams = new LinkedHashMap<>();

        while (!input.equals("END")) {
            String[] tokens = input.split(";");
            input = scanner.nextLine();
            try {
                switch (tokens[0]) {
                    case "Team":
                        teams.put(tokens[1], new Team(tokens[1]));
                        break;
                    case "Add":
                        addPlayer(teams, tokens);
                        break;
                    case "Remove":
                        String team = tokens[1];
                        String player = tokens[2];
                        teams.get(team).removePlayer(player);
                        break;
                    case "Rating":
                        String teamName = tokens[1];
                        if (!teams.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        } else {
                            System.out.println(teams.get(teamName).toString());
                        }
                        break;
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void addPlayer(Map<String, Team> teams, String[] tokens) {
        String teamName = tokens[1];
        String player = tokens[2];
        int stat1 = Integer.parseInt(tokens[3]);
        int stat2 = Integer.parseInt(tokens[4]);
        int stat3 = Integer.parseInt(tokens[5]);
        int stat4 = Integer.parseInt(tokens[6]);
        int stat5 = Integer.parseInt(tokens[7]);
        if (!teams.containsKey(teamName)) {
            System.out.printf("Team %s does not exist.%n", teamName);
        } else {
            teams.get(teamName).addPlayer(new Player(player, stat1, stat2, stat3, stat4, stat5));
        }
    }
}

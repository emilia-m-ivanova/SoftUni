import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TeamworkProjects {
    static class Team {
        String name;
        String creator;
        List<String> members = new ArrayList<>();

        public Team(String creator, String name) {
            this.creator = creator;
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public String getCreator() {
            return this.creator;
        }

        public List<String> getMembers() {
            return this.members;
        }

        public void printTeam() {
            System.out.println(this.name + System.lineSeparator()
                    + "- " + this.creator);
            members.stream()
                    .sorted(String::compareTo)
                    .forEach(m -> System.out.println("-- " + m));

        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Team> teams = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("-");
            boolean createTeam = true;
            for (Team team : teams) {
                if (team.getCreator().equals(input[0])) {
                    System.out.printf("%s cannot create another team!%n", input[0]);
                    createTeam = false;
                }
                if (team.getName().equals(input[1])) {
                    System.out.printf("Team %s was already created!%n", input[1]);
                    createTeam = false;
                }
            }
            if (createTeam) {
                Team team = new Team(input[0], input[1]);
                System.out.printf("Team %s has been created by %s!%n", input[1], input[0]);
                teams.add(team);
            }
        }

        String input = scanner.nextLine();
        while (!input.equals("end of assignment")) {
            String[] tokens = input.split("->");
            boolean joinTeam = true;
            boolean teamExists = false;
            for (Team team : teams) {
                if (team.getName().equals(tokens[1])) {
                    teamExists = true;
                    break;
                }
            }
            if (!teamExists) {
                System.out.printf("Team %s does not exist!%n", tokens[1]);
            } else {
                for (Team team : teams) {
                    if (team.getMembers().contains(tokens[0])
                            || team.getCreator().equals(tokens[0])) {
                        System.out.printf("Member %s cannot join team %s!%n", tokens[0], team.getName());
                        joinTeam = false;
                    }
                }
            }

            if (joinTeam && teamExists) {
                for (Team team : teams) {
                    if (team.getName().equals(tokens[1])) {
                        team.getMembers().add(tokens[0]);
                        break;
                    }
                }
            }
            input = scanner.nextLine();
        }

        List<Team> nonDisband = new ArrayList<>();
        List<Team> disband = new ArrayList<>();
        for (Team team : teams) {
            if (team.getMembers().isEmpty()) {
                disband.add(team);
            } else {
                nonDisband.add(team);
            }
        }
        nonDisband.stream()
                .sorted(Comparator.comparing(Team::getName))
                .sorted((e1, e2) -> {
                    int first = e1.getMembers().size();
                    int second = e2.getMembers().size();
                    return Integer.compare(second, first);
                })
                .forEach(Team::printTeam);
        System.out.println("Teams to disband:");
        disband.stream()
                .sorted(Comparator.comparing(Team::getName))
                .forEach(t-> System.out.println(t.getName()));
    }
}

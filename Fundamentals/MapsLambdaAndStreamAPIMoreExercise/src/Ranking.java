import java.util.*;

public class Ranking {
    static class Contest {
        String name;
        int points = 0;

        public Contest(String name) {
            this.name = name;
        }

        public void changePoints(int points) {
            if (points > this.points) {
                this.points = points;
            }
        }

        public String getName() {
            return this.name;
        }

        public int getPoints() {
            return this.points;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> contests = new HashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("end of contests")) {
            String[] tokens = input.split(":");
            contests.put(tokens[0], tokens[1]);
            input = scanner.nextLine();
        }

        Map<String, List<Contest>> students = new TreeMap<>();
        String input2 = scanner.nextLine();
        while (!input2.equals("end of submissions")) {
            String[] tokens = input2.split("=>");
            String contestName = tokens[0];
            String password = tokens[1];
            String username = tokens[2];
            int points = Integer.parseInt(tokens[3]);
            if (contests.containsKey(contestName)) {
                if (contests.get(contestName).equals(password)) {
                    students.putIfAbsent(username, new ArrayList<>());

                    boolean contestExists = false;
                    for (Map.Entry<String, List<Contest>> entry : students.entrySet()) {
                        if (entry.getKey().equals(username)) {
                            for (Contest value : entry.getValue()) {
                                if (value.getName().equals(contestName)) {
                                    value.changePoints(points);
                                    contestExists = true;
                                }
                            }
                        }
                    }
                    if (!contestExists) {
                        Contest contest = new Contest(contestName);
                        contest.changePoints(points);
                        students.get(username).add(contest);
                    }
                }
            }
            input2 = scanner.nextLine();
        }
        String bestStudent = "";
        int bestPoints = 0;
        for (Map.Entry<String, List<Contest>> entry : students.entrySet()) {
            int sum = entry.getValue().stream().mapToInt(Contest::getPoints).sum();
            if (sum > bestPoints) {
                bestPoints = sum;
                bestStudent = entry.getKey();
            }
        }
        System.out.printf("Best candidate is %s with total %d points.%nRanking: %n", bestStudent, bestPoints);
        for (Map.Entry<String, List<Contest>> entry : students.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().stream()
                    .sorted((v1, v2) -> {
                        int value1 = v1.getPoints();
                        int value2 = v2.getPoints();
                        return Integer.compare(value2, value1);
                    })
                    .forEach(v -> System.out.printf("#  %s -> %d%n", v.getName(), v.getPoints()));
        }
    }
}

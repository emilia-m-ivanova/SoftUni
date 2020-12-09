import java.util.*;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(";");
        Map<String, List<Long>> robots = new LinkedHashMap<>();
        String[] arrayTime = scanner.nextLine().split(":");
        int hours = Integer.parseInt(arrayTime[0]);
        int minutes = Integer.parseInt(arrayTime[1]);
        int seconds = Integer.parseInt(arrayTime[2]);
        long secondsTotal = (long) (hours * 3600) + (minutes * 60) + seconds;
        for (int i = 0; i < input.length; i++) {
            String[] array = input[i].split("-");
            List<Long> list = new ArrayList<>();
            list.add((long) Integer.parseInt(array[1]));
            list.add(secondsTotal+i+1);
            robots.put(array[0], list);
        }
        ArrayDeque<String> elements = new ArrayDeque<>();
        String element = scanner.nextLine();
        while (!element.equals("End")) {
            elements.offer(element);
            element = scanner.nextLine();
        }
        while (!elements.isEmpty()) {
            secondsTotal++;
            boolean found = false;
            for (Map.Entry<String, List<Long>> robot : robots.entrySet()) {
                if (robot.getValue().get(1) <= secondsTotal) {
                    System.out.printf("%s - %s [%s]%n", robot.getKey(), elements.poll(), secondsToStrings(secondsTotal));
                    robot.getValue().set(1, secondsTotal + robot.getValue().get(0));
                    found = true;
                    break;
                }
            }
            if(!found){
                long min = robots.values().stream().mapToLong(v->v.get(1)).min().getAsLong();
                for (int i = 0; i < min - secondsTotal; i++) {
                    elements.offer(elements.poll());
                }
                secondsTotal=min-1;
            }
        }

    }

    private static String secondsToStrings(long seconds) {
        int newHours = (int) (seconds / 3600)%24;
        int newMinutes = (int) ((seconds % 3600) / 60);
        int newSeconds = (int) (seconds % 60);
        return String.format("%02d:%02d:%02d", newHours, newMinutes, newSeconds);
    }
}

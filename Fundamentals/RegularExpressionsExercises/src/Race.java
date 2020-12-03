import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split(", ");
        List<String> participants = new ArrayList<>(Arrays.asList(names));
        Map<String, Integer> results = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("end of race")) {
            int sum = 0;
            Pattern pattern = Pattern.compile("[A-Za-z]");
            Matcher matcher = pattern.matcher(input);
            StringBuilder name = new StringBuilder();
            while (matcher.find()) {
                name.append(matcher.group());
            }
            if (participants.contains(String.valueOf(name))) {
                pattern = Pattern.compile("\\d");
                matcher = pattern.matcher(input);
                while (matcher.find()) {
                    sum += Integer.parseInt(matcher.group());
                }
                results.putIfAbsent(String.valueOf(name), 0);
                results.put(String.valueOf(name), results.get(String.valueOf(name)) + sum);
            }
            input = scanner.nextLine();
        }

        List<String> output = new ArrayList<>();
        results.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(3)
                .forEach(v->output.add(v.getKey()));
        System.out.printf("1st place: %s%n" +
                "2nd place: %s%n" +
                "3rd place: %s%n",output.get(0),output.get(1),output.get(2));


    }
}

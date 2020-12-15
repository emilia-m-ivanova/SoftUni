import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Unleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regEx = "(?<singer>(\\w+ ){1,3})@(?<venue>(\\w+ ){1,3})(?<price>\\d+) (?<count>\\d+)";
        Map<String, Map<String,Long>> cities = new LinkedHashMap<>();
        while (!input.equals("End")){
            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(input);
            if(matcher.find()){
                String venue = matcher.group("venue");
                String singer = matcher.group("singer");
                long money = Long.parseLong(matcher.group("price")) * Long.parseLong(matcher.group("count"));
                cities.putIfAbsent(venue,new LinkedHashMap<>());
                cities.get(venue).putIfAbsent(singer, 0L);
                cities.get(venue).put(singer,cities.get(venue).get(singer)+money);
            }

            input = scanner.nextLine();
        }
        cities.forEach((k,v)->{
            System.out.println(k);
            v.entrySet().stream()
                    .sorted((a,b)->b.getValue().compareTo(a.getValue()))
                    .forEach(e-> System.out.printf("#  %s-> %d%n",e.getKey(),e.getValue()));
        });
    }
}

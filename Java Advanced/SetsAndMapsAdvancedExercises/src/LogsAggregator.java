import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String,Map<String,Integer>> users = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String IP = input[0];
            String user = input[1];
            int duration = Integer.parseInt(input[2]);
            users.putIfAbsent(user,new TreeMap<>());
            users.get(user).putIfAbsent(IP,0);
            users.get(user).put(IP,users.get(user).get(IP)+duration);
        }
        users.forEach((k,v)->{
            int duration = v.values().stream()
                    .mapToInt(Integer::intValue).sum();
            System.out.println(k+": "+duration + " [" + String.join(", ", v.keySet()) + "]");
        });
    }
}

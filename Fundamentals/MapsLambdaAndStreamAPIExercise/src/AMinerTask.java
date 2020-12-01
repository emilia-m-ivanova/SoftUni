import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Long> resources = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("stop")){
            long quantity = Long.parseLong(scanner.nextLine());
            if(!resources.containsKey(input)){
                resources.put(input,(long)0);
            }
            resources.put(input,resources.get(input)+quantity);
            input = scanner.nextLine();
        }
        for (Map.Entry<String, Long> entry : resources.entrySet()) {
            System.out.println(entry.getKey()+" -> "+entry.getValue());
        }
    }
}

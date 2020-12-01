import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> registered = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(" ");
            String username = command[1];
            switch (command[0]) {
                case "register":
                    String licencePlate = command[2];
                    if(registered.containsKey(username)){
                        System.out.println("ERROR: already registered with plate number "+registered.get(username));
                    }else{
                        registered.put(username,licencePlate);
                        System.out.printf("%s registered %s successfully%n",username,licencePlate);
                    }
                    break;
                case "unregister":
                    if(registered.containsKey(username)){
                        registered.remove(username);
                        System.out.printf("%s unregistered successfully%n",username);
                    }else{
                        System.out.printf("ERROR: user %s not found%n",username);
                    }
                    break;
            }
        }
        for (Map.Entry<String, String> entry : registered.entrySet()) {
            System.out.println(entry.getKey()+" => "+entry.getValue());
        }
    }
}

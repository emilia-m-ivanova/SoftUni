import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String,Map<String,Integer>> users = new TreeMap<>();

        while (!input.equals("end")){
            String[] tokens = input.split("\\s+");
            String IP = tokens[0].substring(3);
            String user = tokens[2].substring(5);
            users.putIfAbsent(user,new LinkedHashMap<>());
            users.get(user).putIfAbsent(IP,0);
            users.get(user).put(IP,users.get(user).get(IP)+1);
            input = scanner.nextLine();
        }
        users.forEach((k,v)->{
            System.out.println(k + ":");
            int count = v.size();
            for (Map.Entry<String, Integer> entry : v.entrySet()) {
                count--;
                System.out.print(entry.getKey() + " => " + entry.getValue());
                if(count>0){
                    System.out.print(", ");
                }else{
                    System.out.println(".");
                }
            }
        });
    }
}

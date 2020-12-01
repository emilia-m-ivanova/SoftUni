import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MOBAChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String,Integer>> players = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Season end")){
            if(input.contains("->")){
                String [] tokens = input.split(" -> ");
                String player = tokens[0];
                String position = tokens[1];
                int points = Integer.parseInt(tokens[2]);
                players.putIfAbsent(player,new TreeMap<>());
                players.get(player).putIfAbsent(position,points);
                if(players.get(player).get(position)<points){
                    players.get(player).put(position,points);
                }

            }else{
                String [] tokens = input.split(" ");
                String player1 = tokens[0];
                String player2 = tokens[2];
                boolean matchingPositions = false;
                    for (Map.Entry<String, Map<String, Integer>> entry1 : players.entrySet()) {
                        if(entry1.getKey().equals(player1)){
                            for (Map.Entry<String, Map<String, Integer>> entry2 : players.entrySet()) {
                                if(entry2.getKey().equals(player2)){
                                    for(Map.Entry<String, Integer> position1 : entry1.getValue().entrySet()){
                                        for(Map.Entry<String, Integer> position2 : entry2.getValue().entrySet()){
                                            if(position1.getKey().equals(position2.getKey())){
                                                matchingPositions = true;
                                                break;
                                            }
                                        }
                                    }

                                }
                            }
                        }
                    }
                if(matchingPositions){
                    int sum1 = players.get(player1).values()
                            .stream()
                            .mapToInt(Integer::intValue).sum();
                    int sum2 = players.get(player2).values()
                            .stream()
                            .mapToInt(Integer::intValue).sum();
                    if(sum1>sum2){
                        players.remove(player2);
                    }else if(sum2>sum1){
                        players.remove(player1);
                    }
                }
            }

            input = scanner.nextLine();
        }
       players.entrySet()
               .stream()
               .sorted((p1,p2)->{
                   int sum1 = p1.getValue().values().stream().mapToInt(Integer::intValue).sum();
                   int sum2 = p2.getValue().values().stream().mapToInt(Integer::intValue).sum();
                   return Integer.compare(sum2,sum1);
               })
               .forEach(v->{
                   int sum = v.getValue().values().stream().mapToInt(Integer::intValue).sum();
                   System.out.printf("%s: %d skill%n",v.getKey(),sum);
                   v.getValue().entrySet().stream().sorted((p1,p2)->Integer.compare(p2.getValue(),p1.getValue()))
                   .forEach(p-> System.out.printf("- %s <::> %d%n",p.getKey(),p.getValue()));
               });
    }
}

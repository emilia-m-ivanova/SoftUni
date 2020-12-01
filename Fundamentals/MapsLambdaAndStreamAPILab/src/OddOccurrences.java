import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] words = scanner.nextLine().toLowerCase().split(" ");
        Map <String, Integer> occurrences = new LinkedHashMap<>();
        for (String word : words) {
            if(!occurrences.containsKey(word)){
                occurrences.put(word,0);
            }
            occurrences.put(word,occurrences.get(word)+1);
        }
        List <String> odd = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : occurrences.entrySet()) {
            if(entry.getValue()%2!=0){
               odd.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ", odd));
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String regExLetters = "[STARstar]";
        String regExDecrypted = "@(?<name>[A-Z]+[a-z]*)" +
                "(?:[^@\\-!:>]*):" +
                "(?<population>\\d+)" +
                "(?:[^@\\-!:>]*)!" +
                "(?<attack>[AD])!" +
                "(?:[^@\\-!:>]*)->" +
                "(?<soldiers>\\d+)";
        List<String> attacked = new ArrayList<>();
        List <String> destroyed = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Pattern pattern = Pattern.compile(regExLetters);
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            int key = 0;
            while(matcher.find()){
                key++;
            }
            StringBuilder decrypted = new StringBuilder();
            for (char c : input.toCharArray()) {
                decrypted.append((char) (c - key));
            }
            pattern = Pattern.compile(regExDecrypted);
            matcher = pattern.matcher(decrypted);
            if(matcher.find()){
                String name = matcher.group("name");
                String attack = matcher.group("attack");
                switch (attack){
                    case "A":
                        attacked.add(name);
                        break;
                    case "D":
                        destroyed.add(name);
                        break;
                }
            }
        }
        System.out.println("Attacked planets: "+attacked.size());
        attacked.stream()
        .sorted()
        .forEach(p-> System.out.println("-> "+p));
        System.out.println("Destroyed planets: "+destroyed.size());
        destroyed.stream()
                .sorted()
                .forEach(p-> System.out.println("-> "+p));

    }
}

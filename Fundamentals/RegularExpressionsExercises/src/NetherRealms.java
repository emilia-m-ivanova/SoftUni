import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] demons = scanner.nextLine().split("\\s*,\\s*");
        Arrays.sort(demons);
        for (String demon : demons) {
            String regExHealth = "[^+\\-*/.0-9]";
            Pattern pattern = Pattern.compile(regExHealth);
            Matcher matcher = pattern.matcher(demon);
            int health = 0;
            while (matcher.find()){
                health+=matcher.group().charAt(0);
            }
            double damage = 0;
            String regExDamage = "[+-]*\\d+(\\.\\d+)*";
            pattern = Pattern.compile(regExDamage);
            matcher = pattern.matcher(demon);
            while (matcher.find()){
                damage+=Double.parseDouble(matcher.group());
            }
            for (char c : demon.toCharArray()) {
                if(c=='/'){
                    damage/=2;
                }else if (c=='*'){
                    damage*=2;
                }
            }
            System.out.printf("%s - %d health, %.2f damage%n",demon,health,damage);
        }
    }
}

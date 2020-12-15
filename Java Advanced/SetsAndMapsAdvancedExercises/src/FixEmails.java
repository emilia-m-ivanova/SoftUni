import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Set<String> emails = new LinkedHashSet<>();
        while (!name.equals("stop")){
            String email = scanner.nextLine();
            if(!email.endsWith(".us")&&
            !email.endsWith(".uk")&&
            !email.endsWith(".com")){
            emails.add(String.format("%s -> %s",name,email));
            }
            name = scanner.nextLine();
        }
        System.out.println(String.join(System.lineSeparator(),emails));
    }
}

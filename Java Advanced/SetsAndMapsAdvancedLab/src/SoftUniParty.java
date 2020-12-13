import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> vipGuests = new TreeSet<>();
        Set<String> regularGuests = new TreeSet<>();
        String input = scanner.nextLine();
        while (!input.equals("PARTY")){
            if(Character.isDigit(input.charAt(0))){
                vipGuests.add(input);
            }else{
                regularGuests.add(input);
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("END")){
            vipGuests.remove(input);
            regularGuests.remove(input);
            input = scanner.nextLine();
        }
        System.out.println(vipGuests.size()+regularGuests.size());
        for (String vipGuest : vipGuests) {
            System.out.println(vipGuest);
        }
        for (String regularGuest : regularGuests) {
            System.out.println(regularGuest);
        }

    }
}

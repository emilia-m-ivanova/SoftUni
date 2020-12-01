import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        List <String> guests = new ArrayList<>();
        for (int i = 0; i < lines; i++) {
            String [] invitation = scanner.nextLine().split(" ");
            String name = invitation[0];
            if(invitation.length==3){
                if(!guests.contains(name)){
                    guests.add(name);
                }else{
                    System.out.printf("%s is already in the list!%n",name);
                }
            }else{
                if(guests.contains(name)){
                    guests.remove(name);
                }else {
                    System.out.printf("%s is not in the list!%n",name);
                }
            }
        }
        for (String guest : guests) {
            System.out.println(guest);
        }

    }
}

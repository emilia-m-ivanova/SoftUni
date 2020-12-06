import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initialHealth = 100;
        int initialBitcoins = 0;
        String[] rooms = scanner.nextLine().split("\\|");
        for (int i = 0; i < rooms.length ; i++) {
            String[] currentRoom = rooms[i].split("\\s+");
            int number = Integer.parseInt(currentRoom[1]);
            switch (currentRoom[0]) {
                case "potion":
                    if (initialHealth + number > 100) {
                        number = 100 - initialHealth;
                    }
                    initialHealth += number;
                    System.out.printf("You healed for %d hp.%nCurrent health: %d hp.%n", number, initialHealth);
                    break;
                case "chest":
                    initialBitcoins += number;
                    System.out.printf("You found %d bitcoins.%n", number);
                    break;
                default:
                    initialHealth -= number;
                    if (initialHealth > 0) {
                        System.out.printf("You slayed %s.%n", currentRoom[0]);
                    } else {
                        System.out.printf("You died! Killed by %s.%nBest room: %d", currentRoom[0],i+1);
                        return;
                    }
                    break;
            }
        }
        System.out.printf("You've made it!%nBitcoins: %d%nHealth: %d",initialBitcoins,initialHealth);
    }
}

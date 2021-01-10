package CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Card card = new Card(RankPower.valueOf(scanner.nextLine().toUpperCase()),
                SuitPower.valueOf(scanner.nextLine().toUpperCase()));
        System.out.println(card);
    }
}

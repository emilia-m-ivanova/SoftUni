import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Set<String>> playerCards = new LinkedHashMap<>();
        while (!input.equals("JOKER")) {
            String[] playerInfo = input.split(": ");
            String name = playerInfo[0];
            String[] cards = playerInfo[1].split(", ");
            playerCards.putIfAbsent(name, new HashSet<>());
            playerCards.get(name).addAll(Arrays.asList(cards));
            input = scanner.nextLine();
        }
        playerCards.forEach((k, v) -> System.out.println(k + ": " + getSum(v)));

    }

    private static int getSum(Set<String> value) {
        int totalSum = 0;
        for (String card : value) {
            int firstNum;
            int secondNum = 1;
            if (card.charAt(0) == 'J') {
                firstNum = 11;
            } else if (card.charAt(0) == 'Q') {
                firstNum = 12;
            } else if (card.charAt(0) == 'K') {
                firstNum = 13;
            } else if (card.charAt(0) == 'A') {
                firstNum = 14;
            } else if (card.charAt(0) == '1') {
                firstNum = 10;
            } else {
                firstNum = Integer.parseInt(String.valueOf(card.charAt(0)));
            }
            switch (card.charAt(card.length() - 1)) {
                case 'S':
                    secondNum = 4;
                    break;
                case 'H':
                    secondNum = 3;
                    break;
                case 'D':
                    secondNum = 2;
                    break;
                case 'C':
                    secondNum = 1;
                    break;
            }
            totalSum += firstNum * secondNum;
        }
        return totalSum;
    }
}

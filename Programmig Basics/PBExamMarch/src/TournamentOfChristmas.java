import java.util.Scanner;

public class TournamentOfChristmas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        double moneyRaised = 0;
        int daysWin = 0;
        for (int i = 1; i <= days; i++) {
            String game = scanner.nextLine();
            int win = 0;
            int lose = 0;
            double moneyDay = 0;
            while (!game.equals("Finish")) {
                String result = scanner.nextLine();
                switch (result) {
                    case "win":
                        win++;
                        moneyDay += 20;
                        break;
                    case "lose":
                        lose++;
                        break;
                }

                game = scanner.nextLine();
            }
            if (win > lose) {
                moneyDay += moneyDay * 10 * 0.01;
                daysWin++;
            }
            moneyRaised += moneyDay;

        }
        if((daysWin * 2) > days) {
            moneyRaised += moneyRaised * 20 * 0.01;
            System.out.printf("You won the tournament! Total raised money: %.2f", moneyRaised);
        } else {

            System.out.printf("You lost the tournament! Total raised money: %.2f", moneyRaised);
        }

    }
}

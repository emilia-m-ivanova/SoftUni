import java.util.Scanner;

public class ChangeBureau {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1 биткойн = 1168 лева.
        // 1 китайски юан = 0.15 долара. (0.15*1.76)lv
        // 1 долар = 1.76 лева.
        // 1 евро = 1.95 лева.
        int bitcoin = Integer.parseInt(scanner.nextLine());
        double ioan = Double.parseDouble(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());

        double moneyInEuro = (bitcoin*1168+ioan*0.15*1.76)/1.95;
        double commission = moneyInEuro*percent*0.01;
        System.out.printf("%.2f",moneyInEuro-commission);

    }
}

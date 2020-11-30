import java.util.Scanner;

public class TradeCommissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String city = scanner.nextLine();
        double s = Double.parseDouble(scanner.nextLine());
        double commission = 0;
        if (city.equals("Sofia")) {
            if (500>=s) {
                commission = 5*0.01*s;
            } else if (500 < s && s <= 1000) {
                commission = 7*0.01*s;
            } else if (1000 < s && s <= 10000){
                commission = 8*0.01*s;
            } else if (s>10000){
                commission=12*0.01*s;
            }

        } else if (city.equals("Varna")) {
            if (500>=s) {
                commission = 4.5*0.01*s;
            } else if (500 < s && s <= 1000) {
                commission = 7.5*0.01*s;
            } else if (1000 < s && s <= 10000){
                commission = 10*0.01*s;
            } else if (s>10000){
                commission=13*0.01*s;
            }

        } else if (city.equals("Plovdiv")) {
            if (500>=s) {
                commission = 5.5*0.01*s;
            } else if (500 < s && s <= 1000) {
                commission = 8*0.01*s;
            } else if (1000 < s && s <= 10000){
                commission = 12*0.01*s;
            } else if (s>10000){
                commission=14.5*0.01*s;
            }

        }
        if (commission > 0) {
            System.out.printf("%.2f", commission);
        } else {
            System.out.println("error");
        }
    }
}

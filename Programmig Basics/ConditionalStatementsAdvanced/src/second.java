import java.util.Scanner;

public class second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String city = scanner.nextLine();
        double s = Double.parseDouble(scanner.nextLine());
        boolean first = 500>=s;
        boolean second = 500 < s && s <= 1000;
        boolean third = 1000 < s && s <= 10000;
        boolean forth = s>10000;
        double commission = 0;
        switch (city) {
            case "Sofia":
                if (first) {
                    commission = 5 * 0.01 * s;
                } else if (second) {
                    commission = 7 * 0.01 * s;
                } else if (third) {
                    commission = 8 * 0.01 * s;
                } else if (forth) {
                    commission = 12 * 0.01 * s;
                }

                break;
            case "Varna":
                if (first) {
                    commission = 4.5 * 0.01 * s;
                } else if (second) {
                    commission = 7.5 * 0.01 * s;
                } else if (third) {
                    commission = 10 * 0.01 * s;
                } else if (forth) {
                    commission = 13 * 0.01 * s;
                }

                break;
            case "Plovdiv":
                if (first) {
                    commission = 5.5 * 0.01 * s;
                } else if (second) {
                    commission = 8 * 0.01 * s;
                } else if (third) {
                    commission = 12 * 0.01 * s;
                } else if (forth) {
                    commission = 14.5 * 0.01 * s;
                }

                break;
        }
        if (commission > 0) {
            System.out.printf("%.2f", commission);
        } else {
            System.out.println("error");
        }
    }
}


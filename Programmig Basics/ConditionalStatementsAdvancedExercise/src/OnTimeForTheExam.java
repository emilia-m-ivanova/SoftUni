import java.util.Scanner;

public class OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hourExam = Integer.parseInt(scanner.nextLine());
        int minExam = Integer.parseInt(scanner.nextLine());
        int hourArrival = Integer.parseInt(scanner.nextLine());
        int minArrival = Integer.parseInt(scanner.nextLine());
        int timeExam = hourExam * 60 + minExam;
        int timeArrival = hourArrival * 60 + minArrival;
        int differenceMin = Math.abs(timeArrival - timeExam);
        if (differenceMin < 60) {
            int min = differenceMin;
            if (timeArrival > timeExam) {
                System.out.println("Late");
                System.out.printf("%d minutes after the start", min);
            } else if (timeExam - timeArrival > 30) {
                System.out.println("Early");
                System.out.printf("%d minutes before the start", min);
            } else {
                System.out.println("On time");
                if (!(min == 0)) {
                    System.out.printf("%d minutes before the start", min);
                }
            }

        } else {
            int h = differenceMin / 60;
            int min = differenceMin % 60;
            if (timeArrival > timeExam) {
                System.out.println("Late");
                System.out.printf("%d:%02d hours after the start", h, min);
            } else if (timeExam - timeArrival > 30) {
                System.out.println("Early");
                System.out.printf("%d:%02d hours before the start", h, min);
            } else {
                System.out.println("On time");
                if (!(min == 0)) {
                    System.out.printf("%d minutes before the start", min);
                }
            }
        }

    }
}

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += Integer.parseInt(scanner.nextLine());
        }
        int studentsCount = Integer.parseInt(scanner.nextLine());
        int hours = (int) Math.ceil((double) studentsCount / sum);
        if (hours%3!=0) {
            hours += hours / 3;
        }else if (hours>3){
            hours +=hours/3 -1;
        }
        System.out.printf("Time needed: %dh.", hours);
    }
}

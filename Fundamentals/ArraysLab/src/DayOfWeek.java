import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[]days = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        int input = Integer.parseInt(scanner.nextLine());
        if(1<=input&&input<=7){
            System.out.println(days[input-1]);
        }else{
            System.out.println("Invalid day!");
        }
    }
}

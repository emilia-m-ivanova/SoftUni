import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Homework homework = Homework.startConnection();
        while (true){
            //ex 2
            homework.getVillainsNames();
            //ex 3
            //homework.getMinionNames();
            //ex 4
            //homework.addMinion();
            //ex 5
            //homework.changeTownNamesCasing();
            //ex 7
            //homework.printAllMinionNames();
            //ex 8
            //homework.increaseMinionsAge();
            //ex 9
            //homework.increaseAgeStoredProcedure();
            System.out.println("Enter 'exit' to end the program, enter anything else to continue testing with different input");
            String input = scanner.nextLine();
            if(input.equals("exit")){
                break;
            }
        }
    }
}

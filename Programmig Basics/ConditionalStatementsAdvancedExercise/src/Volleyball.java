import java.util.Scanner;

public class Volleyball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String year = scanner.nextLine(); //leap,normal
        double p = Double.parseDouble(scanner.nextLine()); //bank holidays
        double h = Double.parseDouble(scanner.nextLine()); //weekends to hometown
        double playBankH = p*2/3;
        double playSunday = h;
        double playSat = (48-h)*3/4;
        double play = playBankH+playSat+playSunday;
        if(year.equals("leap")){
            play=play*15*0.01+play;
        }
        System.out.printf("%.0f",Math.floor(play));
    }
}

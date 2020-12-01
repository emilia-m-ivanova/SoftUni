import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String user = scanner.nextLine();
        String passTry = scanner.nextLine();
        int length = user.length();
        String pass = "";
        int counter = 0;
        for (int i = length-1; i >=0 ; i--) {
            pass +=user.charAt(i);
        }
        while (!pass.equals(passTry)){
            if (counter==3){
                System.out.printf("User %s blocked!",user);
                return;
            }
            System.out.println("Incorrect password. Try again.");
            passTry=scanner.nextLine();
            counter++;
        }
        System.out.printf("User %s logged in.",user);
    }
}

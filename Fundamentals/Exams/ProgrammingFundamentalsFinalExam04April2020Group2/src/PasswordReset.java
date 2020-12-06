import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        String command = scanner.nextLine();
        while(!command.equals("Done")){
            String [] tokens = command.split(" ");
            switch (tokens[0]){
                case "TakeOdd":
                    StringBuilder sb = new StringBuilder();
                    for (int i = 1; i < password.length(); i+=2) {
                        sb.append(password.charAt(i));
                    }
                    password = String.valueOf(sb);
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    String subString = password.substring(index,index+length);
                    password = password.replaceFirst(subString,"");
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substring = tokens[1];
                    String substitute = tokens[2];
                    if(password.contains(substring)){
                        password = password.replaceAll(substring,substitute);
                        System.out.println(password);
                    }else{
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }

            command = scanner.nextLine();
        }
        System.out.println("Your password is: "+password);
    }
}

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String activationKey = scanner.nextLine();
        String input = scanner.nextLine();
        while (!input.equals("Generate")){
            String [] command = input.split(">>>");
            switch (command[0]){
                case "Contains":
                    if(activationKey.contains(command[1])){
                        System.out.printf("%s contains %s%n",activationKey,command[1]);
                    }else{
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    int startIndex = Integer.parseInt(command[2]);
                    int endIndex = Integer.parseInt(command[3]);
                    switch (command[1]){
                        case "Upper":
                           activationKey = activationKey.replace(activationKey.substring(startIndex,endIndex),
                                   activationKey.substring(startIndex,endIndex).toUpperCase());
                            break;
                        case "Lower":
                            activationKey = activationKey.replace(activationKey.substring(startIndex,endIndex),
                                    activationKey.substring(startIndex,endIndex).toLowerCase());
                            break;
                    }
                    System.out.println(activationKey);
                    break;
                case "Slice":
                    int start = Integer.parseInt(command[1]);
                    int end = Integer.parseInt(command[2]);
                    activationKey = activationKey.replace(activationKey.substring(start,end),"");
                    System.out.println(activationKey);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("Your activation key is: "+activationKey);
    }
}

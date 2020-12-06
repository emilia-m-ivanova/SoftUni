import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        String command = scanner.nextLine();
        while (!command.equals("Reveal")){
            String [] tokens = command.split(":\\|:");
            switch (tokens[0]){
                case "InsertSpace":
                    int index = Integer.parseInt(tokens[1]);
                    message = message.substring(0,index)+" "+message.substring(index);
                    System.out.println(message);
                    break;
                case "Reverse":
                    String substring = tokens[1];
                    String reversed = reverseString(substring);
                    if(message.contains(substring)){
                        int indexString = message.indexOf(substring);
                        message = message.substring(0,indexString)+message.substring(indexString+substring.length());
                        message = message.concat(reversed);
                        System.out.println(message);
                    }else{
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String subString = tokens[1];
                    String replacement = tokens[2];
                    message = message.replaceAll(subString,replacement);
                    System.out.println(message);
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.println("You have a new text message: "+message);
    }

    private static String reverseString(String substring) {
        StringBuilder reversed = new StringBuilder();
        for (int i = substring.length()-1; i >=0 ; i--) {
            reversed.append(substring.charAt(i));
        }
        return String.valueOf(reversed);
    }
}

import java.util.Scanner;

public class DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("END")){
            String type;
            char currentChar;
            boolean isDot = false;
            boolean isDigit = false;
            boolean isString = false;
            for (int i = 0; i < input.length(); i++) {
                currentChar=input.charAt(i);
                if(currentChar==46){
                    isDot=true;
                }else if (48<=currentChar&&currentChar<=57) {
                    isDigit = true;
                }else if (currentChar!=45){
                    isString=true;
                }
            }
            if(input.toLowerCase().equals("true")||input.toLowerCase().equals("false")){
                type="boolean";
            }else if(input.length()==1&&!isDigit){
                type="character";
            }else if (isString){
                type="string";
            }else if (isDot){
                type="floating point";
            }else{
                type="integer";
            }
            System.out.printf("%s is %s type%n",input,type);
            input=scanner.nextLine();
        }

    }
}

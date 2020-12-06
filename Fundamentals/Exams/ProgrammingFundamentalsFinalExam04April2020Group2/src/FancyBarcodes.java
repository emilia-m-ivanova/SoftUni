import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String regEx = "^(@#+)([A-Z][a-zA-Z\\d]{4,}[A-Z])(@#+)$";
        Pattern pattern = Pattern.compile(regEx);
        for (int i = 0; i < n ; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            String output = "";
            if(matcher.find()){
                String product = matcher.group(2);
                for(char c : product.toCharArray()){
                    if(Character.isDigit(c)){
                       output = output.concat(String.valueOf(c));
                    }
                }
                if(output.equals("")){
                    System.out.println("Product group: 00");
                }else{
                    System.out.println("Product group: "+output);
                }
            }else{
                System.out.println("Invalid barcode");
            }
        }
    }
}

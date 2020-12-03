import java.util.Scanner;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] key = scanner.nextLine().split("\\s+");
        String input = scanner.nextLine();
        StringBuilder output = new StringBuilder();
        while(!input.equals("find")){
            int index = 0;
            for (char c : input.toCharArray()) {
                if(index==key.length){
                    index = 0;
                }
                output.append((char) (c-Integer.parseInt(key[index])));
                index++;
            }
            System.out.printf("Found %s at %s%n",
                    output.substring(output.indexOf("&")+1,output.lastIndexOf("&")),
                    output.substring(output.indexOf("<")+1,output.indexOf(">")));
            output.setLength(0);
            input = scanner.nextLine();
        }
    }
}

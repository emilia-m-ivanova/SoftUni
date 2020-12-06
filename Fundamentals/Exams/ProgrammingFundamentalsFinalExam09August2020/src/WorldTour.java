import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stops = scanner.nextLine();
        String input = scanner.nextLine();
        while (!input.equals("Travel")){
            String [] command = input.split(":");
            switch (command[0]){
                case "Add Stop":
                    int index = Integer.parseInt(command[1]);
                    String string = command[2];
                    if(0<=index&&index<stops.length()){
                        stops = stops.substring(0,index)+string+stops.substring(index);
                    }
                    System.out.println(stops);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(command[1]);
                    int endIndex = Integer.parseInt(command[2]);
                    if(0<=startIndex&&startIndex<stops.length()&&
                            0<=endIndex&&endIndex<stops.length()){
                        stops = stops.substring(0,startIndex)+stops.substring(endIndex+1);
                    }
                    System.out.println(stops);
                    break;
                case "Switch":
                    String oldString = command[1];
                    String newString = command[2];
                    if(stops.contains(oldString)){
                        stops = stops.replaceAll(oldString,newString);
                    }
                    System.out.println(stops);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: "+stops);
    }
}

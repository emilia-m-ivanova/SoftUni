import java.util.Scanner;

public class EasterEggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int eggsNum = Integer.parseInt(scanner.nextLine());
        int Red = 0;
        int Blue = 0;
        int Green = 0;
        int Orange = 0;
        int maxEggs = Integer.MIN_VALUE;
        String maxColour = "";
        for (int i = 1; i <=eggsNum ; i++) {
            String colour = scanner.nextLine();
            switch (colour){
                case "red":
                    Red++;
                    if(Red>maxEggs){
                        maxEggs=Red;
                        maxColour="red";
                    }
                    break;
                case "blue":
                    Blue++;
                    if(Blue>maxEggs){
                        maxEggs=Blue;
                        maxColour="blue";
                    }
                    break;
                case "green":
                    Green++;
                    if(Green>maxEggs){
                        maxEggs=Green;
                        maxColour="green";
                    }
                    break;
                case "orange":
                    Orange++;
                    if(Orange>maxEggs){
                        maxEggs=Orange;
                        maxColour="orange";
                    }
                    break;
            }
        }
        System.out.printf("Red eggs: %d%nOrange eggs: %d%nBlue eggs: %d%nGreen eggs: %d%nMax eggs: %d -> %s",Red,Orange,Blue,Green,maxEggs,maxColour);
    }
}

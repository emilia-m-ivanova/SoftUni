import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String movie = scanner.nextLine();

        int standard = 0;
        int student = 0;
        int kids = 0;
        int ticketsCurrent = 0;
        while(!movie.equals("Finish")){
            ticketsCurrent=0;
            int free = Integer.parseInt(scanner.nextLine());
            for (int i = 1; i <=free ; i++) {
                String ticket = scanner.nextLine();
                if(ticket.equals("End")){
                    break;
                } else if(ticket.equals("standard")){
                    standard++;
                } else if (ticket.equals("student")){
                    student++;
                }else if (ticket.equals("kid")){
                    kids++;
                }
                ticketsCurrent++;

            }
            System.out.printf("%s - %.2f%% full.%n",movie,ticketsCurrent*1.0/free*100);
            movie = scanner.nextLine();

        }
        int totalTickets = standard+student+kids;
        System.out.println("Total tickets: " + totalTickets);
        System.out.printf("%.2f%% student tickets.%n", student*1.0/totalTickets*100);
        System.out.printf("%.2f%% standard tickets.%n", standard*1.0/totalTickets*100);
        System.out.printf("%.2f%% kids tickets.%n", kids*1.0/totalTickets*100);
    }
}

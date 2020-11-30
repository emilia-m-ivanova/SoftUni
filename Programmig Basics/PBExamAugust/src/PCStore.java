import java.util.Scanner;

public class PCStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 1 долар =
        //1.57 лева.
        double processor = Double.parseDouble(scanner.nextLine());
        double video = Double.parseDouble(scanner.nextLine());
        double ram = Double.parseDouble(scanner.nextLine());
        int ramNum = Integer.parseInt(scanner.nextLine());
        double discount = Double.parseDouble(scanner.nextLine());
        //о за процесора и видео картата сайтът му правел няколко процента отстъпка.
        double price = (ram*ramNum+(video-video*discount)+(processor-processor*discount))*1.57;

        System.out.printf("Money needed - %.2f leva.",price);
    }
}

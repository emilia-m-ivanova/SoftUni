import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        String box = scanner.nextLine();
        int space = width * length * height;
        int boxTotal = 0;
        int freeSpace = 0;
        while (!box.equals("Done")) {
            int boxNum = Integer.parseInt(box);
            boxTotal += boxNum;
            freeSpace = Math.abs(space - boxTotal);
            if (boxTotal > space) {
                System.out.printf("No more free space! You need %d Cubic meters more.", freeSpace);
                break;
            }
            box = scanner.nextLine();
        }
        if (boxTotal <= space) {
            System.out.printf("%d Cubic meters left.", freeSpace);
        }
    }
}

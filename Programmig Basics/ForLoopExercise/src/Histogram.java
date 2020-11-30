import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        int num1to199 = 0;
        int num200to399 = 0;
        int num400to599 = 0;
        int num600to799 = 0;
        int num800to1000 = 0;
        for (int i = 1; i <= count; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            if (num < 200) {
                num1to199++;
            } else if (num < 400) {
                num200to399++;
            } else if (num < 600) {
                num400to599++;
            } else if (num < 800) {
                num600to799++;
            } else {
                num800to1000++;
            }
        }
        double p1 = num1to199*100/(count*1.0);
        double p2 = num200to399*100/(count*1.0);
        double p3 = num400to599*100/(count*1.0);
        double p4 = num600to799*100/(count*1.0);
        double p5 = num800to1000*100/(count*1.0);
        System.out.printf("%.2f%%%n",p1);
        System.out.printf("%.2f%%%n",p2);
        System.out.printf("%.2f%%%n",p3);
        System.out.printf("%.2f%%%n",p4);
        System.out.printf("%.2f%%%n",p5);
    }
}

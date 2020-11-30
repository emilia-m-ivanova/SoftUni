import java.util.Scanner;

public class TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int groups = Integer.parseInt(scanner.nextLine());
        int musala = 0;
        int monblan = 0;
        int kiliman = 0;
        int k2 = 0;
        int everest = 0;
        for (int i = 1; i <=groups ; i++) {
            int members = Integer.parseInt(scanner.nextLine());
            if(members<=5){
                musala+=members;
            }else if(members<=12){
                monblan+=members;
            }else if(members<=25){
                kiliman+=members;
            }else if(members<=40){
                k2+=members;
            }else{
                everest+=members;
            }
            
        }
        int membersAll = musala+monblan+kiliman+k2+everest;
        System.out.printf("%.2f%%%n",musala*1.0/membersAll*100);
        System.out.printf("%.2f%%%n",monblan*1.0/membersAll*100);
        System.out.printf("%.2f%%%n",kiliman*1.0/membersAll*100);
        System.out.printf("%.2f%%%n",k2*1.0/membersAll*100);
        System.out.printf("%.2f%%%n",everest*1.0/membersAll*100);
    }
}

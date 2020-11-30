import java.util.Scanner;

public class Substitude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //От конзолата се четат:
        //• K - началото на интервала за първото число от първия номер – цифра в интервала [0..8]
        //• L - началото на интервала за второто число от първия номер – цифра в интервала [9..0]
        //• M - началото на интервала за първото число от втория номер – цифра в интервала [0..8]
        //• N - началото на интервала за второто число от втория номер – цифра в интервала [9..0]
        int K = Integer.parseInt(scanner.nextLine());
        int L = Integer.parseInt(scanner.nextLine());
        int M = Integer.parseInt(scanner.nextLine());
        int N = Integer.parseInt(scanner.nextLine());
        String firstNum = "";
        String secondNum = "";
        int changeNum = 0;
        for (int j = K; j <= 8; j++) {
            if (j % 2 == 0) {
                for (int k = 9; k >= L; k--) {
                    if (k % 2 == 1) {
                        for (int l = M; l <= 8; l++) {
                            if (l % 2 == 0) {
                                for (int m = 9; m >= N; m--) {
                                    if (m % 2 == 1) {
                                        firstNum = String.valueOf(j) + String.valueOf(k);
                                        secondNum = String.valueOf(l) + String.valueOf(m);
                                        if (firstNum.equals(secondNum)) {
                                            System.out.println("Cannot change the same player.");
                                        } else {
                                            changeNum++;
                                            System.out.printf("%s - %s%n", firstNum, secondNum);
                                        }
                                        if(changeNum==6){
                                            return;
                                        }
                                    }

                                }
                            }

                        }
                    }
                }
            }

        }
    }
}


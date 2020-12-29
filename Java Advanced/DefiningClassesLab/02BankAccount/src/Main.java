import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Set<BankAccount> bankAccounts = new HashSet<>();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Create":
                    BankAccount account = new BankAccount();
                    bankAccounts.add(account);
                    System.out.printf("Account ID%d created%n", account.getID());
                    break;
                case "Deposit":
                    int ID = Integer.parseInt(tokens[1]);
                    double amount = Double.parseDouble(tokens[2]);
                    boolean found = false;
                    for (BankAccount bankAccount : bankAccounts) {
                        if (bankAccount.getID() == ID) {
                            bankAccount.deposit(amount);
                            System.out.printf("Deposited %.0f to ID%d%n", amount, bankAccount.getID());
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    int IDtoSearch = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);
                    boolean isFound = false;
                    for (BankAccount bankAccount : bankAccounts) {
                        if (bankAccount.getID() == IDtoSearch) {
                            System.out.printf("%.2f%n", bankAccount.getInterest(years));
                            isFound = true;
                            break;
                        }
                    }
                    if(!isFound){
                        System.out.println("Account does not exist");
                    }
                    break;
            }

            input = scanner.nextLine();
        }
    }
}

public class BankAccount {
    private static final double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int bankAccountCount = 1;
    private int ID;
    private double balance;
    BankAccount(){
        this.ID = bankAccountCount++;
    }
    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }
    public void deposit(double amount){
        this.balance+=amount;
    }
    public double getInterest(int years){
        return this.balance * BankAccount.interestRate * years;
    }
    public int getID() {
        return ID;
    }
}

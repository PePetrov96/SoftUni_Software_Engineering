public class BankAccount {
    private final static double DEFAULT_INTEREST = 0.02;
    private static double interestRate = DEFAULT_INTEREST;
    private static int bankAccountCount = 1;
    private int id;
    private double balance;
    public BankAccount() {
        this.id = bankAccountCount++;
    }
    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public double getInterestRate(int years) {
        return BankAccount.interestRate * years * this.balance;
    }
    public void deposit(double amount) {
        this.balance += amount;
    }
    public int getId() {
        return id;
    }
    public String newID() {
        return String.format("Account ID%d created", getId());
    }
    public String newDeposit(double amount) {
        return String.format("Deposited %.0f to ID%d", amount, getId());
    }
}
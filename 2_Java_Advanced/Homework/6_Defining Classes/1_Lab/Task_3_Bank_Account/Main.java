import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, BankAccount> bankAccounts = new HashMap<>();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            performOperation(bankAccounts, input.split("\\s+"));
        }
    }
    private static void performOperation(HashMap<Integer, BankAccount> bankAccounts, String[] input) {
        switch (input[0]) {
            case "Create":
                createNewAccount(bankAccounts);
                break;
            case "Deposit":
                depositFunds(bankAccounts, Integer.parseInt(input[1]), Integer.parseInt(input[2]));
                break;
            case "SetInterest":
                setInterest(Double.parseDouble(input[1]));
                break;
            case "GetInterest":
                getInterest(bankAccounts, Integer.parseInt(input[1]), Integer.parseInt(input[2]));
                break;
        }
    }
    private static void createNewAccount (HashMap<Integer, BankAccount> bankAccounts) {
        BankAccount account = new BankAccount();
        bankAccounts.put(account.getId(), account);
        System.out.println(account.newID());
    }
    private static void depositFunds (HashMap<Integer, BankAccount> bankAccounts, int id, int amount) {
        if (bankAccounts.containsKey(id)) {
            bankAccounts.get(id).deposit(amount);
            System.out.println(bankAccounts.get(id).newDeposit(amount));
        } else {
            System.out.println("Account does not exist");
        }
    }
    private static void setInterest (double interest) {
        BankAccount.setInterestRate(interest);
    }
    private static void getInterest (HashMap<Integer, BankAccount> bankAccounts, int id, int years) {
        if (bankAccounts.containsKey(id)) {
            System.out.printf("%.2f%n", bankAccounts.get(id).getInterestRate(years));
        } else {
            System.out.println("Account does not exist");
        }
    }
}
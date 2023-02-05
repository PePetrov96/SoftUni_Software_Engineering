import java.util.Scanner;

public class Task_4_Password_Validator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String pass = scan.nextLine();
        if (!characterLength(pass)) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!lettersAndDigits(pass)) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (!digitCount(pass)) {
            System.out.println("Password must have at least 2 digits");
        }
        if (characterLength(pass) && lettersAndDigits(pass) && digitCount(pass)) {
            System.out.println("Password is valid");
        }
    }

    public static boolean characterLength (String pass) {
        boolean isLength = true;
        if (pass.length() < 6 || pass.length() > 10) {
            isLength = false;
        }
        return isLength;
    }

    public static boolean lettersAndDigits (String pass) {
        boolean noSymbol = true;
        for (int i = 0; i < pass.length(); i++) {
            if (pass.charAt(i) < 48 || pass.charAt(i) > 57 && pass.charAt(i) < 65 || pass.charAt(i) > 90 && pass.charAt(i) < 97 || pass.charAt(i) > 122) {
                noSymbol = false;
                break;
            }
        }
        return noSymbol;
    }

    public static boolean digitCount (String pass) {
        int count = 0;
        boolean isEnoughDigits = false;
        for (int i = 0; i < pass.length(); i++) {
            if (pass.charAt(i) >= 48 && pass.charAt(i) <= 57) {
                count++;
            }
            if (count >= 2) {
                isEnoughDigits = true;
                break;
            }
        }
        return isEnoughDigits;
    }
}
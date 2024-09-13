import java.util.Scanner;

public class PasswordStrengthCheck {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Prompt user to enter a password
        System.out.print("Enter the password: ");
        String pw = input.nextLine();
        
        // Check the strength of the password
        int strength = checkPasswordStrength(pw);
        
        // Display the strength of the password
        switch (strength) {
            case 0:
                System.out.println("Password is very weak");
                break;
            case 1:
                System.out.println("Password is weak");
                break;
            case 2:
                System.out.println("Password is medium");
                break;
            case 3:
                System.out.println("Password is strong");
                break;
            case 4:
                System.out.println("Password is very strong");
                break;
            default:
                System.out.println("Password strength is unknown");
                break;
        }
        
        // Estimate and display the crack time
        estimateCrackTime(strength);
        
        input.close();
    }
    
    // Method to check the strength of the password
    public static int checkPasswordStrength(String pw) {
        int strength = 0;

        if (pw.length() >= 8) {
            strength++;
        }
        if (pw.matches(".*\\d.*")) {
            strength++;
        }
        if (pw.matches(".*[A-Z].*")) {
            strength++;
        }
        if (pw.matches(".*[a-z].*")) {
            strength++;
        }
        if (pw.matches(".*[!@#$%^&()_+-;:<>,./?].*")) {
            strength++;
        }

        return strength;
    }
    
    // Method to estimate the time to crack the password
    public static void estimateCrackTime(int strength) {
        switch (strength) {
            case 0:
                System.out.println("The crack time will be within a day.");
                break;
            case 1:
                System.out.println("The crack time will be around 3 days.");
                break;
            case 2:
                System.out.println("The crack time will be around 7 days.");
                break;
            case 3:
                System.out.println("The crack time will be around 2 years.");
                break;
            case 4:
                System.out.println("The crack time will be around 50 years.");
                break;
            default:
                System.out.println("The crack time is unknown.");
                break;
        }
    }
}
import java.util.Scanner;

 class PasswordStrength {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        // Check each character
        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } 
            else if (Character.isLowerCase(ch)) {
                hasLower = true;
            } 
            else if (Character.isDigit(ch)) {
                hasDigit = true;
            } 
            else {
                hasSpecial = true;
            }
        }

        // Count validation rules
        int score = 0;

        if (password.length() >= 8) {
            score++;
        }

        if (hasUpper) {
            score++;
        }

        if (hasLower) {
            score++;
        }

        if (hasDigit) {
            score++;
        }

        if (hasSpecial) {
            score++;
        }

        // Display result
        System.out.println();
        System.out.println("Password Score: " + score + "/5");

        if (score == 5) {
            System.out.println("Password Strength: Strong");
        } 
        else if (score >= 3) {
            System.out.println("Password Strength: Medium");
        } 
        else {
            System.out.println("Password Strength: Weak");
        }

        // Display missing rules
        System.out.println();
        System.out.println("Validation:");

        System.out.println("Minimum 8 characters: "
                + (password.length() >= 8 ? "PASS" : "FAIL"));

        System.out.println("Uppercase letter: "
                + (hasUpper ? "PASS" : "FAIL"));

        System.out.println("Lowercase letter: "
                + (hasLower ? "PASS" : "FAIL"));

        System.out.println("Number: "
                + (hasDigit ? "PASS" : "FAIL"));

        System.out.println("Special character: "
                + (hasSpecial ? "PASS" : "FAIL"));

        sc.close();
    }
}
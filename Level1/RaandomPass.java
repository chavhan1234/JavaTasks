import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PasswordGenerator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SecureRandom random = new SecureRandom();

        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String special = "!@#$%^&*";

        ArrayList<Character> password = new ArrayList<>();
        String allCharacters = "";

        System.out.print("Enter password length: ");
        int length = sc.nextInt();

        System.out.print("Include uppercase letters? (y/n): ");
        String upperChoice = sc.next();

        System.out.print("Include lowercase letters? (y/n): ");
        String lowerChoice = sc.next();

        System.out.print("Include numbers? (y/n): ");
        String numberChoice = sc.next();

        System.out.print("Include special characters? (y/n): ");
        String specialChoice = sc.next();

        // Add at least one character from each selected category
        if (upperChoice.equalsIgnoreCase("y")) {
            password.add(uppercase.charAt(random.nextInt(uppercase.length())));
            allCharacters += uppercase;
        }

        if (lowerChoice.equalsIgnoreCase("y")) {
            password.add(lowercase.charAt(random.nextInt(lowercase.length())));
            allCharacters += lowercase;
        }

        if (numberChoice.equalsIgnoreCase("y")) {
            password.add(numbers.charAt(random.nextInt(numbers.length())));
            allCharacters += numbers;
        }

        if (specialChoice.equalsIgnoreCase("y")) {
            password.add(special.charAt(random.nextInt(special.length())));
            allCharacters += special;
        }

        if (allCharacters.isEmpty()) {
            System.out.println("Please select at least one character type.");
            sc.close();
            return;
        }

        if (length < password.size()) {
            System.out.println("Password length is too short for your selected options.");
            sc.close();
            return;
        }

        // Fill remaining characters
        while (password.size() < length) {
            password.add(
                allCharacters.charAt(
                    random.nextInt(allCharacters.length())
                )
            );
        }

        // Shuffle password so required characters are not predictable
        Collections.shuffle(password, random);

        StringBuilder result = new StringBuilder();

        for (char ch : password) {
            result.append(ch);
        }

        System.out.println("Generated Password: " + result);

        sc.close();
    }
}
import java.io.*;
import java.util.Scanner;

public class FileEncryption {

    // Encrypt / Decrypt using character shifting
    public static String processText(String text, int key) {
        StringBuilder result = new StringBuilder();

        for (char ch : text.toCharArray()) {
            result.append((char) (ch ^ key));
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Read original file
            FileReader reader = new FileReader("input.txt");
            StringBuilder text = new StringBuilder();

            int ch;
            while ((ch = reader.read()) != -1) {
                text.append((char) ch);
            }
            reader.close();

            System.out.print("Enter encryption key: ");
            int key = sc.nextInt();

            // Encrypt
            String encrypted = processText(text.toString(), key);

            FileWriter encryptedFile = new FileWriter("encrypted.txt");
            encryptedFile.write(encrypted);
            encryptedFile.close();

            System.out.println("File encrypted successfully!");

            // Decrypt
            String decrypted = processText(encrypted, key);

            FileWriter decryptedFile = new FileWriter("decrypted.txt");
            decryptedFile.write(decrypted);
            decryptedFile.close();

            System.out.println("File decrypted successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
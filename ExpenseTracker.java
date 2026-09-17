import java.io.*;
import java.util.Scanner;

public class ExpenseTracker {

    static final String FILE_NAME = "expenses.txt";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Personal Expense Tracker =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Total Expenses");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addExpense(sc);
                    break;

                case 2:
                    viewExpenses();
                    break;

                case 3:
                    totalExpenses();
                    break;

                case 4:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Add expense
    static void addExpense(Scanner sc) {

        System.out.print("Enter expense name: ");
        String name = sc.nextLine();

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {

            fw.write(name + "," + amount + "\n");

            System.out.println("Expense added successfully!");

        } catch (IOException e) {
            System.out.println("Error while saving expense.");
        }
    }

    // View expenses
    static void viewExpenses() {

        try (BufferedReader br = new BufferedReader(
                new FileReader(FILE_NAME))) {

            String line;

            System.out.println("\n----- Expenses -----");

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                System.out.println(
                        "Name: " + data[0] +
                        " | Amount: ₹" + data[1]
                );
            }

        } catch (FileNotFoundException e) {

            System.out.println("No expenses found.");

        } catch (IOException e) {

            System.out.println("Error while reading file.");
        }
    }

    // Calculate total
    static void totalExpenses() {

        double total = 0;

        try (BufferedReader br = new BufferedReader(
                new FileReader(FILE_NAME))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                total += Double.parseDouble(data[1]);
            }

            System.out.println("Total Expenses: ₹" + total);

        } catch (FileNotFoundException e) {

            System.out.println("No expenses found.");

        } catch (IOException e) {

            System.out.println("Error while reading file.");
        }
    }
}
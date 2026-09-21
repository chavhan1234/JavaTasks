import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    boolean available;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    void displayBook() {
        System.out.println(
                id + " | " + title + " | " + author +
                " | " + (available ? "Available" : "Issued")
        );
    }
}

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add book
    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));

        System.out.println("Book added successfully!");
    }

    // Display books
    static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\nID | Title | Author | Status");
        System.out.println("----------------------------------------");

        for (Book book : books) {
            book.displayBook();
        }
    }

    // Issue book
    static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();

        for (Book book : books) {
            if (book.id == id) {

                if (book.available) {
                    book.available = false;
                    System.out.println("Book issued successfully!");
                } else {
                    System.out.println("Book is already issued.");
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }

    // Return book
    static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();

        for (Book book : books) {
            if (book.id == id) {

                if (!book.available) {
                    book.available = true;
                    System.out.println("Book returned successfully!");
                } else {
                    System.out.println("Book is already available.");
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }

    // Main menu
    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    displayBooks();
                    break;

                case 3:
                    issueBook();
                    break;

                case 4:
                    returnBook();
                    break;

                case 5:
                    System.out.println("Thank you for using Library Management System!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
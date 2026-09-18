import java.util.ArrayList;
import java.util.Scanner;

class Contact {

    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    void displayContact() {
        System.out.println("Name  : " + name);
        System.out.println("Phone : " + phone);
        System.out.println("Email : " + email);
        System.out.println("----------------------");
    }
}

public class ContactManagementSystem {

    static ArrayList<Contact> contacts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== Contact Management System =====");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addContact();
                    break;

                case 2:
                    viewContacts();
                    break;

                case 3:
                    searchContact();
                    break;

                case 4:
                    deleteContact();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Add Contact
    static void addContact() {

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter phone: ");
        String phone = sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        Contact contact = new Contact(name, phone, email);

        contacts.add(contact);

        System.out.println("Contact added successfully!");
    }

    // View Contacts
    static void viewContacts() {

        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        System.out.println("\n----- Contact List -----");

        for (Contact contact : contacts) {
            contact.displayContact();
        }
    }

    // Search Contact
    static void searchContact() {

        System.out.print("Enter name to search: ");
        String searchName = sc.nextLine();

        boolean found = false;

        for (Contact contact : contacts) {

            if (contact.name.equalsIgnoreCase(searchName)) {
                contact.displayContact();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    // Delete Contact
    static void deleteContact() {

        System.out.print("Enter name to delete: ");
        String deleteName = sc.nextLine();

        for (Contact contact : contacts) {

            if (contact.name.equalsIgnoreCase(deleteName)) {

                contacts.remove(contact);

                System.out.println("Contact deleted successfully!");
                return;
            }
        }

        System.out.println("Contact not found.");
    }
}
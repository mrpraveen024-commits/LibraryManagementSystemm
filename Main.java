import java.util.Scanner;

public class Main {

    static String[] books = new String[10];
    static boolean[] issued = new boolean[10];
    static int count = 0;

    public static void addBook(String bookName) {
        if (count >= books.length) {
            System.out.println("Library is full!");
            return;
        }

        books[count] = bookName;
        issued[count] = false;
        count++;

        System.out.println("Book Added Successfully!");
    }

    public static void viewBooks() {
        if (count == 0) {
            System.out.println("No Books Available!");
            return;
        }

        System.out.println("\nLibrary Books:");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + books[i]
                    + (issued[i] ? " (Issued)" : " (Available)"));
        }
    }

    public static void searchBook(String bookName) {
        for (int i = 0; i < count; i++) {
            if (books[i].equalsIgnoreCase(bookName)) {
                System.out.println("Book Found: " + books[i]);
                return;
            }
        }

        System.out.println("Book Not Found!");
    }

    public static void issueBook(String bookName) {
        for (int i = 0; i < count; i++) {
            if (books[i].equalsIgnoreCase(bookName)) {

                if (issued[i]) {
                    System.out.println("Book Already Issued!");
                } else {
                    issued[i] = true;
                    System.out.println("Book Issued Successfully!");
                }

                return;
            }
        }

        System.out.println("Book Not Found!");
    }

    public static void returnBook(String bookName) {
        for (int i = 0; i < count; i++) {
            if (books[i].equalsIgnoreCase(bookName)) {

                if (issued[i]) {
                    issued[i] = false;
                    System.out.println("Book Returned Successfully!");
                } else {
                    System.out.println("Book Was Not Issued!");
                }

                return;
            }
        }

        System.out.println("Book Not Found!");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book Name: ");
                    String bookToAdd = sc.nextLine();
                    addBook(bookToAdd);
                    break;

                case 2:
                    viewBooks();
                    break;

                case 3:
                    System.out.print("Enter Book Name: ");
                    String bookToSearch = sc.nextLine();
                    searchBook(bookToSearch);
                    break;

                case 4:
                    System.out.print("Enter Book Name: ");
                    String bookToIssue = sc.nextLine();
                    issueBook(bookToIssue);
                    break;

                case 5:
                    System.out.print("Enter Book Name: ");
                    String bookToReturn = sc.nextLine();
                    returnBook(bookToReturn);
                    break;

                case 6:
                    System.out.println("Thank You!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
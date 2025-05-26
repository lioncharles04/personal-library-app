import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library myLibrary = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to your Personal Library!");

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a book");
            System.out.println("2. Show all books");
            System.out.println("3. Save library to file");
            System.out.println("4. Load library from file");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    myLibrary.addBook(title, author);
                    System.out.println("Book added!");
                    break;
                case "2":
                    myLibrary.showBooks();
                    break;
                case "3":
                    myLibrary.saveToFile("library.txt");
                    break;
                case "4":
                    myLibrary.loadFromFile("library.txt");
                    break;
                case "5":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(String title, String author) {
        books.add(new Book(title, author));
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("Your library is empty.");
        } else {
            System.out.println("Books in your library:");
            for (int i = 0; i < books.size(); i++) {
                System.out.println((i + 1) + ". " + books.get(i));
            }
        }
    }

    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Book book : books) {
                writer.write(book.getTitle() + "," + book.getAuthor());
                writer.newLine();
            }
            System.out.println("Library saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving library: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        books.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 2);
                if (parts.length == 2) {
                    addBook(parts[0].trim(), parts[1].trim());
                }
            }
            System.out.println("Library loaded from " + filename);
        } catch (IOException e) {
            System.out.println("Error loading library: " + e.getMessage());
        }
    }

    public List<Book> getBooks() {
        return books;
    }
}

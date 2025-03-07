import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Book class representing a library book
class Book {
    private final String title;
    private boolean available;

    public Book(String title, boolean available) {
        this.title = title;
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public synchronized void borrow() {
        available = false;
    }

    public synchronized void returnBook() {
        available = true;
    }

    @Override
    public String toString() {
        return title + "," + available;
    }

    public static Book fromString(String line) {
        String[] parts = line.split(",");
        return new Book(parts[0], Boolean.parseBoolean(parts[1]));
    }
}

// Custom exception for unavailable books
class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

// Library class to manage books
class Library {
    private final List<Book> books;
    private final String FILE_NAME = "books.txt";
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public Library() {
        books = loadBooks();
        if (books.isEmpty()) {
            addDefaultBooks();
        }
    }

    private void addDefaultBooks() {
        books.addAll(Arrays.asList(
                new Book("Game of Thrones", true),
                new Book("OOPS Concepts", true),
                new Book("UI/UX Design Principles", true)
        ));
        saveBooks();
    }

    private List<Book> loadBooks() {
        List<Book> bookList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                bookList.add(Book.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("No existing book data found. Creating a new File Library.");
        }
        return bookList;
    }

    private void saveBooks() {
        executor.submit(() -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
                for (Book book : books) {
                    writer.write(book.toString());
                    writer.newLine();
                }
            } catch (IOException e) {
                System.out.println("Error saving books.");
            }
        });
    }

    public void addBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book already exists in the library.");
                return;
            }
        }
        books.add(new Book(title, true));
        saveBooks();
        System.out.println("Book added: " + title);
        displayAvailableBooks();
    }

    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                book.borrow();
                saveBooks();
                System.out.println("You borrowed: " + title);
                displayAvailableBooks();
                return;
            }
        }
        System.out.println("Book not available.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isAvailable()) {
                book.returnBook();
                saveBooks();
                System.out.println("You returned: " + title);
                displayAvailableBooks();
                return;
            }
        }
        System.out.println("Book not found or already returned.");
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println("- " + book.getTitle());
            }
        }
    }

    public void shutdown() {
        executor.shutdown();
    }
}

// Main class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Display Books\n2. Add Book\n3. Borrow Book\n4. Return Book\n5. Exit");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> library.displayAvailableBooks();
                case 2 -> {
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine().trim();
                    library.addBook(title);
                }
                case 3 -> {
                    System.out.print("Enter book title to borrow: ");
                    String title = scanner.nextLine().trim();
                    library.borrowBook(title);
                }
                case 4 -> {
                    System.out.print("Enter book title to return: ");
                    String title = scanner.nextLine().trim();
                    library.returnBook(title);
                }
                case 5 -> {
                    library.shutdown();
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}

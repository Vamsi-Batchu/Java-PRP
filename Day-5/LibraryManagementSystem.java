import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

// Custom Exception for Unavailable Books
class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

// Book class representing a library book
class Book {
    private String title;
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

    public synchronized void borrow() throws BookNotAvailableException {
        if (!available) {
            throw new BookNotAvailableException("Book '" + title + "' is currently not available.");
        }
        available = false;
    }

    public synchronized void returnBook() {
        available = true;
    }

    // Convert Book to CSV format
    public String toCSV() {
        return title + "," + available;
    }

    // Create a Book object from a CSV line
    public static Book fromCSV(String line) {
        String[] parts = line.split(",");
        return new Book(parts[0].trim(), Boolean.parseBoolean(parts[1].trim()));
    }
}

// Library class to manage books using CSV file
class Library {
    private final List<Book> books = new ArrayList<>();
    private final String CSV_FILE = "books.csv";
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public Library() {
        books.addAll(loadBooks());
        if (books.isEmpty()) {
            addDefaultBooks();
        }
    }

    // Add default books when CSV is empty
    private void addDefaultBooks() {
        books.addAll(Arrays.asList(
                new Book("Game of Thrones", true),
                new Book("OOPS Concepts", true),
                new Book("UI/UX Design Principles", true)
        ));
        saveBooks();
    }

    // Load books from CSV file
    private List<Book> loadBooks() {
        List<Book> bookList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            bookList = reader.lines().map(Book::fromCSV).collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("No existing book data found. Creating a new CSV Library.");
        }
        return bookList;
    }

    // Save books to CSV file asynchronously
    private void saveBooks() {
        executor.submit(() -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE))) {
                for (Book book : books) {
                    writer.write(book.toCSV());
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
            if (book.getTitle().equalsIgnoreCase(title)) {
                try {
                    book.borrow();
                    saveBooks();
                    System.out.println("You borrowed: " + title);
                    displayAvailableBooks();
                    return;
                } catch (BookNotAvailableException e) {
                    System.out.println(e.getMessage()); // Show error if book is unavailable
                    return;
                }
            }
        }
        System.out.println("Book not found in the library.");
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
        System.out.println("\nLibrary Books");
        System.out.println("------------------------");
        books.forEach(book -> {
            String status = book.isAvailable() ? "Available" : "Borrowed";
            System.out.println(book.getTitle() + " - " + status);
        });
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
                    System.out.println("Exiting Library System...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option. \n");
            }
        }
    }
}

import java.util.Scanner;
import java.util.ArrayList;

class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean isAvailable;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailable = true; // New books are initially available
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrowBook() {
        isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN + ", Available: " + (isAvailable ? "Yes" : "No");
    }
}

class Library {
    private ArrayList<Book> inventory = new ArrayList<>();

    public void addBook(String title, String author, String ISBN) {
        inventory.add(new Book(title, author, ISBN));
    }

    public void borrowBook(String ISBN) {
        for (Book book : inventory) {
            if (book.getISBN().equals(ISBN)) {
                if (book.isAvailable()) {
                    book.borrowBook();
                    System.out.println("You have successfully borrowed the book.");
                    return;
                } else {
                    System.out.println("Sorry, the book is currently unavailable.");
                    return;
                }
            }
        }
        System.out.println("No book found with the provided ISBN.");
    }

    public void returnBook(String ISBN) {
        for (Book book : inventory) {
            if (book.getISBN().equals(ISBN)) {
                if (!book.isAvailable()) {
                    book.returnBook();
                    System.out.println("You have successfully returned the book.");
                    return;
                } else {
                    System.out.println("You cannot return a book that you didn't borrow.");
                    return;
                }
            }
        }
        System.out.println("No book found with the provided ISBN.");
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : inventory) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        library.addBook("The Great Gatsby", "Amit Garg", "9780743273565");
        library.addBook("Irrfan Khan: A Life in Movies", "Shubhra Gupta", "9780061120084");
        library.addBook("Ambedkar: A Life", "Shashi Tharoor", "9780451524935");
        library.addBook("Jadunama", "Javed Akhtar", "9780451327356");

        while (true) {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Borrow a Book");
            System.out.println("2. Return a Book");
            System.out.println("3. View Available Books");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the ISBN of the book you want to borrow: ");
                    String borrowISBN = scanner.nextLine();
                    library.borrowBook(borrowISBN);
                    break;
                case 2:
                    System.out.print("Enter the ISBN of the book you want to return: ");
                    String returnISBN = scanner.nextLine();
                    library.returnBook(returnISBN);
                    break;
                case 3:
                    library.displayAvailableBooks();
                    break;
                case 4:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}

import java.util.*;
class Book {
    protected String bookId, title, author, genre;
    protected boolean isAvailable;

    public Book(String bookId, String title, String author, String genre) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = true;
    }

    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailability(boolean status) { this.isAvailable = status; }

    public void displayDetails() {
        System.out.println("[" + bookId + "] " + title + " by " + author + " (" + genre + ") " + (isAvailable ? "Available" : "Borrowed"));
    }
}
class FictionBook extends Book {
    public FictionBook(String bookId, String title, String author) {
        super(bookId, title, author, "Fiction");
    }
    @Override
    public void displayDetails() {
        System.out.println("[Fiction] " + title + " by " + author + " (" + bookId + ") " + (isAvailable ? "Available" : "Borrowed"));
    }
}
class NonFictionBook extends Book {
    public NonFictionBook(String bookId, String title, String author) {
        super(bookId, title, author, "Non-Fiction");
    }
    @Override
    public void displayDetails() {
        System.out.println("[Non-Fiction] " + title + " by " + author + " (" + bookId + ") " + (isAvailable ? "Available" : "Borrowed"));
    }
}
class User {
    private String userId, name;
    private List<Book> borrowedBooks;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getUserId() { return userId; }
    public String getName() { return name; }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.setAvailability(false);
            System.out.println(name + " borrowed " + book.getTitle());
        } else {
            System.out.println("Sorry, this book is already borrowed.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setAvailability(true);
            System.out.println(name + " returned " + book.getTitle());
        } else {
            System.out.println("You haven't borrowed this book.");
        }
    }
}
class Catalog {
    private List<Book> books;

    public Catalog() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the catalog.");
            return;
        }
        System.out.println("\nLibrary Catalog:");
        for (Book book : books) {
            book.displayDetails();
        }
    }

    public Book findBookById(String bookId) {
        for (Book book : books) {
            if (book.getBookId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }
}
public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Catalog catalog = new Catalog();
        Map<String, User> users = new HashMap<>();

        while (true) {
            System.out.println("\n1. Add Book\n2. Add User\n3. Borrow Book\n4. Return Book\n5. Display Catalog\n6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter genre (Fiction/Non-Fiction): ");
                    String genre = scanner.nextLine();

                    if (genre.equalsIgnoreCase("Fiction")) {
                        catalog.addBook(new FictionBook(bookId, title, author));
                    } else {
                        catalog.addBook(new NonFictionBook(bookId, title, author));
                    }
                    break;

                case 2:
                    System.out.print("Enter user ID: ");
                    String userId = scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    users.put(userId, new User(userId, name));
                    System.out.println("User added: " + name);
                    break;

                case 3:
                    catalog.displayBooks();
                    System.out.print("Enter user ID: ");
                    userId = scanner.nextLine();
                    User user = users.get(userId);
                    if (user != null) {
                        System.out.print("Enter book ID to borrow: ");
                        bookId = scanner.nextLine();
                        Book bookToBorrow = catalog.findBookById(bookId);
                        if (bookToBorrow != null) {
                            user.borrowBook(bookToBorrow);
                        } else {
                            System.out.println("Book not found.");
                        }
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 4:
                    catalog.displayBooks();
                    System.out.print("Enter user ID: ");
                    userId = scanner.nextLine();
                    user = users.get(userId);
                    if (user != null) {
                        System.out.print("Enter book ID to return: ");
                        bookId = scanner.nextLine();
                        Book bookToReturn = catalog.findBookById(bookId);
                        if (bookToReturn != null) {
                            user.returnBook(bookToReturn);
                        } else {
                            System.out.println("Book not found.");
                        }
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 5:
                    catalog.displayBooks();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}


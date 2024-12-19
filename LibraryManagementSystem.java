import java.util.ArrayList;

// Book class
class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    // Constructor
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true; // Book is available by default
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Method to borrow the book
    public void borrow() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("You have borrowed: " + title);
        } else {
            System.out.println("Sorry, " + title + " is currently not available.");
        }
    }

    // Method to return the book
    public void returnBook() {
        isAvailable = true;
        System.out.println("You have returned: " + title);
    }
}

// Patron class
class Patron {
    private String name;
    private String patronId;

    // Constructor
    public Patron(String name, String patronId) {
        this.name = name;
        this.patronId = patronId;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPatronId() {
        return patronId;
    }
}

// Library class
class Library {
    private ArrayList<Book> books;
    private ArrayList<Patron> patrons;

    // Constructor
    public Library() {
        books = new ArrayList<>();
        patrons = new ArrayList<>();
    }

    // Method to add a book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added book: " + book.getTitle());
    }

    // Method to add a patron
    public void addPatron(Patron patron) {
        patrons.add(patron);
        System.out.println("Added patron: " + patron.getName());
    }

    // Method to borrow a book
    public void borrowBook(String isbn, Patron patron) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                book.borrow();
                return;
            }
        }
        System.out.println("Book with ISBN " + isbn + " not found.");
    }

    // Method to return a book
    public void returnBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                book.returnBook();
                return;
            }
        }
        System.out.println("Book with ISBN " + isbn + " not found.");
    }
}

// App class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Create a library
        Library library = new Library();

        // Create books
        Book book1 = new Book("1984", "George Orwell", "123456789");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "987654321");

        // Add books to the library
        library.addBook(book1);
        library.addBook(book2);

        // Create patrons
        Patron patron1 = new Patron("Alice", "P001");
        Patron patron2 = new Patron("Bob", "P002");

        // Add patrons to the library
        library.addPatron(patron1);
        library.addPatron(patron2);

        // Simulate borrowing and returning books
        library.borrowBook("123456789", patron1); // Alice borrows 1984
        library.borrowBook("123456789", patron2); // Bob tries to borrow 1984
        library.returnBook("123456789"); // Return 1984
        library.borrowBook("987654321", patron2); // Bob borrows To Kill a Mockingbird
    }
}
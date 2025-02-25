## Overview
The **JavaLibraryPro** is a Java-based application that allows users to manage a collection of books, borrow and return books, and maintain a user database. It follows Object-Oriented Programming (OOP) principles and utilizes Java collections.

## Features
- Add books to the catalog (Fiction & Non-Fiction categories)
- Add users to the system
- Borrow books (Only if available)
- Return borrowed books
- Display the catalog with book details
- Simple command-line interface for easy interaction

## Technologies Used
- **Java** (Object-Oriented Programming)
- **Collections Framework** (ArrayList, HashMap)
- **Scanner Class** (User Input Handling)

## How to Run
1. **Clone the Repository**:
   ```sh
   git clone https://github.com/your-username/library-catalog-system.git
   ```
2. **Navigate to the Project Directory**:
   ```sh
   cd library-catalog-system
   ```
3. **Compile the Java Code**:
   ```sh
   javac LibrarySystem.java
   ```
4. **Run the Application**:
   ```sh
   java LibrarySystem
   ```

## Usage Guide
Upon running the program, you will be prompted with a menu:

1. **Add Book** - Enter book details (ID, title, author, genre) to add to the catalog.
2. **Add User** - Register a user with a unique ID and name.
3. **Borrow Book** - Users can borrow an available book by entering the book ID.
4. **Return Book** - Users can return a borrowed book.
5. **Display Catalog** - View all books in the catalog along with their availability.
6. **Exit** - Close the application.

## Example Interaction
```
1. Add Book
Enter book ID: B001
Enter title: The Java Handbook
Enter author: Patrick Naughton
Enter genre (Fiction/Non-Fiction): Non-Fiction
Book added: The Java Handbook
```
```
2. Add User
Enter user ID: U123
Enter name: John Doe
User added: John Doe
```
```
3. Borrow Book
Enter user ID: U123
Enter book ID to borrow: B001
John Doe borrowed The Java Handbook
```

## Future Enhancements
- Implement a graphical user interface (GUI) using JavaFX or Swing.
- Add a database connection to store books and user data persistently.
- Implement user authentication for better security.
- Introduce book reservation functionality.

## Author
- **Faizan Anwar Khan**

## License
This project is open-source and available under the MIT License.



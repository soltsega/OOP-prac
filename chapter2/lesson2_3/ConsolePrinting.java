package chapter2.lesson2_3;

/**
 * 2.3.1. Printing to the Console
 * 
 * This lesson demonstrates different ways to print object information to the console
 */

public class ConsolePrinting {
    
    public static void main(String[] args) {
        System.out.println("=== 2.3.1. Printing to the Console ===\n");
        
        Book book = new Book("Effective Java", "Joshua Bloch", 2018);
        
        // 1. Direct printing of object (calls toString() method)
        System.out.println("1. Direct object print:");
        System.out.println(book);
        
        // 2. Explicit toString() call
        System.out.println("\n2. Explicit toString() call:");
        System.out.println(book.toString());
        
        // 3. Using System.out.printf for formatted output
        System.out.println("\n3. Formatted output with printf:");
        System.out.printf("Book: '%s' by %s (%d edition)%n", 
                         book.getTitle(), book.getAuthor(), book.getYear());
        
        // 4. Custom display method
        System.out.println("\n4. Custom display method:");
        book.displayDetails();
        
        // 5. Printing different data types
        System.out.println("\n5. Printing different data types:");
        printVariousTypes();
        
        // 6. String concatenation
        System.out.println("\n6. String concatenation:");
        String bookInfo = "Title: " + book.getTitle() + 
                         ", Author: " + book.getAuthor() + 
                         ", Year: " + book.getYear();
        System.out.println(bookInfo);
        
        // 7. Using StringBuilder for complex output
        System.out.println("\n7. StringBuilder for complex output:");
        StringBuilder sb = new StringBuilder();
        sb.append("📚 ").append(book.getTitle())
          .append("\n   by ").append(book.getAuthor())
          .append("\n   Published: ").append(book.getYear());
        System.out.println(sb.toString());
    }
    
    public static void printVariousTypes() {
        // Primitive types
        int number = 42;
        double price = 19.99;
        boolean available = true;
        char grade = 'A';
        
        System.out.println("Integer: " + number);
        System.out.println("Double: " + price);
        System.out.println("Boolean: " + available);
        System.out.println("Character: " + grade);
        
        // Object types
        String text = "Hello World";
        Integer objNumber = 100;
        
        System.out.println("String: " + text);
        System.out.println("Integer object: " + objNumber);
        
        // Arrays
        int[] numbers = {1, 2, 3, 4, 5};
        String[] words = {"Java", "Programming", "OOP"};
        
        System.out.println("Array (default): " + numbers);
        System.out.println("Array (Arrays.toString): " + java.util.Arrays.toString(numbers));
        System.out.println("String array: " + java.util.Arrays.toString(words));
    }
}

/**
 * Book class demonstrating different printing approaches
 */
class Book {
    private String title;
    private String author;
    private int year;
    
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
    
    // Override toString() for custom string representation
    @Override
    public String toString() {
        return "Book[title=" + title + ", author=" + author + ", year=" + year + "]";
    }
    
    // Custom display method with special formatting
    public void displayDetails() {
        System.out.println("📚 " + title + " by " + author + " (" + year + ")");
    }
    
    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
}

/**
 * Key Points for Console Printing:
 * 
 * 1. System.out.println() - Prints with new line
 * 2. System.out.print() - Prints without new line
 * 3. System.out.printf() - Formatted printing with placeholders
 * 4. toString() - Default method called when printing objects
 * 5. String concatenation - Using + operator
 * 6. StringBuilder - Efficient for complex string building
 * 7. Arrays.toString() - Proper array printing
 * 
 * Format Specifiers for printf():
 * %s - String
 * %d - Integer
 * %f - Floating point
 * %b - Boolean
 * %c - Character
 * %n - Platform-independent new line
 */

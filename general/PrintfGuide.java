package general;
// Java printf() Method - Complete Guide

public class PrintfGuide {
    public static void main(String[] args) {
        System.out.println("=== JAVA printf() METHOD GUIDE ===\n");
        
        // 1. BASIC printf() SYNTAX
        System.out.println("1. Basic printf() Syntax:");
        String name = "John";
        int age = 25;
        System.out.printf("Name: %s, Age: %d%n", name, age);
        System.out.println();
        
        // 2. COMMON FORMAT SPECIFIERS
        System.out.println("2. Common Format Specifiers:");
        
        // String formatting
        String city = "New York";
        System.out.printf("String: %s%n", city);
        
        // Integer formatting
        int number = 42;
        System.out.printf("Decimal: %d%n", number);
        
        // Floating point formatting
        double price = 19.99;
        System.out.printf("Float: %f%n", price);
        
        // Character formatting
        char grade = 'A';
        System.out.printf("Character: %c%n", grade);
        
        // Boolean formatting
        boolean isActive = true;
        System.out.printf("Boolean: %b%n", isActive);
        
        // Hexadecimal formatting
        int hexValue = 255;
        System.out.printf("Hexadecimal: %x%n", hexValue);
        System.out.printf("Hexadecimal (uppercase): %X%n", hexValue);
        
        // Octal formatting
        int octalValue = 8;
        System.out.printf("Octal: %o%n", octalValue);
        
        // Scientific notation
        double scientific = 12345.6789;
        System.out.printf("Scientific: %e%n", scientific);
        System.out.println();
        
        // 3. WIDTH AND PRECISION FORMATTING
        System.out.println("3. Width and Precision Formatting:");
        
        double pi = 3.14159265359;
        
        // Default float
        System.out.printf("Default: %f%n", pi);
        
        // 2 decimal places
        System.out.printf("2 decimals: %.2f%n", pi);
        
        // 4 decimal places
        System.out.printf("4 decimals: %.4f%n", pi);
        
        // Fixed width 10, 2 decimals
        System.out.printf("Width 10, 2 decimals: %10.2f%n", pi);
        
        // Left alignment
        System.out.printf("Left aligned: %-10.2f%n", pi);
        
        // Right alignment (default)
        System.out.printf("Right aligned: %10.2f%n", pi);
        System.out.println();
        
        // 4. STRING WIDTH AND ALIGNMENT
        System.out.println("4. String Width and Alignment:");
        
        String firstName = "John";
        String lastName = "Doe";
        String longName = "Alexander";
        
        // Fixed width columns
        System.out.printf("%-15s | %-15s | %s%n", "First Name", "Last Name", "Status");
        System.out.println("-----------------+-----------------+--------");
        System.out.printf("%-15s | %-15s | %s%n", firstName, lastName, "Active");
        System.out.printf("%-15s | %-15s | %s%n", longName, "Smith", "Inactive");
        System.out.println();
        
        // 5. NUMBER FORMATTING WITH COMMAS
        System.out.println("5. Number Formatting with Commas:");
        
        int largeNumber = 1234567;
        double largeDecimal = 1234567.89;
        
        System.out.printf("Integer with commas: %,d%n", largeNumber);
        System.out.printf("Decimal with commas: %,.2f%n", largeDecimal);
        System.out.println();
        
        // 6. ZERO PADDING
        System.out.println("6. Zero Padding:");
        
        int id = 42;
        int code = 7;
        
        System.out.printf("Zero padded: %05d%n", id);
        System.out.printf("Zero padded: %03d%n", code);
        System.out.println();
        
        // 7. POSITIVE/NEGATIVE SIGN
        System.out.println("7. Positive/Negative Sign:");
        
        int positive = 42;
        int negative = -42;
        
        System.out.printf("Always show sign: %+d%n", positive);
        System.out.printf("Always show sign: %+d%n", negative);
        System.out.printf("Space for positive: % d%n", positive);
        System.out.printf("Space for positive: % d%n", negative);
        System.out.println();
        
        // 8. DATE AND TIME FORMATTING
        System.out.println("8. Date and Time Formatting:");
        
        // Note: Date formatting requires java.time package (Java 8+)
        // Using traditional Date for simplicity
        java.util.Date now = new java.util.Date();
        
        System.out.printf("Current time: %tc%n", now);
        System.out.printf("Date only: %tD%n", now);
        System.out.printf("Time only: %tT%n", now);
        System.out.printf("Hour: %tH%n", now);
        System.out.printf("Minute: %tM%n", now);
        System.out.printf("Second: %tS%n", now);
        System.out.printf("Year: %tY%n", now);
        System.out.printf("Month: %tm%n", now);
        System.out.printf("Day: %td%n", now);
        System.out.println();
        
        // 9. MULTIPLE ARGUMENTS AND INDEXING
        System.out.println("9. Multiple Arguments and Indexing:");
        
        String product = "Laptop";
        double cost = 999.99;
        int quantity = 2;
        double total = cost * quantity;
        
        // Regular way
        System.out.printf("Product: %s, Cost: $%.2f, Quantity: %d, Total: $%.2f%n", 
                        product, cost, quantity, total);
        
        // Using argument indices (reusing arguments)
        System.out.printf("%1$s costs %2$.2f each. %1$s x %3$d = $%4$.2f%n", 
                        product, cost, quantity, total);
        System.out.println();
        
        // 10. ESCAPING PERCENT SIGN
        System.out.println("10. Escaping Percent Sign:");
        
        double discount = 25.0;
        double originalPrice = 100.0;
        double finalPrice = originalPrice * (1 - discount/100);
        
        System.out.printf("Discount: %.1f%% off%n", discount);
        System.out.printf("Original: $%.2f, Final: $%.2f%n", originalPrice, finalPrice);
        System.out.println();
        
        // 11. PRACTICAL EXAMPLES
        System.out.println("11. Practical Examples:");
        
        // Receipt formatting
        System.out.println("=== RECEIET ===");
        String item1 = "Coffee";
        double price1 = 3.50;
        int qty1 = 2;
        
        String item2 = "Sandwich";
        double price2 = 8.75;
        int qty2 = 1;
        
        System.out.printf("%-20s %5s %10s%n", "Item", "Qty", "Price");
        System.out.println("-------------------- ----- ----------");
        System.out.printf("%-20s %5d $%9.2f%n", item1, qty1, price1 * qty1);
        System.out.printf("%-20s %5d $%9.2f%n", item2, qty2, price2 * qty2);
        System.out.println("-------------------- ----- ----------");
        System.out.printf("%-20s %5s $%9.2f%n", "TOTAL", "", (price1 * qty1) + (price2 * qty2));
        System.out.println();
        
        // Student report card
        System.out.println("=== STUDENT REPORT CARD ===");
        String studentName = "Alice Johnson";
        double mathGrade = 92.5;
        double scienceGrade = 88.0;
        double englishGrade = 95.75;
        double average = (mathGrade + scienceGrade + englishGrade) / 3;
        
        System.out.printf("Student: %s%n", studentName);
        System.out.println("------------------------");
        System.out.printf("%-15s %8s%n", "Subject", "Grade");
        System.out.println("------------------------");
        System.out.printf("%-15s %8.1f%n", "Math", mathGrade);
        System.out.printf("%-15s %8.1f%n", "Science", scienceGrade);
        System.out.printf("%-15s %8.1f%n", "English", englishGrade);
        System.out.println("------------------------");
        System.out.printf("%-15s %8.1f%n", "Average", average);
        System.out.println();
        
        // 12. FORMATTING TABLES
        System.out.println("12. Formatting Tables:");
        
        System.out.printf("%-10s | %-8s | %-10s | %-12s | %-8s%n", 
                        "Product", "Price", "Category", "Description", "Stock");
        System.out.println("-----------|----------|------------|--------------|--------");
        System.out.printf("%-10s | $%-7.2f | %-10s | %-12s | %-8d%n", 
                        "Laptop", 999.99, "Electronics", "Gaming laptop", 15);
        System.out.printf("%-10s | $%-7.2f | %-10s | %-12s | %-8d%n", 
                        "Mouse", 29.99, "Electronics", "Wireless mouse", 50);
        System.out.printf("%-10s | $%-7.2f | %-10s | %-12s | %-8d%n", 
                        "Book", 19.99, "Books", "Programming", 100);
    }
}

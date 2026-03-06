package chapter2.lesson2_3;

/**
 * Comprehensive String Operations Guide
 * 
 * This lesson covers essential string operations in Java:
 * - String comparison methods
 * - Substring extraction
 * - String searching and manipulation
 * - Scanner class usage
 * - Switch statements with strings
 */

public class StringOperations {
    
    public static void main(String[] args) {
        System.out.println("=== Comprehensive String Operations ===\n");
        
        // 1. String comparison methods
        demonstrateStringComparison();
        
        // 2. Substring operations
        demonstrateSubstringOperations();
        
        // 3. String searching methods
        demonstrateStringSearching();
        
        // 4. Scanner class usage
        demonstrateScannerUsage();
        
        // 5. Enhanced switch statements
        demonstrateEnhancedSwitch();
        
        // 6. String manipulation methods
        demonstrateStringManipulation();
        
        // 7. String formatting
        demonstrateStringFormatting();
    }
    
    /**
     * 1. String Comparison Methods
     */
    public static void demonstrateStringComparison() {
        System.out.println("1. String Comparison Methods:");
        
        String str1 = "Hello";
        String str2 = "hello";
        String str3 = "Hello";
        String str4 = "HELLO";
        
        // .equals() - Case-sensitive comparison
        System.out.println(".equals() - Case-sensitive:");
        System.out.println("str1.equals(str2): " + str1.equals(str2)); // false
        System.out.println("str1.equals(str3): " + str1.equals(str3)); // true
        System.out.println("str1.equals(str4): " + str1.equals(str4)); // false
        
        // .equalsIgnoreCase() - Case-insensitive comparison
        System.out.println("\n.equalsIgnoreCase() - Case-insensitive:");
        System.out.println("str1.equalsIgnoreCase(str2): " + str1.equalsIgnoreCase(str2)); // true
        System.out.println("str1.equalsIgnoreCase(str3): " + str1.equalsIgnoreCase(str3)); // true
        System.out.println("str1.equalsIgnoreCase(str4): " + str1.equalsIgnoreCase(str4)); // true
        
        // .compareTo() - Lexicographical comparison
        System.out.println("\n.compareTo() - Lexicographical:");
        System.out.println("str1.compareTo(str2): " + str1.compareTo(str2)); // negative
        System.out.println("str2.compareTo(str1): " + str2.compareTo(str1)); // positive
        System.out.println("str1.compareTo(str3): " + str1.compareTo(str3)); // zero
        
        // .compareToIgnoreCase() - Case-insensitive lexicographical
        System.out.println("\n.compareToIgnoreCase():");
        System.out.println("str1.compareToIgnoreCase(str2): " + str1.compareToIgnoreCase(str2)); // zero
        
        // == operator vs .equals()
        System.out.println("\n== operator vs .equals():");
        String str5 = new String("Hello");
        System.out.println("str1 == str5: " + (str1 == str5)); // false (different objects)
        System.out.println("str1.equals(str5): " + str1.equals(str5)); // true (same content)
        
        System.out.println();
    }
    
    /**
     * 2. Substring Operations
     */
    public static void demonstrateSubstringOperations() {
        System.out.println("2. Substring Operations:");
        
        String text = "Hello World Programming";
        
        // substring(startIndex) - From startIndex to end
        System.out.println("Original: " + text);
        String sub1 = text.substring(6);
        System.out.println("substring(6): " + sub1); // "World Programming"
        
        // substring(startIndex, endIndex) - From startIndex to endIndex (exclusive)
        String sub2 = text.substring(6, 11);
        System.out.println("substring(6, 11): " + sub2); // "World"
        
        // Visual demonstration of indices
        System.out.println("\nIndex visualization:");
        System.out.println("String: " + text);
        System.out.println("Index:   012345678901234567890123456789");
        System.out.println("          ^         ^          ^");
        System.out.println("          0         10         20");
        
        // Common substring examples
        System.out.println("\nCommon examples:");
        String email = "user@example.com";
        String username = email.substring(0, email.indexOf('@'));
        String domain = email.substring(email.indexOf('@') + 1);
        System.out.println("Email: " + email);
        System.out.println("Username: " + username);
        System.out.println("Domain: " + domain);
        
        // Edge cases
        System.out.println("\nEdge cases:");
        try {
            String invalid = text.substring(30); // Index out of bounds
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * 3. String Searching Methods
     */
    public static void demonstrateStringSearching() {
        System.out.println("3. String Searching Methods:");
        
        String text = "Java Programming is Fun Programming";
        
        // .contains() - Checks if substring exists
        System.out.println("Text: " + text);
        System.out.println("contains('Java'): " + text.contains("Java")); // true
        System.out.println("contains('Python'): " + text.contains("Python")); // false
        
        // .indexOf() - Returns first occurrence index
        System.out.println("\n.indexOf():");
        System.out.println("indexOf('Program'): " + text.indexOf("Program")); // 5
        System.out.println("indexOf('Python'): " + text.indexOf("Python")); // -1 (not found)
        
        // .lastIndexOf() - Returns last occurrence index
        System.out.println("\n.lastIndexOf():");
        System.out.println("lastIndexOf('Program'): " + text.lastIndexOf("Program")); // 22
        
        // .startsWith() and .endsWith()
        System.out.println("\n.startsWith() and .endsWith():");
        System.out.println("startsWith('Java'): " + text.startsWith("Java")); // true
        System.out.println("endsWith('Programming'): " + text.endsWith("Programming")); // true
        
        // .replace() methods
        System.out.println("\n.replace() methods:");
        String replaced = text.replace("Programming", "Coding");
        System.out.println("replace('Programming', 'Coding'): " + replaced);
        
        String replacedAll = text.replaceAll("Prog\\w+", "Coding");
        System.out.println("replaceAll('Prog\\\\w+', 'Coding'): " + replacedAll);
        
        System.out.println();
    }
    
    /**
     * 4. Scanner Class Usage
     */
    public static void demonstrateScannerUsage() {
        System.out.println("4. Scanner Class Usage:");
        
        // Create scanner with sample input
        String sampleInput = "John 25 3.85 true Hello World";
        java.util.Scanner scanner = new java.util.Scanner(sampleInput);
        
        System.out.println("Sample input: " + sampleInput);
        System.out.println("Scanner operations:");
        
        // .next() - Reads next token (whitespace-separated)
        String name = scanner.next();
        System.out.println("next(): " + name); // "John"
        
        // .nextInt() - Reads next integer
        int age = scanner.nextInt();
        System.out.println("nextInt(): " + age); // 25
        
        // .nextDouble() - Reads next double
        double gpa = scanner.nextDouble();
        System.out.println("nextDouble(): " + gpa); // 3.85
        
        // .nextBoolean() - Reads next boolean
        boolean isActive = scanner.nextBoolean();
        System.out.println("nextBoolean(): " + isActive); // true
        
        // .nextLine() - Reads entire line
        String remaining = scanner.nextLine();
        System.out.println("nextLine(): " + remaining); // " Hello World"
        
        // Important: Scanner resource management
        System.out.println("\nScanner Resource Management:");
        System.out.println("Scanner should always be closed to prevent resource leaks");
        System.out.println("Use try-with-resources for automatic closing:");
        
        // Demonstrate try-with-resources
        try (java.util.Scanner autoCloseScanner = new java.util.Scanner("Auto close test")) {
            String word = autoCloseScanner.next();
            System.out.println("Auto-closed scanner read: " + word);
        } // Scanner automatically closed here
        
        // Manual closing
        scanner.close();
        System.out.println("Scanner manually closed");
        
        System.out.println();
    }
    
    /**
     * 5. Enhanced Switch Statements
     */
    public static void demonstrateEnhancedSwitch() {
        System.out.println("5. Enhanced Switch Statements:");
        
        // Traditional switch
        System.out.println("Traditional switch:");
        int day = 2;
        String dayName;
        switch (day) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            default:
                dayName = "Unknown";
                break;
        }
        System.out.println("Day " + day + " is " + dayName);
        
        // Enhanced switch (Java 14+)
        System.out.println("\nEnhanced switch:");
        String enhancedDayName = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4, 5 -> "Weekend prep";
            default -> "Unknown";
        };
        System.out.println("Enhanced: Day " + day + " is " + enhancedDayName);
        
        // Switch with strings
        System.out.println("\nSwitch with strings:");
        String command = "start";
        String result = switch (command.toLowerCase()) {
            case "start", "run", "execute" -> "Starting process";
            case "stop", "end", "terminate" -> "Stopping process";
            case "pause" -> "Pausing process";
            default -> "Unknown command";
        };
        System.out.println("Command '" + command + "': " + result);
        
        // Switch with expressions
        System.out.println("\nSwitch with complex expressions:");
        int score = 85;
        char grade = switch (score / 10) {
            case 10, 9 -> 'A';
            case 8 -> 'B';
            case 7 -> 'C';
            case 6 -> 'D';
            default -> 'F';
        };
        System.out.println("Score " + score + " gets grade " + grade);
        
        System.out.println();
    }
    
    /**
     * 6. String Manipulation Methods
     */
    public static void demonstrateStringManipulation() {
        System.out.println("6. String Manipulation Methods:");
        
        String text = "  hello world programming  ";
        
        // .trim() - Remove leading/trailing whitespace
        System.out.println("Original: '" + text + "'");
        System.out.println("trim(): '" + text.trim() + "'");
        
        // .toUpperCase() and .toLowerCase()
        System.out.println("toUpperCase(): " + text.trim().toUpperCase());
        System.out.println("toLowerCase(): " + text.trim().toLowerCase());
        
        // .length() - Get string length
        System.out.println("length(): " + text.length());
        System.out.println("trim().length(): " + text.trim().length());
        
        // .charAt() - Get character at index
        String word = "Java";
        System.out.println("\ncharAt() operations on '" + word + "':");
        for (int i = 0; i < word.length(); i++) {
            System.out.println("charAt(" + i + "): " + word.charAt(i));
        }
        
        // .split() - Split string into array
        String data = "John,25,3.85,Active";
        String[] parts = data.split(",");
        System.out.println("\nsplit(',') on '" + data + "':");
        for (int i = 0; i < parts.length; i++) {
            System.out.println("Part " + i + ": " + parts[i]);
        }
        
        // .join() - Join strings
        String joined = String.join("-", "2023", "12", "25");
        System.out.println("\nString.join('-', '2023', '12', '25'): " + joined);
        
        System.out.println();
    }
    
    /**
     * 7. String Formatting
     */
    public static void demonstrateStringFormatting() {
        System.out.println("7. String Formatting:");
        
        String name = "Alice";
        int age = 25;
        double gpa = 3.85;
        boolean active = true;
        
        // printf formatting
        System.out.println("printf formatting:");
        System.out.printf("Name: %s, Age: %d, GPA: %.2f, Active: %b%n", 
                         name, age, gpa, active);
        
        // String.format()
        String formatted = String.format("Student: %s (ID: %05d, GPA: %.1f)", 
                                       name, age, gpa);
        System.out.println("String.format(): " + formatted);
        
        // Number formatting
        double price = 1234.5678;
        System.out.printf("Price: $%.2f%n", price);
        System.out.printf("Scientific: %.2e%n", price);
        
        // Date formatting
        java.time.LocalDate date = java.time.LocalDate.now();
        System.out.printf("Date: %tF%n", date);
        
        System.out.println();
    }
}

/**
 * Key Points Summary:
 * 
 * 1. String Comparison:
 *    - .equals() for content comparison
 *    - .equalsIgnoreCase() for case-insensitive comparison
 *    - == for reference comparison (avoid for content)
 * 
 * 2. Substring:
 *    - substring(start) - from start to end
 *    - substring(start, end) - from start to end (exclusive)
 *    - endIndex is NOT inclusive
 * 
 * 3. Scanner Methods:
 *    - next() - next token (word)
 *    - nextInt() - next integer
 *    - nextDouble() - next double
 *    - nextLine() - entire line
 *    - Always close scanner (use try-with-resources)
 * 
 * 4. Enhanced Switch:
 *    - case value -> result (no break needed)
 *    - case v1, v2, v3 -> result (multiple values)
 *    - Can return values directly
 *    - More concise and readable
 */

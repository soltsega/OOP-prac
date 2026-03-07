package broCode;

public class miniProject {
    
}



// the Scanner class

/**
 * Scanner class
 * 
 * The Scanner class is used to read formatted input from various sources.
 * It provides methods to read primitive data types, strings, and other types.
 * 
 * Key methods:
 * - next() - reads the next token (whitespace-separated)
 * - nextInt() - reads the next integer
 * - nextDouble() - reads the next double
 * - nextBoolean() - reads the next boolean
 * - nextLine() - reads the entire line
 * 
 * Use try-with-resources to ensure Scanner is closed properly
 * 
 * Important: Always close Scanner to prevent resource leaks
 * 
 * Example usage:
 * 
 * import java.util.Scanner;
 * 
 * public class MyClass {
 *     public static void main(String[] args) {
 *         Scanner scanner = new Scanner(System.in);
 *         try {
 *             System.out.print("Enter your name: ");
 *             String name = scanner.nextLine();
 *             System.out.print("Enter your age: ");
 *             int age = scanner.nextInt();
 *             System.out.println("Hello " + name + ", you are " + age + " years old!");
 *         } finally {
 *             scanner.close();
 *         }
 *     }
 * }
 */


/**
 * Closing the Scanner object
 * 
 * When the Scanner object is closed, it releases the underlying input source,
 * such as System.in, so that it can be used again. Failure to close the Scanner
 * object can result in resource leaks, as the underlying input source may not
 * be available for other parts of the program to use.
 * 
 * It's important to close the Scanner object to release the resources it uses.
 * The best way to ensure that the Scanner object is closed is to use the
 * try-with-resources statement. This ensures that the Scanner object is
 * automatically closed when it is no longer needed, even if an exception occurs.
 * 
 * Example usage:
 * 
 * import java.util.Scanner;
 * 
 * public class MyClass {
 *     public static void main(String[] args) {
 *         try (Scanner scanner = new Scanner(System.in)) {
 *             // Use the scanner object here
 *         }
 *         // The scanner object is automatically closed here
 *     }
 * }
 * 
 * Closing System.in
 * 
 * System.in is the standard input stream, which is automatically closed when
 * the Java Virtual Machine (JVM) exits. Closing System.in is not necessary
 * because it is automatically closed when the JVM exits.
 * 
 * It's important to note that closing System.in is not possible in Java, as it
 * is a special input stream that is managed by the JVM.
 */

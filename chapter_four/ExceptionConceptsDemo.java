import java.util.Scanner;


/**
 * Notes on Java Methods:
 * 
 * 1. getCause(): Returns the cause of the exception, or null if the cause is nonexistent or unknown.
 * 2. printStackTrace(): Prints the throwable and its backtrace to the standard error stream.
 * 3. toString(): Returns a string containing a concise, human-readable description of this throwable.
 * 
 * The Throwable class and its subclasses control the flow of program execution if an exception is thrown.
 * 
 * The getCause() method is used to get the cause of the exception.
 * 
 * The printStackTrace() method is used to print the stack trace of the exception.
 * 
 * The toString() method is used to get a string representation of the exception.
 */
public class ExceptionConceptsDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Java Exception Concepts Demo");
            System.out.println("1. Show exception methods");
            System.out.println("2. Demonstrate manual throw");
            System.out.println("3. Demonstrate throws keyword");
            System.out.println("4. Demonstrate real arithmetic error");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showExceptionMethods();
                    break;
                case 2:
                    demonstrateManualThrow(true);
                    break;
                case 3:
                    demonstrateThrowsKeyword(-5);
                    break;
                case 4:
                    demonstrateRealArithmeticError();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
            printExceptionMethods(e);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
            printExceptionMethods(e);
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e.getMessage());
            printExceptionMethods(e);
        } finally {
            scanner.close();
            System.out.println("Program ended.");
        }
    }

    public static void showExceptionMethods() {
        try {
            throw new ArithmeticException("Intentional exception for method demo");
        } catch (ArithmeticException e) {
            printExceptionMethods(e);
        }
    }

    public static void printExceptionMethods(Exception e) {
        System.out.println("getMessage(): " + e.getMessage());
        System.out.println("toString(): " + e.toString());
        System.out.println("getClass(): " + e.getClass().getName());
        System.out.println("getCause(): " + e.getCause());
        System.out.println("printStackTrace():");
        e.printStackTrace();
    }

    public static void demonstrateManualThrow(boolean raiseError) {
        if (raiseError) {
            throw new ArithmeticException("Manual throw: intentional arithmetic error");
        }

        System.out.println("No error was raised.");
    }

    public static void demonstrateThrowsKeyword(int age) throws Exception {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }

        if (age < 18) {
            throw new Exception("Age must be 18 or older");
        }

        System.out.println("Age accepted: " + age);
    }

    public static void demonstrateRealArithmeticError() {
        int result = 10 / 0;
        System.out.println("Result: " + result);
    }
}

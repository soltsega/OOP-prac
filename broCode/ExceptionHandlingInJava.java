package broCode;

import java.util.Scanner;

/**
 * Exception Handling in Java:
 * 
 * Java provides a way to handle exceptions using the try-catch-finally block.
 * 
 * In Java, exceptions can be handled using try-catch-finally block.
 * The try block contains the code that may generate an exception.
 * The catch block is used to handle the exception.
 * The finally block is optional and is used to perform any necessary cleanup.
 * 
 * The catch block can have multiple exception type handlers.
 * The catch block can also have a default handler.
 * 
 * The exception type handlers are checked in the order they are written.
 * The first handler that matches the type of the exception will be executed.
 * 
 * The default handler is used if no other handler matches the type of the exception.
 * The default handler is specified using a generic type of Exception.
 * 
 * The finally block is always executed, even if an exception is thrown or not.
 * It is used for cleanup tasks such as closing resources.
 * 
 * It is important to handle exceptions to prevent the program from crashing.
 * Unhandled exceptions will cause the program to terminate.
 * 
 * The throws keyword is used to indicate that a method may throw an exception.
 * The calling method or the main method must handle the exception or also use the throws keyword.
 * 
 * The throws keyword can be used in the method signature of a method.
 * It is also used in the constructor of a class.
 * 
 * The throws keyword can be used with multiple exception types.
 * 
 * The throw keyword is used to explicitly throw an exception.
 * It is used in the catch block to rethrow the exception.
 * 
 * The try-with-resources statement is used to automatically close resources.
 * It is used with objects that implement the Closeable interface.
 * The try block is followed by a set of resources enclosed in parentheses.
 * The resources are closed automatically when the try block is exited.
 * 
 * The try-with-resources statement can be used with multiple resources.
 * 
 * It is important to handle exceptions appropriately to prevent the program from crashing.
 * Unhandled exceptions can make the program unstable and difficult to debug.
 * 
 * It is recommended to catch specific exceptions rather than the generic Exception class.
 * This allows the program to handle different types of exceptions differently.
 * 
 * It is also recommended to handle exceptions as early as possible to prevent them from propagating further.
 * This improves the program's efficiency and readability.
 * 
 */
public class ExceptionHandlingInJava {

    public static void main(){
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.print("Enter your input which is a number: ");
            int age = scanner.nextInt();
            System.out.println("your input is " + age);

        }catch(Exception e){  // Handles all the excetions but it is not recommended due to the fact that it does not epecify which is which.
        // you have to import the exceptions and call them by their names
            System.out.println("Please enter a valid input");
        }finally{
            scanner.close();
            System.out.println("This always executes");

        }
    }
    
}

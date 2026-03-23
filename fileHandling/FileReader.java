package fileHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A code snippet that demonstrates how to use the Java Reader method to read text from a file.
 * 
 * public static void main(String[] args) {
 *     // Create a FileReader object to read from a file
 *     try (FileReader reader = new FileReader("path/to/file.txt")) {
 *         // Create a buffer to store the text
 *         char[] buffer = new char[1024];
 *         // Read from the file into the buffer
 *         int numCharactersRead = reader.read(buffer);
 *         // Print the text from the file
 *         System.out.println(new String(buffer, 0, numCharactersRead));
 *     } catch (IOException e) {
 *         // Handle the exception if there was an error reading the file
 *         e.printStackTrace();
 *     }
 * }
 *  
 * - hasNextLine() - is used to check if there is a next line in the file to be read. It returns true if there is a next line, and false if there isn't.
 * - hasNext() - is used to check if there is a next token in the file to be read. It returns true if there is a next token, and false if there isn't.
 * - nextLine() - is used to read the next line in the file and store it in a String.
 * - next() - is used to read the next token in the file and store it in a String.
 * - nextInt() - is used to read the next integer in the file and store it in an int variable.
 * - nextDouble() - is used to read the next double in the file and store it in a double variable.
 * - nextBoolean() - is used to read the next boolean value in the file and store it in a boolean variable.

*/
public class FileReader {

    public static void main(String [] args){

    
    File myObj = new File("C:\\Users\\My Device\\Desktop\\OOP-prac\\fileHandling\\DemoFile.txt");

    // try-with-resources: Scanner will be closed automatically
    try (Scanner myReader = new Scanner(myObj)) {
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
      }
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
}
    
}

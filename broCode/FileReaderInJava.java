package broCode;

/**
 * Java FileReader class is used to read text files.
 * 
 * Syntax:
 * FileReader fr = new FileReader(file_path);
 * 
 * file_path: the path of the file to be read.
 * 
 * The FileReader class provides several methods to read text from a file.
 * 
 * 1. read():
 * Reads a single character from the file and returns it as an integer.
 * It returns -1 if the end of the file is reached.
 * 
 * 2. read(char[] cbuf):
 * Reads a specified number of characters from the file and stores them in the
 * character array cbuf.
 * It returns the number of characters read.
 * It returns -1 if the end of the file is reached.
 * 
 * 3. read(char[] cbuf, int off, int len):
 * Reads a specified number of characters from the file and stores them in the
 * character array cbuf starting from the specified offset.
 * It returns the number of characters read.
 * It returns -1 if the end of the file is reached.
 * 
 * 4. readLine():
 * Reads a line of text from the file and returns it as a String.
 * It returns null if the end of the file is reached.
 * 
 * 5. close():
 * Closes the file and releases any system resources associated with it.
 * 
 * 6. mark(int readAheadLimit):
 * Marks the current position in the file.
 * readAheadLimit: the maximum limit of characters that can be read ahead
 * without affecting the mark's position.
 * 
 * 7. reset():
 * Resets the file's current position to the last marked position.
 * 
 * 8. skip(long n):
 * Skips over and discards n characters from the file.
 * Returns the number of characters actually skipped.
 * 
 * It's important to close the FileReader after using it to free up system resources.
 * 
 * Example:
 * FileReader fr = new FileReader("file_path");
 * int c;
 * while ((c = fr.read()) != -1) {
 *     System.out.print((char) c);
 * }
 * fr.close();
 */

import java.io.FileReader;
import java.io.IOException;

public class FileReaderInJava { // Changed name to avoid conflict
    public static void main(String[] args) { // Added String[] args
        
        // try-with-resources automatically closes the file
        try (FileReader filereader = new FileReader("broCode/DemoFile.txt")) {
            int c;
            while ((c = filereader.read()) != -1) {
                System.out.print((char) c);  // Convert int to char
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
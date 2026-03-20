package broCode;

import java.io.BufferedReader;
import java.io.FileReader;
/**
 * Java BufferedReader class is used to read text files.
 * 
 * BufferReader reads text from a character-input stream, buffering characters so as to provide for the
 * efficient reading of characters, arrays, and lines.
 * 
 * The BufferedReader class provides several methods to read text from a file.
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
 * It's important to close the BufferedReader after using it to free up system resources.
 * 
 * Example:
 * BufferedReader br = new BufferedReader(new FileReader("file_path"));
 * int c;
 * while ((c = br.read()) != -1) {
 *     System.out.print((char) c);
 * }
 * br.close();
 */

public class BufferedReaderInJava {
    
    public static void main(String[] args) {
       
        try(BufferedReader reader = new BufferedReader(new FileReader("broCode/DemoFile.txt"))) {
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

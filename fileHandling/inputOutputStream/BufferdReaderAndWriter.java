package fileHandling.inputOutputStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
    

public class BufferdReaderAndWriter {
    public static void main(String[] args) {
        // Using try-with-resources to automatically close the streams
        try (BufferedReader br = new BufferedReader(new FileReader("fileHandling\\inputOutputStream\\input.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("fileHandling\\inputOutputStream\\output.txt"))) {
            String line;
            int count = 0;
            // Read line by line from input file
            while ((line = br.readLine()) != null) {
                System.out.println("Reading line " + count + ": " + line);
                // Write to output file with line number prefix

                bw.write(count + ": " + line);
                bw.newLine(); // Add a newline after each line
                count++;
            }
            
            System.out.println("Successfully processed " + count + " lines.");
        } catch (IOException e) {
            // Handle IOException specifically for file operations
            System.err.println("An error occurred while reading/writing the file: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            // Catch any other unexpected exceptions
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package fileHandling.inputOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class InputStream {
   public static void main(String[] var0) {
       // Demonstrate Input and Output Streams in Java
       // This program reads from DemoFile.txt using FileInputStream
       // and writes the content to OutputFile.txt using FileOutputStream

       File inputFile = new File("fileHandling/DemoFile.txt"); // Path relative to workspace root
       File outputFile = new File("OutputFile.txt");

       try (FileInputStream fis = new FileInputStream(inputFile);
            FileOutputStream fos = new FileOutputStream(outputFile)) {

           byte[] buffer = new byte[1024];
           int bytesRead;

           // Read from input stream and write to output stream
           while ((bytesRead = fis.read(buffer)) != -1) {
               fos.write(buffer, 0, bytesRead);
           }

           System.out.println("File copied successfully from " + inputFile.getName() + " to " + outputFile.getName());

       } catch (IOException e) {
           System.err.println("An error occurred: " + e.getMessage());
       }
   }
}
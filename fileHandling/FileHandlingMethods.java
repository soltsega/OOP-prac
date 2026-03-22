package fileHandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Method	Type	Description
canRead()	Boolean	Tests whether the file is readable or not
canWrite()	Boolean	Tests whether the file is writable or not
createNewFile()	Boolean	Creates an empty file
delete()	Boolean	Deletes a file
exists()	Boolean	Tests whether the file exists
getName()	String	Returns the name of the file
getAbsolutePath()	String	Returns the absolute pathname of the file
length()	Long	Returns the size of the file in bytes
list()	String[]	Returns an array of the files in the directory
mkdir()	Boolean	Creates a directory
 */


// Let's demonstrate these methods in java code
public class FileHandlingMethods {

    public static void main(String[] args) {
        demonstrateMethods();
    }

    public static void demonstrateMethods() {
        File file = new File("fileHandling/DemoFile.txt");
        System.out.println("File name: " + file.getName());
        System.out.println("File path: " + file.getAbsolutePath());
        System.out.println("File exists: " + file.exists());
        System.out.println("File can read: " + file.canRead());
        System.out.println("File can write: " + file.canWrite());
        System.out.println("File length: " + file.length());
        
        // Create a new file
        // try {
        //     boolean created = file.createNewFile();
        //     System.out.println("File created: " + created);
        // } catch (Exception e) {
        //     System.out.println("Error creating file: " + e.getMessage());
        // }

        // System.out.println("File deleted: " + file.delete());
        File file1 = new File("fileHandling/MyDirectory");
        System.out.println("Directory created: " + file1.mkdir());
        System.out.println("The files in the directory: " + file1.list());

        // File writer
        try {
            FileWriter myWriter = new FileWriter("fileHandling/DemoFile.txt");
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();  // must close manually
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
}

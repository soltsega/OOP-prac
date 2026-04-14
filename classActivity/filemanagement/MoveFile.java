package classActivity.filemanagement;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.io.IOException;

/**
 * MoveFile class
 */
public class MoveFile {
    public static void main(String[] args) {
        MoveFile moveFile = new MoveFile();
        moveFile.moveFile();
    }


    public void moveFile() {
        // TODO: Implement file moving logic
        Path source = Path.of("source.txt");
        Path target = Path.of("target.txt");
        
        // Move file from source to target
        // Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
        try {
            Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (java.nio.file.FileAlreadyExistsException e) {
            System.out.println("File already exists at the target location.");
        } catch (java.nio.file.NoSuchFileException e) {
            System.out.println("File does not exist at the source location.");
        } catch (java.nio.file.DirectoryNotEmptyException e) {
            System.out.println("Target location is a directory and not an empty directory.");
        } catch (IOException e) {
            System.out.println("An I/O error occurred.");
        }
    }
    
}

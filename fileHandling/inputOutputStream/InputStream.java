// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package fileHandling.inputOutputStream;
import java.io.File;
import java.io.FileInputStream;


public class InputStream {
   public static void main(String[] var0) {
      File var1 = new File("C:\\Users\\My Device\\Desktop\\OOP-prac\\fileHandling\\DemoFile.txt");
      
      try (FileInputStream  input = new FileInputStream(var1)){
         

      }catch(Exception e){
         System.out.println(e);
      } finally {

      }
   }
}
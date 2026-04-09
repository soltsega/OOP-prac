package JavaLab;
import java.util.Scanner;
public class welcome {
    public static void main(String[] args) {

        System.out.println("Welcome to Java Programming!");
        String name;
        long studentID = 123456789;
        float gpa = 3.75f;
        
        Scanner nameScanner = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        name = nameScanner.nextLine();
        System.out.println("Hello " + name + ", Welcome to Java Lab!");

    }

}

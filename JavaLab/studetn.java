package JavaLab;
import java.time.Year;
import java.util.Scanner;
public class studetn {
    public static void main(String[] args) {

        String name;
        String deptName;
        int yearofbirth;
        final int currentYear = Year.now().getValue();
        System.out.println("Welcome to Studetn Dashboard!");

        Scanner nameScanner = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        name = nameScanner.nextLine();

        System.out.print("Please enter your year of birth: ");
        yearofbirth = nameScanner.nextInt();

        System.out.print("Please enter your department name: ");
        nameScanner.nextLine();
        deptName = nameScanner.nextLine();

        nameScanner.close();

        int age = currentYear - yearofbirth;
        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age);
        System.out.println("Department Name: " + deptName);
    }
}

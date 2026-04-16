// TempretureConverter.java
package JavaLab;
import java.util.Scanner;

public class TempretureConverter {


    public static void main(String[] args) {
        TempretureConverter converter = new TempretureConverter();
        int choice = converter.userInput();

        switch (choice) {
            case 1:
                converter.celsiusFK();
                break;
            case 2:
                converter.fahrenheitCK();
                break;
            case 3:
                converter.kelvinCF();
                break;
            default:
                System.out.println("Invalid choice. Please choose a valid input type.");
        }

    }

    public int userInput() {
        //prompt the user to choose the input type and input the temperature value
        System.out.println("Choose the input type:");
        System.out.println("1. Celsius");
        System.out.println("2. Fahrenheit");
        System.out.println("3. Kelvin");

        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the input type: ");

        choice = scanner.nextInt();
        scanner.nextLine();

        return choice;

    }

        public void celsiusFK() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature in Celsius: ");
        double celsius = scanner.nextDouble();
        scanner.nextLine();

        double fahrenheit = (celsius * 9/5) + 32;
        double kelvin = celsius + 273.15;

        System.out.println(celsius + " degrees Celsius is equal to " + fahrenheit + " degrees Fahrenheit.");
        System.out.println(celsius + " degrees Celsius is equal to " + kelvin + " degrees Kelvin.");
    }

    public void fahrenheitCK() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature in Fahrenheit: ");
        double fahrenheit = scanner.nextDouble();
        scanner.nextLine();

        double celsius = (fahrenheit - 32) * 5/9;
        double kelvin = celsius + 273.15;

        System.out.println(fahrenheit + " degrees Fahrenheit is equal to " + celsius + " degrees Celsius.");
        System.out.println(fahrenheit + " degrees Fahrenheit is equal to " + kelvin + " degrees Kelvin.");
    }



    public void kelvinCF() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter temperature in Kelvin: ");
            double kelvin = scanner.nextDouble();
            scanner.nextLine();
            
            double celsius = kelvin - 273.15;
            double fahrenheit = (celsius * 9/5) + 32;
            
            System.out.println(kelvin + " degrees Kelvin is equal to " + celsius + " degrees Celsius.");
            System.out.println(kelvin + " degrees Kelvin is equal to " + fahrenheit + " degrees Fahrenheit.");
        }catch (Exception e) {
            System.out.println("An error occurred while reading input. Please try again.");
        }
    
    }
}




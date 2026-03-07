package broCode;
import java.util.Scanner;
public class UserInput {

    Scanner scanner = new Scanner(System.in);
    double a,b,c;
    System.out.print("Enter the length of the side A: ");
    a = scanner.nextDouble();

    scanner.close();

    // the use of printf() method
    // it is used to format a string
    // the placeholders are %s - string
                            // %d - integers
                            // %c - characters
                            // %b - boolean

    String name = "Solomon";
    int age = 21;
    char starts_with = 'S';
    bool isMale = true;
    double height = 1.78;
 
    System.out.printf("Hello %s", name);
    System.out.printf("your age is %d", age);
    System.out.printf("your age is %d", age);
    System.out.printf("your age is %d", age);

    // we can also pass two or more arguments
    System.out.printf("%s is %d years old", name, age);

    // we can also format the precision of the double and float data types
    // System.out.printf("%.2f", varName) - for two decimal places

    // we can also add negative oir positive signs 
    // System.out.printf("%+.2f", varName) - for two decimal places

    //we can also add a comma separator between each 3 digits
    // System.out.printf("%,.2f", varName) - for two decimal places

    // we can also enclose negative numbers wiht parentheses
    // System.out.printf("%(.2f", varName) - for two decimal places


    // we can also add spaces infront of the positive numbers and minus sign before negative numbers
    // System.out.printf("% .2f", varName) - for two decimal places. it helps for alignment

    // we can also pad numbers before or after 
    // System.out.printf("%04", varName) - for padding the number upto 4 significant digits. on the left side

    // on the right side
    // System.out.printf("%4d", varName) - for padding with upto 4 empty spaces on the left side
    

    // To make numbers left justified
    // System.out.printf("%-4d", varName) 


 



}


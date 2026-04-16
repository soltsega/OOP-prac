package JavaLab.SecurityPin;
import java.util.Scanner;

public class securityPin {
    public static void main(String[] args) {
        String pin = "8585";
        String userInput;
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the pin: ");
        userInput = scanner.nextLine();
        int count=0;
        while(!userInput.equals(pin)){
        count++;
        if (userInput.equals(pin)) {
            System.out.println("Correct pin. Access granted");
        } else {
            System.out.println("Incorrect pin. Try again. You have "+ (4-count) +" chances to try");
        }
        }
    }
   
}

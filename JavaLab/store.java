package JavaLab;
import java.util.Scanner;
public class store {
    public static void main(String[] args) {
        String item1="Chips",item2="Ertb",item3="Chocolate";
        final double price1= 30,price2= 50,price3= 100;
        int subTotal;
        int finalTotal;

        int amount1,amount2,amount3;

        Scanner item= new Scanner(System.in);
        System.out.println("Enter the amount of Chips u want:");
        amount1 = item.nextInt();
    
        System.out.println("Enter the amount of Ertb u want:");
        amount2 = item.nextInt();

        System.out.println("Enter the Chocolate u want:");
        amount3 = item.nextInt();

        subTotal = (int) ((amount1 * price1) + (amount2 * price2) + (amount3 * price3));

        finalTotal=  (int) (subTotal*(1-0.05));

        System.out.println("Final Total= " + finalTotal);




    }
}

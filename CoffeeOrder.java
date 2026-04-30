/**
 * The Coffee Shop 
* 1. Create a class named CoffeeOrder.
 * 2. Add attributes: customerName (String) ,numberOfCups (int) 
 * and pricePerCup (double) .
 * 3. Create a Constructor that initializes all attributes.In the Setter
 * for numberOfCups, only allow values between 1 and 50. If it's 
 * outside this range, print "Invalid order size." and do not update the attribute.
 * 
 */
public class CoffeeOrder {
    private String customerName;
    private int numberOfCups;
    private double pricePerCup;



    // we use the parameterized constructor to initialize all attributes when creating an instance of CoffeeOrder
    public CoffeeOrder(String customerName, int numberOfCups, double pricePerCup) {
        this.customerName = customerName;
        setNumberOfCups(numberOfCups);  //we passed the numberOfCups to the setter method to validate the value before setting it because 
        this.pricePerCup = pricePerCup;
    }   

    // we use the getter method to get or retrieve the value of customerName and the setter method to set or update the value of customerName
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getNumberOfCups() {
        return numberOfCups;
    }

    public void setNumberOfCups(int numberOfCups) {
        if (numberOfCups >= 1 && numberOfCups <= 50) {
            this.numberOfCups = numberOfCups;
        } else {
            System.out.println("Invalid order size.");
        }
    }

    public double getPricePerCup() {
        return pricePerCup;
    }

    public void setPricePerCup(double pricePerCup) {
        this.pricePerCup = pricePerCup;
    }
}

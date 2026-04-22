// Basic interface definition
public interface Edible {
    // Constants are public, static, final by default
    double MAX_PORTION_SIZE = 1000.0;
    String QUALITY_STANDARD = "Premium";
    
    // Abstract methods are public and abstract by default
    void eat();
    String getTaste();
    boolean isHealthy();
    
    // Default method (Java 8+)
    default void describeNutrition() {
        System.out.println("This edible item provides nutritional value");
    }
    
    // Static method (Java 8+)
    static void displayQualityInfo() {
        System.out.println("Quality Standard: " + QUALITY_STANDARD);
    }
    
    // Private method (Java 9+)
    private void validatePortion(double portion) {
        if (portion > MAX_PORTION_SIZE) {
            System.out.println("Warning: Portion size exceeds maximum");
        }
    }
}

// Interface extending another interface
interface Gourmet extends Edible {
    void plate();
    void garnish();
    
    // Can override default methods
    @Override
    default void describeNutrition() {
        System.out.println("This gourmet item provides premium nutritional value");
        Edible.super.describeNutrition(); // Call parent default method
    }
}

// Class implementing interface
public class Salad implements Edible {
    private String name;
    
    public Salad(String name) {
        this.name = name;
    }
    
    @Override
    public void eat() {
        System.out.println("Eating " + name + " salad");
    }
    
    @Override
    public String getTaste() {
        return "Fresh and crisp";
    }
    
    @Override
    public boolean isHealthy() {
        return true;
    }
    
    // Can override default method
    @Override
    public void describeNutrition() {
        System.out.println(name + " salad is rich in vitamins and fiber");
    }
}

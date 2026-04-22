package dishes_classwork;
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

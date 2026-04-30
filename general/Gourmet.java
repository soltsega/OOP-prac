package general;
import dishes_classwork.Edible;

public interface Gourmet extends Edible {
    void plate();
    void garnish();
    
    // Can override default methods
    @Override
    default void describeNutrition() {
        System.out.println("This gourmet item provides premium nutritional value");
        Edible.super.describeNutrition(); // Call parent default method
    }
}

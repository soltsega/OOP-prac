public class InterfaceDemo {
    public static void main(String[] args) {
        // Basic interface usage
        Edible salad = new Salad("Greek");
        salad.eat();
        System.out.println("Taste: " + salad.getTaste());
        System.out.println("Healthy: " + salad.isHealthy());
        salad.describeNutrition();
        
        // Static method call
        Edible.displayQualityInfo();
        
        // Multiple interface implementation
        PremiumDish specialDish = new PremiumDish("Lobster");
        specialDish.eat();
        specialDish.plate();
        specialDish.garnish();
        specialDish.setPrice(45.99);
        System.out.println("Price: $" + specialDish.getPrice());
    }
}

// Class implementing multiple interfaces
class PremiumDish implements Edible, Gourmet, Priced {
    private String name;
    private double price;
    
    public PremiumDish(String name) {
        this.name = name;
    }
    
    @Override
    public void eat() {
        System.out.println("Eating premium " + name);
    }
    
    @Override
    public String getTaste() {
        return "Exquisite and flavorful";
    }
    
    @Override
    public boolean isHealthy() {
        return false; // Premium dishes might not be healthy
    }
    
    @Override
    public void plate() {
        System.out.println("Plating " + name + " elegantly");
    }
    
    @Override
    public void garnish() {
        System.out.println("Adding garnish to " + name);
    }
    
    @Override
    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public double getPrice() {
        return price;
    }
}

// Another interface
interface Priced {
    void setPrice(double price);
    double getPrice();
}

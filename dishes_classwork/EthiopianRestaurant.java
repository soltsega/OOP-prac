package dishes_classwork;

public class EthiopianRestaurant {
    public static void main(String[] args) {
        // Create different Ethiopian dishes
        EthiopianDish shiro = new ShiroWot();
        EthiopianDish doro = new DoroWot(2);
        EthiopianDish tibs = new Tibs("beef");
        EthiopianDish vegTibs = new Tibs("vegetable");
        
        // Array of Ethiopian dishes
        EthiopianDish[] menu = {shiro, doro, tibs, vegTibs};
        
        System.out.println("=== ETHIOPIAN RESTAURANT MENU ===\n");
        
        // Demonstrate polymorphism
        for (EthiopianDish dish : menu) {
            dish.describe();
            dish.prepare();
            System.out.println("Ingredients: " + dish.getIngredients());
            dish.serve();
            System.out.println("------------------------");
        }
        
        // Demonstrate subclass-specific methods
        System.out.println("\n=== SPECIAL REQUESTS ===");
        
        ShiroWot spicyShiro = new ShiroWot();
        spicyShiro.adjustSpiceLevel("Very Hot");
        
        DoroWot familyDoro = new DoroWot(4);
        familyDoro.addExtraChicken(2);
        
        Tibs lambTibs = new Tibs("lamb");
        lambTibs.changeMeatType("goat");
    }
}

package dishes_classwork;
public class ShiroWot extends EthiopianDish {
    
    public ShiroWot() {
        super("Shiro Wot", 8.50, "Medium", true);
    }
    
    @Override
    public void prepare() {
        System.out.println("Preparing Shiro Wot: Grinding chickpeas, mixing with berbere spice, and simmering...");
    }
    
    @Override
    public void serve() {
        System.out.println("Serving Shiro Wot hot with injera and salad.");
    }
    
    @Override
    public String getIngredients() {
        return "Chickpea flour, berbere spice, onions, garlic, ginger, oil";
    }
    
    // Shiro-specific method
    public void adjustSpiceLevel(String level) {
        this.spiceLevel = level;
        System.out.println("Shiro Wot spice level adjusted to: " + level);
    }
}

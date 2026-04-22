package dishes_classwork;
public class Tibs extends EthiopianDish {
    private String meatType;
    
    public Tibs(String meatType) {
        super("Tibs", 18.75, "Medium-Hot", meatType.equalsIgnoreCase("vegetable"));
        this.meatType = meatType;
    }
    
    @Override
    public void prepare() {
        System.out.println("Preparing " + meatType + " Tibs: Sautéing with onions, peppers, and spices...");
    }
    
    @Override
    public void serve() {
        System.out.println("Serving " + meatType + " Tibs sizzling hot with injera and awaze sauce.");
    }
    
    @Override
    public String getIngredients() {
        if (meatType.equalsIgnoreCase("vegetable")) {
            return "Mixed vegetables, onions, peppers, tomatoes, garlic";
        } else {
            return meatType + ", onions, peppers, tomatoes, rosemary, garlic";
        }
    }
    
    // Tibs-specific method
    public void changeMeatType(String newMeatType) {
        this.meatType = newMeatType;
        this.isVegetarian = newMeatType.equalsIgnoreCase("vegetable");
        this.name = newMeatType + " Tibs";
        System.out.println("Changed to " + newMeatType + " Tibs");
    }
    
    public String getMeatType() {
        return meatType;
    }
}


package dishes_classwork;
public abstract class EthiopianDish {
    protected String name;
    protected double price;
    protected String spiceLevel;
    protected boolean isVegetarian;
    
    public EthiopianDish(String name, double price, String spiceLevel, boolean isVegetarian) {
        this.name = name;
        this.price = price;
        this.spiceLevel = spiceLevel;
        this.isVegetarian = isVegetarian;
    }
    
    // Abstract methods that must be implemented by subclasses
    public abstract void prepare();
    public abstract void serve();
    public abstract String getIngredients();
    
    // Concrete method that all Ethiopian dishes share
    public void describe() {
        System.out.println(name + " - Price: $" + price + ", Spice: " + spiceLevel + 
                          ", Vegetarian: " + (isVegetarian ? "Yes" : "No"));
    }
    
    // Getters
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getSpiceLevel() { return spiceLevel; }
    public boolean isVegetarian() { return isVegetarian; }
}

package dishes_classwork;
public class DoroWot extends EthiopianDish {
    private int chickenPieces;
    
    public DoroWot(int chickenPieces) {
        super("Doro Wot", 15.99, "Hot", false);
        this.chickenPieces = chickenPieces;
    }
    
    @Override
    public void prepare() {
        System.out.println("Preparing Doro Wot: Marinating chicken, cooking with berbere, niter kibbeh, and onions...");
    }
    
    @Override
    public void serve() {
        System.out.println("Serving Doro Wot with hard-boiled eggs, injera, and vegetables.");
    }
    
    @Override
    public String getIngredients() {
        return "Chicken, berbere spice, niter kibbeh, onions, garlic, ginger, eggs";
    }
    
    // Doro-specific method
    public void addExtraChicken(int pieces) {
        this.chickenPieces += pieces;
        this.price += (pieces * 2.50);
        System.out.println("Added " + pieces + " extra chicken pieces. New price: $" + price);
    }
    
    public int getChickenPieces() {
        return chickenPieces;
    }
}




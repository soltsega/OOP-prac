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

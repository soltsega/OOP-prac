package dishes_classwork;

public class Selata implements Edible {
    private String name;
    
    public Selata(String name) {
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

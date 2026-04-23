// Polymorphism Examples

// Interface for polymorphic behavior
interface Drawable {
    void draw();
    default void getInfo() {
        System.out.println("This is a drawable object");
    }
}

// Interface for resizeable behavior
interface Resizeable {
    void resize(double factor);
}

// Abstract class with partial implementation
abstract class Shape implements Drawable {
    protected String color;
    
    public Shape(String color) {
        this.color = color;
    }
    
    // Concrete method
    public void setColor(String color) {
        this.color = color;
    }
    
    public String getColor() {
        return color;
    }
    
    // Abstract method - must be implemented
    public abstract double getArea();
    
    // Implementing interface method
    @Override
    public void getInfo() {
        System.out.println("Shape with color: " + color);
    }
}

// Concrete class implementing everything
class Circle extends Shape implements Resizeable {
    private double radius;
    
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " circle with radius " + radius);
    }
    
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public void resize(double factor) {
        radius *= factor;
        System.out.println("Circle resized by factor " + factor);
    }
}

// Another concrete class
class Rectangle extends Shape implements Resizeable {
    private double width, height;
    
    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " rectangle " + width + "x" + height);
    }
    
    @Override
    public double getArea() {
        return width * height;
    }
    
    @Override
    public void resize(double factor) {
        width *= factor;
        height *= factor;
        System.out.println("Rectangle resized by factor " + factor);
    }
}

// Polymorphism demonstration
public class PolymorphismDemo {
    public static void main(String[] args) {
        // Polymorphism through inheritance
        Vehicle[] vehicles = {
            new Car("Toyota", 2022, 4),
            new Motorcycle("Harley", 2021, false)
        };
        
        System.out.println("=== Vehicle Polymorphism ===");
        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();  // Inherited method
            vehicle.operate();      // Template method
            System.out.println();
        }
        
        // Polymorphism through interfaces
        Drawable[] drawables = {
            new Circle("red", 5.0),
            new Rectangle("blue", 4.0, 6.0)
        };
        
        System.out.println("=== Interface Polymorphism ===");
        for (Drawable drawable : drawables) {
            drawable.draw();       // Interface method
            drawable.getInfo();     // Default method
            System.out.println();
        }
        
        // Combining both types of polymorphism
        System.out.println("=== Combined Polymorphism ===");
        Shape[] shapes = {
            new Circle("green", 3.0),
            new Rectangle("yellow", 2.0, 4.0)
        };
        
        for (Shape shape : shapes) {
            shape.draw();           // Interface method
            System.out.println("Area: " + shape.getArea()); // Abstract method
            shape.setColor("black"); // Concrete method
            System.out.println("New color: " + shape.getColor());
            
            // Check if resizeable (runtime polymorphism)
            if (shape instanceof Resizeable) {
                ((Resizeable) shape).resize(1.5);
            }
            System.out.println();
        }
    }
}

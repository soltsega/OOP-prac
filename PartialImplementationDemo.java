// Partial Implementation in Abstract Methods and Interfaces

// 1. ABSTRACT CLASS - Partial Implementation
abstract class Vehicle {
    protected String brand;
    protected int year;
    
    // Concrete method - shared implementation
    public void displayInfo() {
        System.out.println("Vehicle: " + brand + " " + year);
    }
    
    // Partial implementation - template method pattern
    public void startVehicle() {
        System.out.println("Starting vehicle process:");
        performPreStartChecks();
        startEngine();
        engageTransmission();
        System.out.println("Vehicle started successfully");
    }
    
    // Abstract methods - must be implemented by subclasses
    public abstract void startEngine();
    public abstract void engageTransmission();
    
    // Abstract method for pre-start checks
    protected abstract void performPreStartChecks();
    
    // Getters and setters
    public String getBrand() { return brand; }
    public void setBrand(final String brand) { this.brand = brand; }
    public int getYear() { return year; }
    public void setYear(final int year) { this.year = year; }
}

// 2. CONCRETE CLASS - Completing Abstract Implementation
class Car extends Vehicle {
    private final String model;
    private final int doors;
    
    public Car(final String brand, final int year, final String model, final int doors) {
        super(brand, year);
        this.model = model;
        this.doors = doors;
    }
    
    // Implement abstract methods
    @Override
    public void startEngine() {
        System.out.println("  Starting car engine with ignition key");
    }
    
    @Override
    public void engageTransmission() {
        System.out.println("  Engaging automatic transmission");
    }
    
    @Override
    protected void performPreStartChecks() {
        System.out.println("  Checking fuel level: OK");
        System.out.println("  Checking brake system: OK");
        System.out.println("  Checking dashboard lights: OK");
    }
    
    // Car-specific method
    public void honkHorn() {
        System.out.println("Honking horn: Beep beep!");
    }
    
    @Override
    public String toString() {
        return String.format("Car: %s %s %s (%d doors)", brand, year, model, doors);
    }
}

// 3. INTERFACE - Partial Implementation (Java 8+)
interface Drawable {
    // Abstract method - must be implemented
    void draw();
    
    // Default method - partial implementation
    default void display() {
        System.out.println("Displaying drawable object");
        draw(); // Call abstract method
    }
    
    // Another default method with partial implementation
    default void resize(final double factor) {
        System.out.println("Resizing by factor: " + factor);
        validateResizeFactor(factor);
        performResize(factor);
    }
    
    // Private helper method for default methods (Java 9+)
    private void validateResizeFactor(final double factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("Resize factor must be positive");
        }
    }
    
    // Abstract method to be implemented by classes
    void performResize(double factor);
    
    // Static method - complete implementation
    static void printInfo() {
        System.out.println("Drawable interface - provides drawing capabilities");
    }
}

// 4. INTERFACE EXTENDING ANOTHER INTERFACE
interface Resizable extends Drawable {
    // New abstract method
    void setSize(double width, double height);
    
    // Override default method from parent interface
    @Override
    default void resize(final double factor) {
        System.out.println("Resizable object resizing by factor: " + factor);
        // Can call parent's default method
        Drawable.super.resize(factor);
    }
    
    // Additional default method
    default void scaleToSize(final double targetWidth, final double targetHeight) {
        System.out.println("Scaling to specific size: " + targetWidth + "x" + targetHeight);
        setSize(targetWidth, targetHeight);
    }
}

// 5. CONCRETE CLASS IMPLEMENTING INTERFACE
class Circle implements Resizable {
    private double radius;
    
    public Circle(final double radius) {
        this.radius = radius;
    }
    
    // Implement abstract methods from Drawable interface
    @Override
    public void draw() {
        System.out.println("Drawing circle with radius: " + radius);
    }
    
    @Override
    public void performResize(final double factor) {
        radius *= factor;
        System.out.println("Circle radius changed to: " + radius);
    }
    
    // Implement abstract method from Resizable interface
    @Override
    public void setSize(final double width, final double height) {
        // For circle, use average of width and height as diameter
        final double diameter = (width + height) / 2;
        this.radius = diameter / 2;
        System.out.println("Circle size set to radius: " + radius);
    }
    
    // Circle-specific method
    public double getArea() {
        return Math.PI * radius * radius;
    }
    
    public double getRadius() { return radius; }
}

// 6. ABSTRACT CLASS IMPLEMENTING INTERFACE
abstract class Shape implements Drawable {
    protected String color;
    
    public Shape(final String color) {
        this.color = color;
    }
    
    // Provide partial implementation of interface method
    @Override
    public void display() {
        System.out.println("Displaying " + color + " shape");
        draw(); // Will use subclass implementation
    }
    
    // Abstract method for shape-specific area calculation
    public abstract double calculateArea();
    
    // Concrete method for color
    public String getColor() { return color; }
    public void setColor(final String color) { this.color = color; }
}

// 7. CONCRETE CLASS EXTENDING ABSTRACT CLASS
class Rectangle extends Shape implements Resizable {
    private double width;
    private double height;
    
    public Rectangle(final String color, final double width, final double height) {
        super(color);
        this.width = width;
        this.height = height;
    }
    
    // Implement abstract method from Drawable
    @Override
    public void draw() {
        System.out.println("Drawing " + color + " rectangle: " + width + "x" + height);
    }
    
    // Implement abstract method from Shape
    @Override
    public double calculateArea() {
        return width * height;
    }
    
    // Implement methods from Resizable interface
    @Override
    public void performResize(final double factor) {
        width *= factor;
        height *= factor;
        System.out.println("Rectangle resized to: " + width + "x" + height);
    }
    
    @Override
    public void setSize(final double width, final double height) {
        this.width = width;
        this.height = height;
        System.out.println("Rectangle size set to: " + width + "x" + height);
    }
    
    // Rectangle-specific methods
    public double getWidth() { return width; }
    public double getHeight() { return height; }
}

// 8. MULTIPLE INTERFACE IMPLEMENTATION
interface Movable {
    void move(double deltaX, double deltaY);
    
    default void resetPosition() {
        move(0, 0);
    }
}

class MovableCircle extends Circle implements Movable {
    private double centerX, centerY;
    
    public MovableCircle(final double radius, final double centerX, final double centerY) {
        super(radius);
        this.centerX = centerX;
        this.centerY = centerY;
    }
    
    @Override
    public void move(final double deltaX, final double deltaY) {
        centerX += deltaX;
        centerY += deltaY;
        System.out.println("Circle moved to: (" + centerX + ", " + centerY + ")");
    }
    
    @Override
    public String toString() {
        return String.format("MovableCircle[radius=%.1f, center=(%.1f, %.1f)]", 
                           getRadius(), centerX, centerY);
    }
}

// 9. COMPLEX HIERARCHY DEMONSTRATION
abstract class Animal {
    protected String name;
    protected int age;
    
    public Animal(final String name, final int age) {
        this.name = name;
        this.age = age;
    }
    
    // Concrete method
    public void sleep() {
        System.out.println(name + " is sleeping");
    }
    
    // Abstract methods
    public abstract void makeSound();
    public abstract void move();
    
    // Template method with partial implementation
    public void dailyRoutine() {
        wakeUp();
        move();
        makeSound();
        sleep();
    }
    
    // Abstract method for template
    protected abstract void wakeUp();
}

interface Trainable {
    void train(String command);
    
    default void performTrick() {
        System.out.println("Performing a trick!");
    }
}

abstract class Dog extends Animal implements Trainable {
    protected String breed;
    
    public Dog(final String name, final int age, final String breed) {
        super(name, age);
        this.breed = breed;
    }
    
    // Partial implementation of abstract method
    @Override
    public void move() {
        System.out.println(breed + " dog " + name + " is running");
    }
    
    // Abstract method left for concrete class
    public abstract void fetch();
    
    @Override
    protected void wakeUp() {
        System.out.println(name + " wakes up and stretches");
    }
}

class GoldenRetriever extends Dog {
    public GoldenRetriever(final String name, final int age) {
        super(name, age, "Golden Retriever");
    }
    
    // Complete the implementation
    @Override
    public void makeSound() {
        System.out.println(name + " barks: Woof woof!");
    }
    
    @Override
    public void fetch() {
        System.out.println(name + " fetches the ball enthusiastically");
    }
    
    @Override
    public void train(final String command) {
        System.out.println(name + " learns command: " + command);
    }
}

public class PartialImplementationDemo {
    public static void main(final String[] args) {
        System.out.println("=== PARTIAL IMPLEMENTATION DEMO ===\n");
        
        // 1. Abstract class partial implementation
        System.out.println("1. Abstract Class Partial Implementation:");
        final Car car = new Car("Toyota", 2023, "Camry", 4);
        car.displayInfo();           // Concrete method from abstract class
        car.startVehicle();          // Template method with abstract methods
        car.honkHorn();              // Concrete method from concrete class
        
        System.out.println();
        
        // 2. Interface partial implementation
        System.out.println("2. Interface Partial Implementation:");
        final Circle circle = new Circle(5.0);
        circle.draw();               // Abstract method implementation
        circle.display();            // Default method from interface
        circle.resize(1.5);          // Default method with validation
        circle.setSize(10, 10);      // Method from extending interface
        
        System.out.println("Circle area: " + circle.getArea());
        
        System.out.println();
        
        // 3. Abstract class implementing interface
        System.out.println("3. Abstract Class Implementing Interface:");
        final Rectangle rect = new Rectangle("blue", 4.0, 6.0);
        rect.draw();                 // Abstract method from Drawable
        rect.display();              // Overridden default method
        rect.calculateArea();        // Abstract method from Shape
        rect.resize(2.0);            // Default method from Resizable
        
        System.out.println("Rectangle area: " + rect.calculateArea());
        
        System.out.println();
        
        // 4. Multiple interface implementation
        System.out.println("4. Multiple Interface Implementation:");
        final MovableCircle movableCircle = new MovableCircle(3.0, 10, 15);
        movableCircle.draw();
        movableCircle.move(5, -3);
        movableCircle.resetPosition();
        
        System.out.println();
        
        // 5. Complex hierarchy
        System.out.println("5. Complex Hierarchy:");
        final GoldenRetriever dog = new GoldenRetriever("Buddy", 3);
        dog.dailyRoutine();          // Template method from Animal
        dog.fetch();                  // Abstract method from Dog
        dog.train("sit");             // Method from Trainable interface
        dog.performTrick();           // Default method from Trainable
        
        System.out.println();
        
        // 6. Demonstrate interface static methods
        System.out.println("6. Interface Static Methods:");
        Drawable.printInfo();         // Static method from interface
        
        System.out.println();
        
        // 7. Polymorphism with partial implementations
        System.out.println("7. Polymorphism with Partial Implementations:");
        final Drawable[] drawables = {
            circle,
            rect,
            movableCircle
        };
        
        for (final Drawable drawable : drawables) {
            drawable.display();       // Uses default implementation
            drawable.resize(0.8);    // Uses default implementation
            System.out.println();
        }
        
        // 8. Interface method resolution
        System.out.println("8. Interface Method Resolution:");
        final Resizable resizable = new Circle(2.0);
        resizable.resize(1.5);       // Uses overridden default in Resizable
        
        System.out.println();
        
        System.out.println("=== DEMO COMPLETE ===");
    }
}

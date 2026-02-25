package chapter2;

/**
 * Lesson 2.1: Defining a Class
 * 
 * A class is a blueprint or template for creating objects.
 * It defines the properties (fields) and behaviors (methods) that objects of that type will have.
 */

public class lesson2_1_DefiningClass {
    
    // Class fields (properties/attributes)
    private String name;
    private int age;
    private boolean isActive;
    
    // Class methods (behaviors)
    public void introduce() {
        System.out.println("Hello, I'm " + name + " and I'm " + age + " years old.");
    }
    
    public void setActive(boolean status) {
        isActive = status;
        System.out.println(name + " is now " + (status ? "active" : "inactive"));
    }
    
    // Main method to demonstrate the class definition
    public static void main(String[] args) {
        System.out.println("=== Lesson 2.1: Defining a Class ===");
        System.out.println("This file demonstrates the basic structure of a Java class.");
        System.out.println("A class serves as a blueprint for creating objects.");
        
        // We'll create objects in the next lesson (2.2)
        System.out.println("Key components of a class:");
        System.out.println("1. Fields (properties/attributes)");
        System.out.println("2. Methods (behaviors)");
        System.out.println("3. Constructors (special methods for object creation)");
        System.out.println("4. Access modifiers (public, private, protected)");
    }
}

/**
 * Additional Example: Simple Car Class
 * This shows another example of class definition
 */
class Car {
    // Fields
    private String make;
    private String model;
    private int year;
    private double speed;
    
    // Methods
    public void start() {
        System.out.println("The " + make + " " + model + " is starting.");
    }
    
    public void accelerate(double amount) {
        speed += amount;
        System.out.println("Speed increased to " + speed + " mph");
    }
    
    public void brake() {
        speed = 0;
        System.out.println("The car has stopped.");
    }
    
    // Getter methods
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getSpeed() { return speed; }
    
    // Setter methods
    public void setMake(String make) { this.make = make; }
    public void setModel(String model) { this.model = model; }
    public void setYear(int year) { this.year = year; }
}

/**
 * Anatomy of a Class:
 * 
 * 1. Class Declaration:
 *    public class ClassName {
 *        // class body
 *    }
 * 
 * 2. Fields (Instance Variables):
 *    - Store the state/data of an object
 *    - Can be primitive types or objects
 *    - Usually private (encapsulation)
 * 
 * 3. Methods:
 *    - Define the behavior of an object
 *    - Can return values or be void
 *    - Can take parameters
 * 
 * 4. Constructors (to be covered in lesson 2.5):
 *    - Special methods for creating objects
 *    - Same name as the class
 *    - No return type
 * 
 * 5. Access Modifiers (to be covered in lesson 2.6):
 *    - public: accessible from anywhere
 *    - private: accessible only within the class
 *    - protected: accessible within package and subclasses
 *    - (default): accessible within package only
 */

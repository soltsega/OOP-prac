package chapter2;

/**
 * Lesson 2.2: Creating an Object
 * 
 * An object is an instance of a class. Creating objects involves:
 * 1. Declaration: Declaring a variable of class type
 * 2. Instantiation: Using 'new' keyword to allocate memory
 * 3. Initialization: Calling constructor to initialize the object
 */

public class lesson2_2_CreatingObjects {
    
    public static void main(String[] args) {
        System.out.println("=== Lesson 2.2: Creating Objects ===\n");
        
        // Basic object creation
        demonstrateBasicObjectCreation();
        
        // Multiple objects of same class
        demonstrateMultipleObjects();
        
        // Object references and memory
        demonstrateObjectReferences();
        
        // Null objects
        demonstrateNullObjects();
    }
    
    /**
     * Basic object creation demonstration
     */
    public static void demonstrateBasicObjectCreation() {
        System.out.println("1. Basic Object Creation:");
        
        // Three steps of object creation:
        // 1. Declaration: Car myCar;
        // 2. Instantiation: new Car();
        // 3. Initialization: Car() constructor call
        
        Car car1 = new Car(); // All three steps in one line
        System.out.println("Created car1 object");
        
        // Using the object
        car1.setMake("Toyota");
        car1.setModel("Camry");
        car1.setYear(2023);
        
        System.out.println("Car details: " + car1.getMake() + " " + 
                          car1.getModel() + " " + car1.getYear());
        
        System.out.println();
    }
    
    /**
     * Creating multiple objects of the same class
     */
    public static void demonstrateMultipleObjects() {
        System.out.println("2. Multiple Objects:");
        
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        
        // Each object is independent with its own state
        car1.setMake("Honda");
        car1.setModel("Civic");
        car1.setYear(2022);
        
        car2.setMake("Ford");
        car2.setModel("Mustang");
        car2.setYear(2023);
        
        car3.setMake("Tesla");
        car3.setModel("Model 3");
        car3.setYear(2024);
        
        System.out.println("Car 1: " + car1.getMake() + " " + car1.getModel());
        System.out.println("Car 2: " + car2.getMake() + " " + car2.getModel());
        System.out.println("Car 3: " + car3.getMake() + " " + car3.getModel());
        
        System.out.println("Total cars created: " + Car.getCarCount());
        
        System.out.println();
    }
    
    /**
     * Object references and memory
     */
    public static void demonstrateObjectReferences() {
        System.out.println("3. Object References:");
        
        Car originalCar = new Car();
        originalCar.setMake("BMW");
        originalCar.setModel("X5");
        
        Car referenceCar = originalCar; // Both reference the same object
        
        System.out.println("Original car: " + originalCar.getMake() + " " + originalCar.getModel());
        System.out.println("Reference car: " + referenceCar.getMake() + " " + referenceCar.getModel());
        
        // Modifying through reference affects original
        referenceCar.setModel("X6");
        
        System.out.println("After modification through reference:");
        System.out.println("Original car: " + originalCar.getMake() + " " + originalCar.getModel());
        System.out.println("Reference car: " + referenceCar.getMake() + " " + referenceCar.getModel());
        
        // Check if they reference the same object
        System.out.println("Same object? " + (originalCar == referenceCar));
        
        System.out.println();
    }
    
    /**
     * Null objects and null pointer exceptions
     */
    public static void demonstrateNullObjects() {
        System.out.println("4. Null Objects:");
        
        Car nullCar = null; // Reference variable not pointing to any object
        System.out.println("nullCar reference created");
        
        // Check for null before using
        if (nullCar == null) {
            System.out.println("nullCar is null - cannot use yet");
        }
        
        // This would cause NullPointerException:
        // nullCar.setMake("Nissan"); // ERROR!
        
        // Proper way to handle null references
        nullCar = new Car(); // Now it points to an actual object
        nullCar.setMake("Nissan");
        nullCar.setModel("Altima");
        
        System.out.println("After initialization: " + nullCar.getMake() + " " + nullCar.getModel());
        
        System.out.println();
    }
}

/**
 * Car class for object creation examples
 */
class Car {
    // Instance fields
    private String make;
    private String model;
    private int year;
    private static int carCount = 0; // Static field to count all cars
    
    // Default constructor
    public Car() {
        carCount++;
        System.out.println("Car object #" + carCount + " created");
    }
    
    // Parameterized constructor
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
        carCount++;
        System.out.println("Car object #" + carCount + " created with parameters");
    }
    
    // Getter methods
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    
    // Setter methods
    public void setMake(String make) { 
        this.make = make != null ? make.trim() : ""; 
    }
    
    public void setModel(String model) { 
        this.model = model != null ? model.trim() : ""; 
    }
    
    public void setYear(int year) { 
        if (year >= 1900 && year <= 2100) {
            this.year = year; 
        }
    }
    
    // Static method to get car count
    public static int getCarCount() {
        return carCount;
    }
    
    // Method to display car info
    public void displayInfo() {
        System.out.println(year + " " + make + " " + model);
    }
}

/**
 * Object Creation Syntax Summary:
 * 
 * 1. Declaration + Instantiation + Initialization:
 *    ClassName objectName = new ClassName();
 * 
 * 2. Declaration only:
 *    ClassName objectName; // objectName is null
 * 
 * 3. Instantiation later:
 *    objectName = new ClassName();
 * 
 * 4. With parameters:
 *    ClassName objectName = new ClassName(param1, param2);
 * 
 * 5. Multiple objects:
 *    ClassName obj1 = new ClassName();
 *    ClassName obj2 = new ClassName();
 *    ClassName obj3 = obj1; // obj3 references same object as obj1
 * 
 * Key Points:
 * - 'new' keyword allocates memory for the object
 * - Constructor is called to initialize the object
 * - Object variables are references to actual objects
 * - Multiple variables can reference the same object
 * - null means the variable doesn't reference any object
 * - Always check for null before using an object reference
 */

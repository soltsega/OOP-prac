// Partial Implementation and Polymorphism Examples

// Abstract class with partial implementation
abstract class Vehicle {
    protected String brand;
    protected int year;
    
    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }
    
    // Concrete method - shared implementation
    public void displayInfo() {
        System.out.println(brand + " " + year);
    }
    
    // Abstract methods - must be implemented by subclasses
    public abstract void start();
    public abstract void stop();
    
    // Partial implementation - template method pattern
    public void operate() {
        System.out.println("Operating vehicle...");
        start();
        System.out.println("Vehicle is running");
        stop();
    }
}

// Concrete class implementing remaining abstract methods
class Car extends Vehicle {
    private int doors;
    
    public Car(String brand, int year, int doors) {
        super(brand, year);
        this.doors = doors;
    }
    
    @Override
    public void start() {
        System.out.println("Car engine starting with key");
    }
    
    @Override
    public void stop() {
        System.out.println("Car engine stopping");
    }
    
    // Car-specific method
    public void honk() {
        System.out.println("Beep beep!");
    }
}

// Another concrete class with different implementation
class Motorcycle extends Vehicle {
    private boolean hasSidecar;
    
    public Motorcycle(String brand, int year, boolean hasSidecar) {
        super(brand, year);
        this.hasSidecar = hasSidecar;
    }
    
    @Override
    public void start() {
        System.out.println("Motorcycle starting with kick start");
    }
    
    @Override
    public void stop() {
        System.out.println("Motorcycle stopping");
    }
    
    // Motorcycle-specific method
    public void wheelie() {
        System.out.println("Doing a wheelie!");
    }
}

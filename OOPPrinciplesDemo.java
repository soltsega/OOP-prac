// OOP Principles Demonstration

// 1. ENCAPSULATION - Bundling data and methods together
class BankAccount {
    // Private data - hidden from outside
    private double balance;
    private String accountNumber;
    
    // Public methods - controlled access
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount");
        }
    }
    
    public double getBalance() {
        return balance;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
}

// 2. INHERITANCE - Reusing and extending functionality
abstract class Animal {
    protected String name;
    protected int age;
    
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Concrete method
    public void sleep() {
        System.out.println(name + " is sleeping");
    }
    
    // Abstract method - must be implemented
    public abstract void makeSound();
    public abstract void move();
}

class Dog extends Animal {
    private String breed;
    
    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }
    
    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }
    
    @Override
    public void move() {
        System.out.println(name + " is running");
    }
    
    // Dog-specific method
    public void wagTail() {
        System.out.println(name + " is wagging tail");
    }
}

class Cat extends Animal {
    private boolean isIndoor;
    
    public Cat(String name, int age, boolean isIndoor) {
        super(name, age);
        this.isIndoor = isIndoor;
    }
    
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
    
    @Override
    public void move() {
        System.out.println(name + " is sneaking");
    }
    
    // Cat-specific method
    public void purr() {
        System.out.println(name + " is purring");
    }
}

// 3. POLYMORPHISM - One interface, multiple implementations
interface Shape {
    double getArea();
    double getPerimeter();
    void draw();
}

class Circle implements Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle implements Shape {
    private double width, height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double getArea() {
        return width * height;
    }
    
    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}

// 4. ABSTRACTION - Hiding complexity, showing essential features
abstract class Vehicle {
    protected String brand;
    protected int year;
    
    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }
    
    // Abstract methods - complex operations hidden
    public abstract void startEngine();
    public abstract void accelerate();
    public abstract void brake();
    
    // Concrete method - simple operation visible
    public void displayInfo() {
        System.out.println("Vehicle: " + brand + " " + year);
    }
    
    // Template method - defines algorithm structure
    public void drive() {
        System.out.println("Starting driving sequence...");
        startEngine();
        accelerate();
        System.out.println("Vehicle is moving");
        brake();
        System.out.println("Driving sequence complete");
    }
}

class Car extends Vehicle {
    public Car(String brand, int year) {
        super(brand, year);
    }
    
    @Override
    public void startEngine() {
        System.out.println("Starting car engine with key");
    }
    
    @Override
    public void accelerate() {
        System.out.println("Pressing gas pedal");
    }
    
    @Override
    public void brake() {
        System.out.println("Pressing brake pedal");
    }
}

// SOLID PRINCIPLES DEMONSTRATION

// S - Single Responsibility Principle
class EmailService {
    public void sendEmail(String to, String subject, String body) {
        System.out.println("Sending email to: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
    }
}

class EmailValidator {
    public boolean isValid(String email) {
        return email.contains("@") && email.contains(".");
    }
}

// O - Open/Closed Principle
interface PaymentProcessor {
    void processPayment(double amount);
}

class CreditCardProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment: $" + amount);
    }
}

class PayPalProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment: $" + amount);
    }
}

// L - Liskov Substitution Principle
class Bird {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Sparrow extends Bird {
    @Override
    public void fly() {
        System.out.println("Sparrow is flying high");
    }
}

// I - Interface Segregation Principle
interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

interface Fax {
    void fax();
}

class MultiFunctionMachine implements Printer, Scanner, Fax {
    @Override
    public void print() {
        System.out.println("Printing document");
    }
    
    @Override
    public void scan() {
        System.out.println("Scanning document");
    }
    
    @Override
    public void fax() {
        System.out.println("Faxing document");
    }
}

class SimplePrinter implements Printer {
    @Override
    public void print() {
        System.out.println("Printing document");
    }
}

// D - Dependency Inversion Principle
interface MessageService {
    void sendMessage(String message);
}

class EmailService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Email: " + message);
    }
}

class SMSService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("SMS: " + message);
    }
}

class NotificationManager {
    private MessageService messageService;
    
    // Dependency injection
    public NotificationManager(MessageService messageService) {
        this.messageService = messageService;
    }
    
    public void sendNotification(String message) {
        messageService.sendMessage(message);
    }
}

public class OOPPrinciplesDemo {
    public static void main(String[] args) {
        System.out.println("=== ENCAPSULATION ===");
        BankAccount account = new BankAccount("12345", 1000.0);
        account.deposit(500);
        account.withdraw(200);
        System.out.println("Balance: $" + account.getBalance());
        
        System.out.println("\n=== INHERITANCE ===");
        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
        Cat cat = new Cat("Whiskers", 2, true);
        
        dog.sleep();
        dog.makeSound();
        dog.move();
        dog.wagTail();
        
        cat.sleep();
        cat.makeSound();
        cat.move();
        cat.purr();
        
        System.out.println("\n=== POLYMORPHISM ===");
        Shape[] shapes = {
            new Circle(5.0),
            new Rectangle(4.0, 6.0)
        };
        
        for (Shape shape : shapes) {
            shape.draw();
            System.out.println("Area: " + shape.getArea());
            System.out.println("Perimeter: " + shape.getPerimeter());
        }
        
        System.out.println("\n=== ABSTRACTION ===");
        Vehicle car = new Car("Toyota", 2022);
        car.displayInfo();
        car.drive();
        
        System.out.println("\n=== SOLID PRINCIPLES ===");
        NotificationManager emailNotifier = new NotificationManager(new EmailService());
        emailNotifier.sendNotification("Hello via Email!");
        
        NotificationManager smsNotifier = new NotificationManager(new SMSService());
        smsNotifier.sendNotification("Hello via SMS!");
    }
}

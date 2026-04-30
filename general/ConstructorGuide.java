package general;
//  Java Constructors - Complete Guide

// 1. BASIC CONSTRUCTOR
class Person {
    private String name;
    private int age;
    
    // Default constructor (no-argument)
    public Person() {
        System.out.println("Default constructor called");
        this.name = "Unknown";
        this.age = 0;
    }
    
    // Parameterized constructor
    public Person(String name, int age) {
        System.out.println("Parameterized constructor called");
        this.name = name;
        this.age = age;
    }
    
    // Copy constructor
    public Person(Person other) {
        System.out.println("Copy constructor called");
        this.name = other.name;
        this.age = other.age;
    }
    
    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
    
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

// 2. CONSTRUCTOR OVERLOADING
class Student {
    private String name;
    private int age;
    private String major;
    private double gpa;
    
    // Constructor 1: Only name
    public Student(String name) {
        this(name, 18, "Undeclared", 0.0);
        System.out.println("Constructor: Student(String name)");
    }
    
    // Constructor 2: Name and age
    public Student(String name, int age) {
        this(name, age, "Undeclared", 0.0);
        System.out.println("Constructor: Student(String name, int age)");
    }
    
    // Constructor 3: Name, age, major
    public Student(String name, int age, String major) {
        this(name, age, major, 0.0);
        System.out.println("Constructor: Student(String name, int age, String major)");
    }
    
    // Constructor 4: All parameters
    public Student(String name, int age, String major, double gpa) {
        System.out.println("Constructor: Student(String name, int age, String major, double gpa)");
        this.name = name;
        this.age = age;
        this.major = major;
        this.gpa = gpa;
    }
    
    // Copy constructor
    public Student(Student other) {
        this(other.name, other.age, other.major, other.gpa);
        System.out.println("Copy constructor called");
    }
    
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", major='" + major + "', gpa=" + gpa + "}";
    }
}

// 3. CONSTRUCTOR CHAINING WITH this()
class Employee {
    private String name;
    private int id;
    private String department;
    private double salary;
    
    // Main constructor
    public Employee(String name, int id, String department, double salary) {
        System.out.println("Main constructor: Employee(String, int, String, double)");
        this.name = name;
        this.id = id;
        this.department = department;
        this.salary = salary;
    }
    
    // Constructor chaining to main constructor
    public Employee(String name, int id, String department) {
        this(name, id, department, 50000.0); // Calls main constructor
        System.out.println("Chained to: Employee(String, int, String)");
    }
    
    public Employee(String name, int id) {
        this(name, id, "General"); // Calls 3-parameter constructor
        System.out.println("Chained to: Employee(String, int)");
    }
    
    public Employee(String name) {
        this(name, 0); // Calls 2-parameter constructor
        System.out.println("Chained to: Employee(String)");
    }
    
    public Employee() {
        this("Unknown"); // Calls 1-parameter constructor
        System.out.println("Chained to: Employee()");
    }
    
    @Override
    public String toString() {
        return "Employee{name='" + name + "', id=" + id + ", department='" + department + "', salary=" + salary + "}";
    }
}

// 4. INHERITANCE AND super() CALLS
class Vehicle {
    protected String brand;
    protected int year;
    
    // Vehicle constructor
    public Vehicle(String brand, int year) {
        System.out.println("Vehicle constructor called");
        this.brand = brand;
        this.year = year;
    }
    
    // Default constructor
    public Vehicle() {
        System.out.println("Vehicle default constructor called");
        this.brand = "Unknown";
        this.year = 2020;
    }
    
    @Override
    public String toString() {
        return "Vehicle{brand='" + brand + "', year=" + year + "}";
    }
}

class Car extends Vehicle {
    private String model;
    private int doors;
    
    // Constructor with super() call
    public Car(String brand, int year, String model, int doors) {
        super(brand, year); // Must be first statement
        System.out.println("Car constructor called");
        this.model = model;
        this.doors = doors;
    }
    
    // Constructor using default super()
    public Car(String model, int doors) {
        // super() automatically called
        System.out.println("Car constructor (default super) called");
        this.model = model;
        this.doors = doors;
    }
    
    // Constructor chaining within subclass
    public Car(String brand, String model) {
        this(brand, 2023, model, 4); // Calls another constructor in this class
        System.out.println("Car constructor chaining called");
    }
    
    @Override
    public String toString() {
        return "Car{" + super.toString() + ", model='" + model + "', doors=" + doors + "}";
    }
}

// 5. PRIVATE CONSTRUCTORS (Singleton Pattern)
class DatabaseConnection {
    private static DatabaseConnection instance;
    private String connectionUrl;
    
    // Private constructor prevents external instantiation
    private DatabaseConnection() {
        System.out.println("DatabaseConnection private constructor called");
        this.connectionUrl = "jdbc:mysql://localhost:3306/mydb";
    }
    
    // Static factory method
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
    
    public void connect() {
        System.out.println("Connecting to: " + connectionUrl);
    }
    
    public String getConnectionUrl() {
        return connectionUrl;
    }
}

// 6. CONSTRUCTOR WITH INITIALIZATION BLOCKS
class ComplexClass {
    private static int objectCount;
    private int id;
    private String name;
    
    // Static initialization block
    static {
        System.out.println("Static initialization block - runs once");
        objectCount = 0;
    }
    
    // Instance initialization block 1
    {
        System.out.println("Instance initialization block 1");
        objectCount++;
        this.id = objectCount;
    }
    
    // Instance initialization block 2
    {
        System.out.println("Instance initialization block 2");
        this.name = "Object_" + id;
    }
    
    // Constructor
    public ComplexClass() {
        System.out.println("Constructor called");
        System.out.println("Created object: " + name + " with ID: " + id);
    }
    
    public static int getObjectCount() {
        return objectCount;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
}

// 7. CONSTRUCTOR EXCEPTION HANDLING
class FileProcessor {
    private String filename;
    private boolean fileExists;
    
    public FileProcessor(String filename) throws IllegalArgumentException {
        System.out.println("FileProcessor constructor called");
        
        if (filename == null || filename.trim().isEmpty()) {
            throw new IllegalArgumentException("Filename cannot be null or empty");
        }
        
        this.filename = filename;
        // Simulate file existence check
        this.fileExists = !filename.equals("nonexistent.txt");
        
        if (!fileExists) {
            throw new IllegalArgumentException("File does not exist: " + filename);
        }
        
        System.out.println("FileProcessor created for: " + filename);
    }
    
    public String getFilename() { return filename; }
    public boolean fileExists() { return fileExists; }
}

// 8. CONSTRUCTOR IN ABSTRACT CLASS
abstract class Animal {
    protected String name;
    protected int age;
    
    // Abstract class constructor
    public Animal(String name, int age) {
        System.out.println("Animal constructor called");
        this.name = name;
        this.age = age;
    }
    
    // Abstract method
    public abstract void makeSound();
    
    // Concrete method
    public void sleep() {
        System.out.println(name + " is sleeping");
    }
    
    @Override
    public String toString() {
        return "Animal{name='" + name + "', age=" + age + "}";
    }
}

class Dog extends Animal {
    private String breed;
    
    // Must call super() constructor
    public Dog(String name, int age, String breed) {
        super(name, age); // Calls Animal constructor
        System.out.println("Dog constructor called");
        this.breed = breed;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof!");
    }
    
    @Override
    public String toString() {
        return "Dog{" + super.toString() + ", breed='" + breed + "'}";
    }
}

public class ConstructorGuide {
    public static void main(String[] args) {
        System.out.println("=== BASIC CONSTRUCTORS ===");
        Person person1 = new Person();
        Person person2 = new Person("Alice", 25);
        Person person3 = new Person(person2);
        
        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
        
        System.out.println("\n=== CONSTRUCTOR OVERLOADING ===");
        Student student1 = new Student("John");
        Student student2 = new Student("Jane", 20);
        Student student3 = new Student("Bob", 21, "Computer Science");
        Student student4 = new Student("Alice", 22, "Mathematics", 3.8);
        
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        System.out.println(student4);
        
        System.out.println("\n=== CONSTRUCTOR CHAINING ===");
        Employee emp1 = new Employee();
        Employee emp2 = new Employee("John");
        Employee emp3 = new Employee("Jane", 1001);
        Employee emp4 = new Employee("Bob", 1002, "IT");
        Employee emp5 = new Employee("Alice", 1003, "HR", 75000.0);
        
        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(emp3);
        System.out.println(emp4);
        System.out.println(emp5);
        
        System.out.println("\n=== INHERITANCE AND super() ===");
        Car car1 = new Car("Toyota", 2023, "Camry", 4);
        Car car2 = new Car("Honda", "Civic");
        Car car3 = new Car("Accord", 2);
        
        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);
        
        System.out.println("\n=== PRIVATE CONSTRUCTOR (SINGLETON) ===");
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        
        System.out.println("Same instance: " + (db1 == db2));
        db1.connect();
        
        System.out.println("\n=== INITIALIZATION BLOCKS ===");
        ComplexClass obj1 = new ComplexClass();
        ComplexClass obj2 = new ComplexClass();
        ComplexClass obj3 = new ComplexClass();
        
        System.out.println("Total objects created: " + ComplexClass.getObjectCount());
        
        System.out.println("\n=== CONSTRUCTOR EXCEPTION HANDLING ===");
        try {
            FileProcessor fp1 = new FileProcessor("data.txt");
            System.out.println("FileProcessor created: " + fp1.getFilename());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        try {
            FileProcessor fp2 = new FileProcessor("nonexistent.txt");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        try {
            FileProcessor fp3 = new FileProcessor("");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("\n=== ABSTRACT CLASS CONSTRUCTOR ===");
        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
        System.out.println(dog);
        dog.makeSound();
        dog.sleep();
    }
}

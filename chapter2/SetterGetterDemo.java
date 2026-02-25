package chapter2;

/**
 * Demonstration of Setter and Getter Methods Usage
 * Shows practical examples with validation and business logic
 */

public class SetterGetterDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Setter and Getter Methods Demonstration ===\n");
        
        // Example 1: Basic validation
        demonstrateValidation();
        
        // Example 2: Business logic in setters
        demonstrateBusinessLogic();
        
        // Example 3: Read-only properties
        demonstrateReadOnlyProperties();
        
        // Example 4: Computed values in getters
        demonstrateComputedValues();
    }
    
    /**
     * Example 1: Basic validation in setters
     */
    public static void demonstrateValidation() {
        System.out.println("1. Basic Validation Example:");
        
        Student student = new Student();
        
        // Valid input
        student.setAge(20);
        student.setGpa(3.8);
        System.out.println("Student age: " + student.getAge());
        System.out.println("Student GPA: " + student.getGpa());
        
        // Invalid input - will throw exception
        try {
            student.setAge(-5); // Invalid age
        } catch (IllegalArgumentException e) {
            System.out.println("Validation caught: " + e.getMessage());
        }
        
        try {
            student.setGpa(5.0); // Invalid GPA
        } catch (IllegalArgumentException e) {
            System.out.println("Validation caught: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Example 2: Business logic in setters
     */
    public static void demonstrateBusinessLogic() {
        System.out.println("2. Business Logic Example:");
        
        BankAccount account = new BankAccount("12345");
        
        account.setBalance(1000.0);
        System.out.println("Initial balance: $" + account.getBalance());
        
        // Setting negative balance triggers business logic
        try {
            account.setBalance(-100.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Business rule: " + e.getMessage());
        }
        
        // Setting high balance triggers premium status
        account.setBalance(10000.0);
        System.out.println("New balance: $" + account.getBalance());
        System.out.println("Account status: " + account.getAccountStatus());
        
        System.out.println();
    }
    
    /**
     * Example 3: Read-only properties
     */
    public static void demonstrateReadOnlyProperties() {
        System.out.println("3. Read-only Properties Example:");
        
        Employee employee = new Employee("John Doe", "EMP001");
        
        // Can read employee ID (no setter available)
        System.out.println("Employee ID: " + employee.getEmployeeId());
        
        // Can change name (has setter)
        employee.setName("John Smith");
        System.out.println("Updated name: " + employee.getName());
        
        // Cannot change employee ID - no setter method
        System.out.println("Employee ID remains: " + employee.getEmployeeId());
        
        System.out.println();
    }
    
    /**
     * Example 4: Computed values in getters
     */
    public static void demonstrateComputedValues() {
        System.out.println("4. Computed Values Example:");
        
        Rectangle rectangle = new Rectangle(5.0, 3.0);
        
        System.out.println("Width: " + rectangle.getWidth());
        System.out.println("Height: " + rectangle.getHeight());
        
        // Area is computed in getter, not stored
        System.out.println("Area (computed): " + rectangle.getArea());
        
        // Perimeter is also computed
        System.out.println("Perimeter (computed): " + rectangle.getPerimeter());
        
        // Change dimensions and computed values update automatically
        rectangle.setWidth(10.0);
        System.out.println("New area: " + rectangle.getArea());
        
        System.out.println();
    }
}

/**
 * Student class with validation examples
 */
class Student {
    private String name;
    private int age;
    private double gpa;
    
    // Setter with validation
    public void setAge(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age must be between 0 and 120");
        }
        this.age = age;
        System.out.println("Age set to: " + age);
    }
    
    // Setter with range validation
    public void setGpa(double gpa) {
        if (gpa < 0.0 || gpa > 4.0) {
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0");
        }
        this.gpa = gpa;
        System.out.println("GPA set to: " + gpa);
    }
    
    // Getters
    public int getAge() { return age; }
    public double getGpa() { return gpa; }
    
    public void setName(String name) {
        this.name = name != null ? name.trim() : "";
    }
    
    public String getName() { return name; }
}

/**
 * BankAccount class with business logic
 */
class BankAccount {
    private String accountNumber;
    private double balance;
    private boolean isPremium;
    
    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.isPremium = false;
    }
    
    // Setter with business logic
    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        
        this.balance = balance;
        
        // Business logic: automatically update premium status
        if (balance >= 5000.0) {
            this.isPremium = true;
            System.out.println("Account upgraded to Premium status!");
        } else {
            this.isPremium = false;
        }
    }
    
    public double getBalance() { return balance; }
    
    // Read-only computed property
    public String getAccountStatus() {
        return isPremium ? "Premium" : "Standard";
    }
    
    public String getAccountNumber() { return accountNumber; }
}

/**
 * Employee class with read-only property
 */
class Employee {
    private String name;
    private final String employeeId; // Final - can only be set in constructor
    
    public Employee(String name, String employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }
    
    // Setter for name (can be changed)
    public void setName(String name) {
        this.name = name != null ? name.trim() : "";
    }
    
    // No setter for employeeId (read-only)
    public String getName() { return name; }
    public String getEmployeeId() { return employeeId; }
}

/**
 * Rectangle class with computed values
 */
class Rectangle {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        setWidth(width);
        setHeight(height);
    }
    
    // Setters with validation
    public void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be positive");
        }
        this.width = width;
    }
    
    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be positive");
        }
        this.height = height;
    }
    
    // Getters
    public double getWidth() { return width; }
    public double getHeight() { return height; }
    
    // Computed values - not stored as fields
    public double getArea() {
        return width * height;
    }
    
    public double getPerimeter() {
        return 2 * (width + height);
    }
}

// Java Program Structure Example

// Package declaration (optional but recommended)
package com.example.programstructure;

// Import statements
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// Public class (must match filename)
public class JavaProgramStructure {
    
    // Static variables (class-level)
    private static final String PROGRAM_NAME = "Java Structure Demo";
    private static int instanceCount = 0;
    
    // Instance variables (object-level)
    private String name;
    private int value;
    private List<String> items;
    
    // Static initializer block
    static {
        System.out.println("Static initializer - runs once when class loads");
        instanceCount = 0;
    }
    
    // Instance initializer block
    {
        System.out.println("Instance initializer - runs before constructor");
        items = new ArrayList<>();
    }
    
    // Constructors
    public JavaProgramStructure() {
        this("Default", 0);
    }
    
    public JavaProgramStructure(String name, int value) {
        this.name = name;
        this.value = value;
        instanceCount++;
        System.out.println("Constructor called for: " + name);
    }
    
    // Main method - program entry point
    public static void main(String[] args) {
        System.out.println("=== " + PROGRAM_NAME + " ===");
        System.out.println("Program started with " + args.length + " arguments");
        
        // Demonstrate program structure
        JavaProgramStructure demo = new JavaProgramStructure("Demo", 42);
        demo.demonstrateStructure();
        
        // Show static method usage
        showProgramInfo();
        
        // Demonstrate inner classes
        InnerClassExample innerExample = new InnerClassExample();
        innerExample.showInnerClassUsage();
    }
    
    // Instance methods
    public void demonstrateStructure() {
        System.out.println("\n=== Instance Method Demonstration ===");
        System.out.println("Name: " + name);
        System.out.println("Value: " + value);
        
        // Call private method
        String result = privateHelper();
        System.out.println("Private helper result: " + result);
        
        // Use local variables
        int localVar = 100;
        System.out.println("Local variable: " + localVar);
        
        // Control structures
        if (value > 50) {
            System.out.println("Value is greater than 50");
        } else {
            System.out.println("Value is 50 or less");
        }
        
        // Loop structure
        for (int i = 0; i < 3; i++) {
            items.add("Item " + i);
        }
        
        // Enhanced for loop
        for (String item : items) {
            System.out.println(item);
        }
    }
    
    // Private helper method
    private String privateHelper() {
        return "Helper method executed";
    }
    
    // Static methods
    public static void showProgramInfo() {
        System.out.println("\n=== Static Method Demonstration ===");
        System.out.println("Program: " + PROGRAM_NAME);
        System.out.println("Instances created: " + instanceCount);
    }
    
    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public int getValue() { return value; }
    public void setValue(int value) { this.value = value; }
    
    // toString method
    @Override
    public String toString() {
        return "JavaProgramStructure{name='" + name + "', value=" + value + "}";
    }
    
    // Inner class example
    public class InnerClassExample {
        private String innerField = "Inner class field";
        
        public void showInnerClassUsage() {
            System.out.println("\n=== Inner Class Demonstration ===");
            System.out.println("Inner field: " + innerField);
            System.out.println("Outer field: " + name);
            
            // Access outer class methods
            privateHelper();
        }
    }
    
    // Static nested class
    public static class StaticNestedClass {
        private static String staticField = "Static nested class";
        
        public static void showStaticNested() {
            System.out.println("\n=== Static Nested Class Demonstration ===");
            System.out.println("Static field: " + staticField);
            System.out.println("Program name: " + PROGRAM_NAME);
            // Cannot access instance members of outer class
        }
    }
    
    // Enum example
    public enum Status {
        ACTIVE("Active", 1),
        INACTIVE("Inactive", 0),
        PENDING("Pending", 2);
        
        private final String description;
        private final int code;
        
        Status(String description, int code) {
            this.description = description;
            this.code = code;
        }
        
        public String getDescription() { return description; }
        public int getCode() { return code; }
    }
}

// Separate class in same file (must be non-public)
class HelperClass {
    public static void help() {
        System.out.println("Helper class method called");
    }
}

// Interface example
interface Processable {
    void process();
    default void display() {
        System.out.println("Default display method");
    }
}

// Class implementing interface
class Processor implements Processable {
    @Override
    public void process() {
        System.out.println("Processing data");
    }
    
    @Override
    public void display() {
        System.out.println("Custom display method");
    }
}

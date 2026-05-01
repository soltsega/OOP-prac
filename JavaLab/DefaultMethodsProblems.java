package JavaLab;
// Problems with Java Default Methods

// 1. DIAMOND PROBLEM - Multiple Inheritance Conflict
interface InterfaceA {
    default void display() {
        System.out.println("InterfaceA display()");
    }
    
    default void commonMethod() {
        System.out.println("InterfaceA commonMethod()");
    }
}

interface InterfaceB {
    default void display() {
        System.out.println("InterfaceB display()");
    }
    
    default void commonMethod() {
        System.out.println("InterfaceB commonMethod()");
    }
}

// PROBLEM: Class must resolve conflicts
class ProblematicClass implements InterfaceA, InterfaceB {
    // MUST override conflicting default methods
    @Override
    public void display() {
        System.out.println("ProblematicClass display()");
        // Must explicitly choose which interface method to use
        InterfaceA.super.display(); // or InterfaceB.super.display()
    }
    
    @Override
    public void commonMethod() {
        System.out.println("ProblematicClass commonMethod()");
        InterfaceB.super.commonMethod(); // Choose InterfaceB's version
    }
}

// 2. INHERITANCE VS INTERFACE CONFLICT
class ParentClass {
    public void display() {
        System.out.println("ParentClass display()");
    }
}

interface ParentInterface {
    default void display() {
        System.out.println("ParentInterface display()");
    }
}

// PROBLEM: Class method wins over interface default method
class ChildClass extends ParentClass implements ParentInterface {
    // No override needed - class method takes precedence
    public void testPrecedence() {
        display(); // Calls ParentClass.display(), not interface default
    }
}

// 3. BREAKING CHANGES IN INTERFACES
interface OriginalInterface {
    void existingMethod();
}

// PROBLEM: Adding default method can still cause issues
interface ExtendedInterface extends OriginalInterface {
    default void newDefaultMethod() {
        System.out.println("New default method");
    }
    
    // PROBLEM: If this was added to OriginalInterface directly
    // all existing implementations would need to recompile
}

// 4. DEFAULT METHOD CALLING SUPER CLASS METHODS
interface SuperCallingInterface {
    default void process() {
        System.out.println("Interface process start");
        // PROBLEM: Cannot call super class methods directly
        // super.toString(); // ERROR - super refers to Object class
        System.out.println("Interface process end");
    }
}

// 5. DEFAULT METHODS WITH GENERICS - COMPLEX CONFLICTS
interface GenericInterface<T> {
    default void process(T item) {
        System.out.println("Processing: " + item);
    }
}

interface AnotherGenericInterface<T> {
    default void process(T item) {
        System.out.println("Another processing: " + item);
    }
}

// PROBLEM: Generic type erasure conflicts
class GenericConflict implements GenericInterface<String>, AnotherGenericInterface<String> {
    @Override
    public void process(String item) {
        System.out.println("GenericConflict processing: " + item);
        GenericInterface.super.process(item); // Must specify which interface
    }
}

// 6. DEFAULT METHODS AND PRIVATE METHODS (Java 9+)
interface PrivateMethodInterface {
    default void complexOperation() {
        validateInput();
        performOperation();
        cleanup();
    }
    
    default void anotherOperation() {
        validateInput(); // Reuse private method
        performDifferentOperation();
        cleanup(); // Reuse private method
    }
    
    // SOLUTION: Private methods help with code reuse
    private void validateInput() {
        System.out.println("Validating input");
    }
    
    private void performOperation() {
        System.out.println("Performing main operation");
    }
    
    private void performDifferentOperation() {
        System.out.println("Performing different operation");
    }
    
    private void cleanup() {
        System.out.println("Cleaning up resources");
    }
}

// 7. DEFAULT METHODS IN INHERITANCE HIERARCHY
interface GrandparentInterface {
    default void display() {
        System.out.println("Grandparent display()");
    }
}

interface ParentInterface extends GrandparentInterface {
    @Override
    default void display() {
        System.out.println("Parent display()");
        GrandparentInterface.super.display(); // Call grandparent
    }
}

// PROBLEM: Complex inheritance chain
class ComplexInheritance implements ParentInterface {
    @Override
    public void display() {
        System.out.println("Class display()");
        ParentInterface.super.display(); // Calls parent, which calls grandparent
    }
}

// 8. DEFAULT METHODS AND STATIC METHODS
interface StaticAndDefaultInterface {
    default void instanceMethod() {
        System.out.println("Default instance method");
        staticHelper(); // Can call static methods
    }
    
    static void staticMethod() {
        System.out.println("Static method");
        // Cannot call instance methods from static context
        // instanceMethod(); // ERROR
    }
    
    private static void staticHelper() {
        System.out.println("Static helper method");
    }
}

// 9. REAL-WORLD PROBLEM EXAMPLES
interface Logger {
    default void log(String message) {
        System.out.println("LOG: " + message);
    }
    
    default void logError(String error) {
        System.out.println("ERROR: " + error);
    }
}

interface DatabaseLogger extends Logger {
    @Override
    default void log(String message) {
        System.out.println("DB LOG: " + message);
    }
    
    @Override
    default void logError(String error) {
        System.out.println("DB ERROR: " + error);
        // PROBLEM: Cannot call Logger.super.logError() from here if extended
    }
}

interface FileLogger extends Logger {
    @Override
    default void log(String message) {
        System.out.println("FILE LOG: " + message);
    }
}

// PROBLEM: Multiple logger implementations
class MultiLogger implements DatabaseLogger, FileLogger {
    @Override
    public void log(String message) {
        // Must choose which implementation to use
        DatabaseLogger.super.log(message);
    }
    
    @Override
    public void logError(String error) {
        // Must choose which implementation to use
        FileLogger.super.logError(error);
    }
}

// 10. DEFAULT METHODS AND FINAL CLASSES
final class FinalClass implements InterfaceA, InterfaceB {
    @Override
    public void display() {
        System.out.println("FinalClass display()");
        InterfaceA.super.display(); // Can still call interface methods
    }
}

public class DefaultMethodsProblems {
    public static void main(String[] args) {
        System.out.println("=== DEFAULT METHODS PROBLEMS ===\n");
        
        // 1. Diamond Problem Demonstration
        System.out.println("1. Diamond Problem:");
        ProblematicClass problematic = new ProblematicClass();
        problematic.display();
        problematic.commonMethod();
        
        System.out.println();
        
        // 2. Class vs Interface Precedence
        System.out.println("2. Class vs Interface Precedence:");
        ChildClass child = new ChildClass();
        child.testPrecedence();
        
        System.out.println();
        
        // 3. Generic Conflicts
        System.out.println("3. Generic Conflicts:");
        GenericConflict genericConflict = new GenericConflict();
        genericConflict.process("test");
        
        System.out.println();
        
        // 4. Complex Inheritance
        System.out.println("4. Complex Inheritance:");
        ComplexInheritance complex = new ComplexInheritance();
        complex.display();
        
        System.out.println();
        
        // 5. Private Methods in Interfaces
        System.out.println("5. Private Methods in Interfaces:");
        PrivateMethodInterface privateInterface = new PrivateMethodInterface() {};
        privateInterface.complexOperation();
        privateInterface.anotherOperation();
        
        System.out.println();
        
        // 6. Multi-Logger Problem
        System.out.println("6. Multi-Logger Problem:");
        MultiLogger multiLogger = new MultiLogger();
        multiLogger.log("Test message");
        multiLogger.logError("Test error");
        
        System.out.println();
        
        // 7. Static vs Default Methods
        System.out.println("7. Static vs Default Methods:");
        StaticAndDefaultInterface.staticMethod();
        StaticAndDefaultInterface instance = new StaticAndDefaultInterface() {};
        instance.instanceMethod();
        
        System.out.println();
        
        // 8. Final Class with Default Methods
        System.out.println("8. Final Class with Default Methods:");
        FinalClass finalClass = new FinalClass();
        finalClass.display();
        
        System.out.println();
        
        // 9. Interface Object Creation
        System.out.println("9. Interface Object Creation:");
        InterfaceA interfaceA = new InterfaceA() {}; // Anonymous class
        interfaceA.display();
        
        InterfaceB interfaceB = new InterfaceB() {}; // Anonymous class
        interfaceB.display();
        
        System.out.println();
        System.out.println("=== PROBLEMS SUMMARY ===");
        System.out.println("1. Diamond Problem: Multiple inheritance conflicts");
        System.out.println("2. Class Precedence: Class methods win over interface defaults");
        System.out.println("3. Generic Conflicts: Type erasure creates method signature conflicts");
        System.out.println("4. Complex Inheritance: Hard to trace method resolution");
        System.out.println("5. Breaking Changes: Adding defaults can still break existing code");
        System.out.println("6. Static Method Conflicts: Cannot call instance methods from static");
        System.out.println("7. Super Calling: Must use InterfaceName.super.method()");
        System.out.println("8. Design Complexity: Makes interfaces more like abstract classes");
    }
}

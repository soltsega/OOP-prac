// Common Errors and Bugs with Interfaces and Inheritance

// ERROR 1: Diamond Problem with Default Methods
interface A {
    default void show() { System.out.println("A"); }
}

interface B extends A {
    @Override
    default void show() { System.out.println("B"); }
}

interface C extends A {
    @Override
    default void show() { System.out.println("C"); }
}

// This class must resolve the conflict
class DiamondProblem implements B, C {
    @Override
    public void show() {
        // Must explicitly choose which implementation to use
        B.super.show(); // or C.super.show()
    }
}

// ERROR 2: Not implementing all abstract methods
interface Incomplete {
    void method1();
    void method2();
}

// This will cause compilation error
// class BadImplementation implements Incomplete {
//     @Override
//     public void method1() { } // Missing method2()
// }

// ERROR 3: Access modifier conflicts
interface PublicInterface {
    void publicMethod(); // Automatically public
}

// This will cause compilation error
// class BadAccess implements PublicInterface {
//     protected void publicMethod() { } // Cannot reduce visibility
// }

// ERROR 4: Return type conflicts
interface StringInterface {
    String getValue();
}

interface IntInterface {
    int getValue(); // Same name, different return type
}

// This will cause compilation error
// class ConflictReturn implements StringInterface, IntInterface {
//     // Cannot implement both - same signature, different return types
// }

// ERROR 5: Static method conflicts
interface StaticInterface {
    static void staticMethod() { System.out.println("Interface static"); }
}

class StaticConflict implements StaticInterface {
    // This is NOT overriding - it's a different method
    static void staticMethod() { System.out.println("Class static"); }
}

public class CommonErrorsDemo {
    public static void main(String[] args) {
        DiamondProblem diamond = new DiamondProblem();
        diamond.show(); // Output: "B"
        
        StaticInterface.staticMethod(); // Interface static method
        StaticConflict.staticMethod(); // Class static method - different method
    }
}

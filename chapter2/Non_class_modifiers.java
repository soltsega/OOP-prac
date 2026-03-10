package chapter2;

/**
 * Non-class modifiers:
 * 
 * 1. final:
 *    - Applied to class, field, method, or variable
 *    - Prevents modification or inheritance
 *    - final class: Cannot be subclassed
 *    - final method: Cannot be overridden
 *    - final variable: Cannot be reassigned after initialization
 * 
 * 2. abstract:
 *    - Applied to class
 *    - Abstract class: Cannot be instantiated, only subclassed
 *    - Abstract method: Must be implemented by subclass
 * 
 * 3. static:
 *    - Applied to field, method, or inner class
 *    - Static field: Belongs to class, not object
 *    - Static method: Belongs to class, not object
 *    - Static inner class: Cannot access non-static members
 * 
 * 4. synchronized:
 *    - Applied to method or block of code
 *    - Ensures thread-safe access to shared resources
 *    - Synchronized method: Only one thread can execute at a time
 *    - Synchronized block: Only one thread can execute the block at a time
 */


public class Non_class_modifiers {
    // what are non class modifiers?

    // Let's now generate code snippet of this?
    
    // Example of final class
    final class FinalClass {
        // Class cannot be subclassed
    }
    
    // Example of final method
    class FinalMethodClass {
        final void finalMethod() {
            // Method cannot be overridden
        }
    }
    
    // Example of final variable
    class FinalVariableClass {
        final int finalVariable = 10;
        
        void printFinalVariable() {
            // Variable cannot be reassigned
            System.out.println(finalVariable);
        }
    }
    
    // Example of abstract class
    abstract class AbstractClass {
        // Abstract class cannot be instantiated, only subclassed
    }
    
    // Example of abstract method
    class AbstractMethodClass extends AbstractClass {
        @Override
        abstract void abstractMethod();
    }
    
    // Example of static field and method
    class StaticClass {
        static int staticField = 20;
        
        static void staticMethod() {
            // Static field belongs to class, not object
            System.out.println(staticField);
        }
    }
    
    // Example of synchronized method
    class SynchronizedMethodClass {
        synchronized void synchronizedMethod() {
            // Only one thread can execute at a time
        }
    }
    
    // Example of synchronized block
    class SynchronizedBlockClass {
        void synchronizedBlock() {
            synchronized (this) {
                // Only one thread can execute the block at a time
            }
        }
    }
    

    
}

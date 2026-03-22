package OOP;


/**
 * Final methods
 * 
 * Final methods are methods that cannot be overridden
 * They are useful when you want to ensure that the method is not overridden
 * 
 * Example:
 * public class MyClass {
 *     public final void myMethod() {
 *         // Method cannot be overridden
 *     }
 * }
 * 
 * public class MySubclass extends MyClass {
 *     // Compiler error: Cannot override the final method from MyClass
 *     @Override
 *     public void myMethod() {
 *         // This method does not override myMethod from MyClass
 *     }
 * }
 */


public class FinalMethods{
    

    public static void main(String[] args) {
        FinalMethods obj = new FinalMethods();
        obj.finalMethod();
    }
    // Final method
    final void finalMethod() {
        System.out.println("This is a final method");
    }

    // Final method with final parameter
    final void finalMethodWithParameter(final int a) {
        System.out.println("The value of a is: " + a);
    }

    // Final method with final return type
    final int finalMethodWithReturnType() {
        return 10;
    }

    // Final method with final overridden method
    @Override
    final public String toString() {
        return "This is a final method";
    }

    // Final method with final overridden method in a final class
    public static final class FinalClass {
        @Override
        final public String toString() {
            return "This is a final method in a final class";
        }
    }

}
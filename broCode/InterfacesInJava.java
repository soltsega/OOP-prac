package broCode;

/**
 * Interfaces in Java
 * 
 * Interfaces are used for defining a contract for a class to implement.
 * An interface is a blueprint for a class, providing a set of methods that a class must implement.
 * 
 * An interface can have:
 * - Methods - methods that must be implemented by the class that implements the interface
 * - Static methods - methods that can be called directly on the interface itself
 * - Default methods - methods that can have a default implementation
 * - Constants - fields that are declared as static, final, and of a primitive type or String type
 * 
 * Note:
 * - An interface cannot be instantiated (i.e., you cannot create an object of an interface)
 * - A class that implements an interface must provide an implementation for all the methods in the interface
 * - A class can implement multiple interfaces
 * - By default, all the methods in an interface are public and abstract
 * - A class can extend only one class but can implement multiple interfaces
 * 
 * Example:
 * 
 * - Interfaces are open for extension but closed for modification - they can be extended to add new methods but cannot modify the existing methods
 * - Abstract classes are open for both extension and modification - they can be extended to add new methods and can also modify the existing methods
 * - can't have constructors
 * - can't have modifier other than public
 * - all attributes are static final public
 * - one child can inherit more than one interfaces
 * 
 * 
 */


interface MyInterface {
        void method1();
        int method2();
        static void method3() {
            System.out.println("This is a static method in the interface");
        }
    }

class MyClass implements MyInterface {
        @Override
        public void method1() {
            System.out.println("This is a method1 in the class");
        }

        @Override
        public int method2() {
            return 10;
        }
    }


public class InterfacesInJava {
       public static void main(String[] args) {
        MyInterface obj = new MyClass(); // Note: The variable 'obj' should be of type 'MyInterface' since MyClass implements MyInterface
        obj.method1();
        System.out.println(obj.method2());
        MyInterface.method3();
    }
    
}

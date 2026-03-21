package OOP;

/**
 * final clases are classes that can't be inherited
 * 
 * Notes on final classes:
 * 
 * 1. Final classes cannot be extended.
 * 2. Final classes cannot be subclassed.
 * 3. They are useful when you want to prevent inheritance.
 * 4. They are used to create immutable objects.
 * 5. Final classes cannot contain any abstract methods.
 * 6. Final classes can contain final methods.
 * 7. Final methods cannot be overridden in subclasses.
 * 8. Final methods are useful when you want to ensure that the method is not overridden.
 * 9. Final classes cannot contain any static fields that are not final.
 * 10. Final classes can contain static final fields.
 * 11. Final classes cannot contain any instance fields that are not final.
 * 12. Final classes can contain instance final fields.
 */

final class MyClass {
    void display() {
        System.out.println("This is final class");
    }
}
public class FinalClasses {
public static void main(){
    MyClass obj = new MyClass();
    obj.display();
}
    
    
}

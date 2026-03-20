package OOP;
/**
 * Anonymous Classes
 * They are used to create objects without creating a separate class file
 * They are useful when you need to override a method or implement an interface
 * They are defined and instantiated in a single expression
 */

class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

public class AnonymousClasses {
    public static void main(String[] args) {
        Animal animal = new Animal() {
            @Override
            public void makeSound() {
                System.out.println("Anonymous animal makes a sound");
            }
        };
        animal.makeSound();
    }
    
}

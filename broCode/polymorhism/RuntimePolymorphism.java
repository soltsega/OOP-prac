package broCode.polymorhism;

/**
 * Runtime polymorphism in Java is achieved through the use of methods overridden in subclasses.
 * The method that is executed at runtime is determined by the actual type of the object on which the method is called.
 * The method that is called is determined at runtime based on the object that is referenced by the variable.
 * The method that is executed is determined by the class of the object on which the method is called.
 * 
 * Java uses dynamic binding to implement runtime polymorphism. The method that is executed at runtime is determined by the actual type of the object.
 * This is known as late binding or dynamic binding.
 * 
 * The method that is called is determined at runtime based on the object that is referenced by the variable.
 * The method that is executed is determined by the class of the object on which the method is called.
 * 
 * To implement runtime polymorphism in Java:
 * 1. Create a class with a method.
 * 2. Create a subclass and override the method.
 * 3. Create an object of the subclass and call the method.
 * 
 * The method that is called is determined at runtime based on the object that is referenced by the variable.
 * The actual type of the object determines the method that is executed.
 * 
 * The method that is executed is determined by the class of the object on which the method is called.
 * The declared type of the variable determines the method that is called.
 * 
 * The method that is called is determined at runtime based on the object that is referenced by the variable.
 * The actual type of the object determines the method that is executed.
 * 
 * The method that is executed is determined by the class of the object on which the method is called.
 * The declared type of the variable determines the method that is called.
 * 
 * Note: The method that is called is determined at runtime based on the object that is referenced by the variable.
 * The actual type of the object determines the method that is executed.
 * The method that is executed is determined by the class of the object on which the method is called.
 * The declared type of the variable determines the method that is called.
 */



public class RuntimePolymorphism {
    
    public void runtimePolymorphism(int n) {
        Animal animal = new Cat();
        for (int i = 0; i < n; i++) {
            animal = new Dog(); // Changing the type of the reference variable doesn't affect the actual object
        }
        animal.eat();
    }
    
    class Animal {
        public void eat() {
            System.out.println("Animal is eating");
        }
    }
    
    class Dog extends Animal {
        @Override
        public void eat() {
            System.out.println("Dog is eating");
        }
    }
    
    class Cat extends Animal {
        @Override
        public void eat() {
            System.out.println("Cat is eating");
        }
    }
    
}

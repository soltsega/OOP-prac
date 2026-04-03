package classActivity.multiclass_inheritance;
class Animal {
    void eat() {
        System.out.println("Animal eats");
    }
}

class Mammal extends Animal {
    void breathe() {
        System.out.println("Mammal breathes");
    }
}

class Dog extends Mammal {
    void bark() {
        System.out.println("Dog barks");
    }
}

public class MultilevelHierarchyDemo {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();    // Inherited from Animal
        dog.breathe(); // Inherited from Mammal
        dog.bark();   // Own method
    }
}
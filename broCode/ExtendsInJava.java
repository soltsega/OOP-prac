package broCode;


/*
 extends is used to inherit from a class
 
 */

class Animal {
    public void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {
    public void bark() {
        System.out.println("Dog is barking");
    }
}

class Cat extends Animal {
    public void meow() {
        System.out.println("Cat is meowing");
    }
}

class Lion extends Cat {
    public void roar() {
        System.out.println("Lion is roaring");
    }
}

public class ExtendsInJava {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.eat();

        Dog dog = new Dog();
        dog.eat();
        dog.bark();

        Cat cat = new Cat();
        cat.eat();
        cat.meow();

        Lion lion = new Lion();
        lion.eat();
        lion.meow();
        lion.roar();
    }
}

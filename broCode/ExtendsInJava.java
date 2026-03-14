package broCode;


/*
 extends is used to inherit from a class

// multiple inheritance is not allowed in java
// but we can achieve similar behaviour by using interfaces
// interface is a contract that a class must implement
// a class can implement multiple interfaces
// a class can extend only one class

interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Fish implements Swimmable {
    @Override
    public void swim() {
        System.out.println("Fish is swimming");
    }
}

class Penguin extends Bird implements Swimmable {
    @Override
    public void fly() {
        System.out.println("Penguin is flying");
    }

    @Override
    public void swim() {
        System.out.println("Penguin is swimming");
    }
}


Forbidden things in java inheritance
1. one class can not extend more than one class
2. you can't inherit final classes or methods
3. you can't override final methods like this:
    // class Dog extends Animal {
    //     @Override
    //     public final void eat() {
    //         System.out.println("Dog is eating");
    //     }
    // }
4. you can't override static methods like this: They are mot involved in run time polymorhism
    // class Dog extends Animal {
    //     @Override
    //     public static void eat() {
    //         System.out.println("Dog is eating");
    //     }
    // }
5. you can't override methods to change their access modifiers like this:
// The data type of the inherited class can't be changed. But you can change the access modifier to be more accessible. like from protected to public
 - you can only expand the access modifier, not reduce it
  - allowed ones:
   - private -> default -> protected -> public but inheriting private methods are technically not inherited.

   👉The visibility of the access modifiers
   1. private: only accessible within the same class
   2. default: accessible within the same package and subclasses even if they are in different packages
   3. protected: accessible within the same package and subclasses
   4. public: accessible from anywhere



    / class Dog extends Animal {
    //     @Override
    //     public public void eat() {
    //         System.out.println("Dog is eating");
    //     }
    // }
6. you can't override methods to change their return type like this:
    // class Dog extends Animal {
    //     @Override
    //     public String eat() {
    //         System.out.println("Dog is eating");
    //         return "food";
    //     }
    // }
7. you can't override methods to change their exception specifications like this:
// you can't add new exception handling methods if they are not there in the inherited class
    // class Dog extends Animal {
    //     @Override
    //     public void eat() throws NullPointerException {
    //         System.out.println("Dog is eating");
    //     }
    // }

 
 */g

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

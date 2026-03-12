package broCode;

/*
The super object in java is used to refer to the parent class.
It is used to access parent class methods and variables.

*/

// one thing here, we can access static objects via the instantiated objects or the class names themselves but it is recommended to use the class names.
// e.g. System.out.println(); here you can see that out is a static object of the System class and we are accessing it via the class name.
// but we could do it like this: System system = new System(); system.out.println();


class Parent {
    public void sayHello() {
        System.out.println("Hello from parent");
        System.out.println("This is the parent class");
    }
}

class Child extends Parent {
    @Override
    public void sayHello() {
        super.sayHello();  // calls parent's sayHello() method
        System.out.println("Hello from child");
        System.out.println("This is the child class");
    }
}

public class SuperInJava {
    public static void main(String[] args) {
        Child child = new Child();
        child.sayHello();  // output: Hello from parent, Hello from child
    }
}

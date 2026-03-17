package broCode;
// import java.util.Scanner;

abstract class Shape {
    abstract void draw();
    
    public void printInfo() {
        System.out.println("This is an abstract class");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a rectangle");
    }
}

public class AbstractClasses {
    public static void main(String[] args) {
        Shape shape = new Circle();
        shape.draw();
        shape.printInfo();
        
        shape = new Rectangle();
        shape.draw();
        shape.printInfo();
    }
}
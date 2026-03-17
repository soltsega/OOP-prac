package broCode;


// is used to define classes and methods
// a process of hiding implementation details and showing only the essential features
// abstract classes can't be inherited directly
// can contain "abstract" methods which must be implemented
// can contain concrete methods which are inherited
    abstract class Shape{
        abstract void draw();   // This is an abstract method
    }

    class Rectangle extends Shape{
        @Override
        void draw(){
            System.out.println("Drawing a rectangle");
        }
    }

    class Circle extends Shape{
        @Override
        void draw(){
            System.out.println("Drawing a circle");
        }
    }


// abstract classes are preceded by "abstract" keyword
public class AbstractionInJava {
    

    public static void main(String [] args){

        Shape shape = new Rectangle();
        shape.draw();
        
        Shape shape2 = new Circle();
        shape2.draw();
    }
}

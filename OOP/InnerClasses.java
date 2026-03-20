package OOP;
/**
 * a class or classes in another class
 * 
 * we need to create an object of the outer class to create an object of the inner class
 * but we don't need to create an object of the inner class if the class is static
 */

class Car {
    class Engine {
        public void print() {
            System.out.println("Engine");
        }
    }

    class Wheel {
        public void print() {
            System.out.println("Wheel");
        }
    }
    
    static class Battery {
        public void print() {
            System.out.println("Battery");
        }
    }
}
public class InnerClasses {

    public static void main(String[] args) {
        Car car = new Car();
        Car.Engine engine = car.new Engine();
        Car.Wheel wheel = car.new Wheel();
        engine.print();
        wheel.print();
        
        Car.Battery battery = new Car.Battery();
        battery.print();
    }
    
}


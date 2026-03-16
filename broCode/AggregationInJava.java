package broCode;



/*
 * Aggregation :
 * - has a loose coupling. has no ownership
 * - is a way in which one object can be connected to another object.
 * - the object which is connected to another is called "aggregated object".
 * - the object which is connected to another is called "containing object".
 * - unlike composition, the containing object does not own the aggregated object.
 * - the containing object can exist independently of the aggregated object.
 * - the aggregated object can also exist independently of the containing object.
 * - the containing object does not control the life cycle of the aggregated object.
 * - it is a "has-a" relationship.
 * 
 * Example :
 * 
 * public class Car {
 *      private Engine engine;
 *      public Car(Engine engine) {
 *          this.engine = engine;
 *      }
 * }
 * 
 * public class Engine {
 *      // ...
 * }
 * 
 * In the above example, the Car class has an Engine object as an aggregation.
 * The Engine object can exist independently of the Car object.
 * The Car object can also exist independently of the Engine object.
 * The Car object does not control the life cycle of the Engine object.
 */

public class AggregationInJava {
    
    private Engine engine;
    
    public AggregationInJava(Engine engine) {
        this.engine = engine;
    }
    
    public void startEngine() {
        engine.start();
    }
    
    public void stopEngine() {
        engine.stop();
    }
    
    public static void main(String[] args) {
        Engine engine = new Engine();
        AggregationInJava car = new AggregationInJava(engine);
        
        // Engine object can exist independently of the Car object.
        engine.start();
        
        // Car object can also exist independently of the Engine object.
        car.startEngine();
        
        // The Car object does not control the life cycle of the Engine object.
        engine = null;
        
        // The containing object does not own the aggregated object.
        System.gc();
    }
    
    static class Engine {
        public void start() {
            System.out.println("Engine started");
        }
        
        public void stop() {
            System.out.println("Engine stopped");
        }
    }
    
}

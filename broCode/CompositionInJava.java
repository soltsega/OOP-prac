package broCode;


/**
 * Composition :
 * - has a tight coupling. has full ownership
 * - is a way in which one object can be connected to another object.
 * - the object which is connected to another is called "aggregated object".
 * - the object which is connected to another is called "containing object".
 * - unlike aggregation, the containing object owns the aggregated object.
 * - the containing object can exist independently of the aggregated object.
 * - the aggregated object cannot exist independently of the containing object.
 * - the containing object controls the life cycle of the aggregated object.
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
 * In the above example, the Car class has an Engine object as an aggregation. The containing object owns the aggregated object.
 * The containing object cannot exist independently of the aggregated object.
 * The containing object controls the life cycle of the aggregated object.
 *
 */

public class Engine {
    public void start(){

    }

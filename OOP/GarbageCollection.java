package OOP;

/**
 * Java Garbage Collection
 * 
 * Java automatically reclaims memory occupied by objects that are no longer
 * reachable by the running program. This process is known as garbage
 * collection.
 * 
 * Java uses a mark-and-sweep algorithm for garbage collection. The algorithm
 * works in two phases: marking and sweeping.
 * 
 * 1. Marking phase: In this phase, the JVM identifies all the objects that are
 * reachable by the program. An object is considered reachable if it's
 * accessible from any live thread, meaning it's used somewhere in the code.
 * 
 * 2. Sweeping phase: In this phase, the JVM releases all the memory occupied
 * by objects that are not marked in the marking phase. This process is called
 * sweeping.
 * 
 * Java also has a garbage collector which is responsible for garbage
 * collection. The garbage collector runs in the background and periodically
 * checks for objects that are no longer reachable and reclaims their memory.
 * 
 * Some other important aspects of Java garbage collection are:
 * 
 * - Young Generation: All new objects are created in the young generation.
 * They are allocated in the heap and are garbage collected more frequently.
 * 
 * - Old Generation: Objects that survive in the young generation are promoted
 * to the old generation. The old generation is garbage collected less
 * frequently.
 * 
 * - Perm Generation: It's used to store permanent objects such as class
 * metadata, method code, and interned strings.
 * 
 * - Garbage Collection Algorithms: Java uses a variety of garbage collection
 * algorithms including mark-and-sweep, generational garbage collection,
 * concurrent garbage collection, and compacting garbage collection.
 * 
 * - Garbage Collection Parameters: You can tune the behavior of the garbage
 * collector using JVM parameters. -Xms and -Xmx are commonly used.
 */


public class GarbageCollection {

    public static void main(){
        // Garbage Collection using finalize and gc methods
        // Finalize method is used to perform cleanup operations
        // before an object is garbage collected
        // Gc method is used to invoke garbage collection
        class Person {
            String name;

            public Person(String name) {
                this.name = name;
            }

            @Override
            protected void finalize() throws Throwable {
                System.out.println("Finalize method called for " + name);
            }
        }

        Person p1 = new Person("John");
        Person p2 = new Person("Jane");

        // Garbage Collection
        p1 = null;
        p2 = null;

        // Invoke garbage collection
        System.gc();

        // Wait for garbage collection
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

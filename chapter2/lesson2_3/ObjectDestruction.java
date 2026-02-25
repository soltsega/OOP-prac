package chapter2.lesson2_3;

/**
 * 2.3.5. Destroying Objects
 * 
 * This lesson demonstrates how objects are destroyed in Java:
 * - Garbage collection mechanism
 * - Making objects eligible for GC
 * - finalize() method (deprecated)
 * - Try-with-resources pattern
 * - Weak references
 */

public class ObjectDestruction {
    
    public static void main(String[] args) {
        System.out.println("=== 2.3.5. Destroying Objects ===\n");
        
        // 1. Basic garbage collection
        demonstrateBasicGC();
        
        // 2. Making objects eligible for GC
        demonstrateGCEligibility();
        
        // 3. finalize() method (deprecated)
        demonstrateFinalize();
        
        // 4. Try-with-resources pattern
        demonstrateTryWithResources();
        
        // 5. Weak references
        demonstrateWeakReferences();
        
        // 6. Memory leak prevention
        demonstrateMemoryLeakPrevention();
    }
    
    public static void demonstrateBasicGC() {
        System.out.println("1. Basic Garbage Collection:");
        
        // Create objects
        for (int i = 0; i < 5; i++) {
            TempObject obj = new TempObject("Object" + i);
            obj.doSomething();
            // obj becomes eligible for GC at end of loop iteration
        }
        
        System.out.println("Objects created, some are now eligible for GC");
        
        // Suggest garbage collection (not guaranteed to run immediately)
        System.out.println("Suggesting garbage collection...");
        System.gc();
        
        // Give GC some time to work
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println();
    }
    
    public static void demonstrateGCEligibility() {
        System.out.println("2. Making Objects Eligible for GC:");
        
        // Method 1: Dereferencing
        ResourceUser user1 = new ResourceUser("User1");
        user1.useResource();
        user1 = null; // Object now eligible for GC
        System.out.println("user1 set to null - eligible for GC");
        
        // Method 2: Reassigning reference
        ResourceUser user2 = new ResourceUser("User2");
        ResourceUser user3 = new ResourceUser("User3");
        
        user2 = user3; // Original user2 object is now eligible for GC
        System.out.println("user2 reassigned - original object eligible for GC");
        
        // Method 3: Anonymous objects
        new ResourceUser("AnonymousUser").useResource();
        // Anonymous object eligible for GC immediately after method call
        System.out.println("Anonymous object eligible for GC");
        
        // Method 4: Objects going out of scope
        createAndDestroyObjects();
        System.out.println("Objects in method scope are now eligible for GC");
        
        System.gc();
        System.out.println();
    }
    
    public static void demonstrateFinalize() {
        System.out.println("3. finalize() Method (Deprecated):");
        
        System.out.println("Creating objects with finalize() method...");
        
        FinalizableObject obj1 = new FinalizableObject("Finalizable1");
        FinalizableObject obj2 = new FinalizableObject("Finalizable2");
        
        obj1 = null; // Make eligible for GC
        
        System.gc(); // Suggest GC
        
        try {
            Thread.sleep(200); // Give time for finalize()
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("Note: finalize() is deprecated since Java 9");
        System.out.println("Use try-with-resources or explicit cleanup instead");
        System.out.println();
    }
    
    public static void demonstrateTryWithResources() {
        System.out.println("4. Try-with-Resources Pattern:");
        
        // Automatic resource management
        try (AutoResource resource1 = new AutoResource("Resource1");
             AutoResource resource2 = new AutoResource("Resource2")) {
            
            System.out.println("Using resources inside try block");
            resource1.doWork();
            resource2.doWork();
            
        } // Resources automatically closed here (in reverse order)
        
        System.out.println("Resources automatically closed");
        System.out.println();
        
        // Traditional approach with finally block
        System.out.println("Traditional approach with finally:");
        ManualResource resource = null;
        try {
            resource = new ManualResource("ManualResource");
            resource.doWork();
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {
            if (resource != null) {
                resource.close();
            }
        }
        System.out.println();
    }
    
    public static void demonstrateWeakReferences() {
        System.out.println("5. Weak References:");
        
        // Create a strong reference
        TempObject strongRef = new TempObject("StrongReferenced");
        
        // Create a weak reference
        java.lang.ref.WeakReference<TempObject> weakRef = 
            new java.lang.ref.WeakReference<>(new TempObject("WeakReferenced"));
        
        System.out.println("Before GC:");
        System.out.println("Strong reference: " + (strongRef != null));
        System.out.println("Weak reference: " + (weakRef.get() != null));
        
        // Remove strong reference
        strongRef = null;
        
        // Suggest garbage collection
        System.gc();
        
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("\nAfter GC:");
        System.out.println("Strong reference: " + (strongRef != null));
        System.out.println("Weak reference: " + (weakRef.get() != null));
        
        System.out.println("→ Weak references don't prevent GC");
        System.out.println("→ Useful for caches and listeners");
        System.out.println();
    }
    
    public static void demonstrateMemoryLeakPrevention() {
        System.out.println("6. Memory Leak Prevention:");
        
        // Bad practice: Static collection that grows indefinitely
        System.out.println("Bad practice - static collection:");
        MemoryLeakExample.addBadObject("BadObject1");
        MemoryLeakExample.addBadObject("BadObject2");
        System.out.println("Static collection size: " + MemoryLeakExample.getBadCollectionSize());
        
        // Good practice: Use weak references for caches
        System.out.println("\nGood practice - weak reference cache:");
        MemoryLeakExample.addCachedObject("CachedObject1");
        MemoryLeakExample.addCachedObject("CachedObject2");
        System.out.println("Cache size: " + MemoryLeakExample.getCacheSize());
        
        // Clear strong references
        MemoryLeakExample.clearStrongReferences();
        System.gc();
        
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("After GC - Cache size: " + MemoryLeakExample.getCacheSize());
        
        System.out.println("\n→ Avoid static collections that grow indefinitely");
        System.out.println("→ Use weak references for caches");
        System.out.println("→ Remove listeners when no longer needed");
        System.out.println("→ Close resources explicitly");
        System.out.println();
    }
    
    // Helper method for scope demonstration
    public static void createAndDestroyObjects() {
        ResourceUser localUser1 = new ResourceUser("LocalUser1");
        ResourceUser localUser2 = new ResourceUser("LocalUser2");
        
        localUser1.useResource();
        localUser2.useResource();
        
        // Objects become eligible for GC when method ends
    }
}

/**
 * Supporting classes for demonstrations
 */

class TempObject {
    private String name;
    
    public TempObject(String name) {
        this.name = name;
        System.out.println("Created: " + name);
    }
    
    public void doSomething() {
        System.out.println(name + " is doing something");
    }
    
    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("Finalized: " + name);
        } finally {
            super.finalize();
        }
    }
    
    @Override
    public String toString() {
        return "TempObject[" + name + "]";
    }
}

class ResourceUser {
    private String name;
    
    public ResourceUser(String name) {
        this.name = name;
        System.out.println("ResourceUser '" + name + "' created");
    }
    
    public void useResource() {
        System.out.println("ResourceUser '" + name + "' using resource");
    }
    
    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("ResourceUser '" + name + "' finalized");
        } finally {
            super.finalize();
        }
    }
}

class FinalizableObject {
    private String name;
    
    public FinalizableObject(String name) {
        this.name = name;
        System.out.println("FinalizableObject '" + name + "' created");
    }
    
    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("FinalizableObject '" + name + "' finalized");
            // Cleanup code here (deprecated approach)
        } finally {
            super.finalize();
        }
    }
}

/**
 * AutoCloseable implementation for try-with-resources
 */
class AutoResource implements AutoCloseable {
    private String name;
    
    public AutoResource(String name) {
        this.name = name;
        System.out.println("AutoResource '" + name + "' opened");
    }
    
    public void doWork() {
        System.out.println("AutoResource '" + name + "' doing work");
    }
    
    @Override
    public void close() {
        System.out.println("AutoResource '" + name + "' closed automatically");
    }
}

/**
 * Manual resource management
 */
class ManualResource {
    private String name;
    private boolean isOpen;
    
    public ManualResource(String name) {
        this.name = name;
        this.isOpen = true;
        System.out.println("ManualResource '" + name + "' opened");
    }
    
    public void doWork() {
        if (!isOpen) {
            throw new IllegalStateException("Resource is closed");
        }
        System.out.println("ManualResource '" + name + "' doing work");
    }
    
    public void close() {
        if (isOpen) {
            isOpen = false;
            System.out.println("ManualResource '" + name + "' closed");
        }
    }
}

/**
 * Memory leak examples
 */
class MemoryLeakExample {
    // Bad: Static collection that grows indefinitely
    private static final java.util.List<String> badCollection = new java.util.ArrayList<>();
    
    // Good: Cache using weak references
    private static final java.util.Map<String, java.lang.ref.WeakReference<TempObject>> cache = 
        new java.util.HashMap<>();
    
    private static final java.util.List<TempObject> strongReferences = new java.util.ArrayList<>();
    
    public static void addBadObject(String name) {
        badCollection.add(name); // Never removed - memory leak!
    }
    
    public static int getBadCollectionSize() {
        return badCollection.size();
    }
    
    public static void addCachedObject(String name) {
        TempObject obj = new TempObject(name);
        cache.put(name, new java.lang.ref.WeakReference<>(obj));
        strongReferences.add(obj); // Keep strong reference initially
    }
    
    public static int getCacheSize() {
        // Clean up entries whose objects have been garbage collected
        cache.entrySet().removeIf(entry -> entry.getValue().get() == null);
        return cache.size();
    }
    
    public static void clearStrongReferences() {
        strongReferences.clear(); // Remove strong references, making objects eligible for GC
    }
}

/**
 * Key Points for Object Destruction:
 * 
 * 1. Garbage Collection:
 *    - Automatic memory management
 *    - Runs when memory is low or explicitly requested
 *    - Not guaranteed to run immediately
 *    - Cannot be forced, only suggested
 * 
 * 2. Making Objects Eligible for GC:
 *    - Set reference to null
 *    - Reassign reference to another object
 *    - Reference goes out of scope
 *    - Anonymous objects after use
 * 
 * 3. finalize() Method:
 *    - Deprecated since Java 9
 *    - Unreliable and unpredictable
 *    - Use try-with-resources instead
 *    - Can cause performance issues
 * 
 * 4. Try-with-Resources:
 *    - Automatic resource management
 *    - Objects must implement AutoCloseable
 *    - Resources closed automatically
 *    - Preferred for cleanup
 * 
 * 5. Weak References:
 *    - Don't prevent garbage collection
 *    - Useful for caches and listeners
 *    - get() returns null if object collected
 * 
 * 6. Memory Leak Prevention:
 *    - Avoid growing static collections
 *    - Remove event listeners
 *    - Use weak references for caches
 *    - Close resources explicitly
 *    - Clear references when done
 */

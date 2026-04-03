package classActivity;
// Java Program Structure

// java program strucutre
/*   


member of a class
attributes
methods: instance and static
final keyword
instance final and static final
object instantiation
constructors
types of constructors: they are parameterized and default constructors. you can create non parameterized constructors or the java will create one


static block:
instance block

Static and instance blocks are special code blocks in Java that execute at different times during class lifecycle:

## Static Blocks
- **When executed**: When the class is loaded (before any objects are created)
- **Purpose**: Initialize static variables or perform one-time setup for the class
- **Syntax**: `static { ... }`
- **Execution**: Runs only once per class, regardless of how many objects are created

## Instance Blocks
- **When executed**: Every time an object is created (before the constructor)
- **Purpose**: Initialize instance variables or perform common setup for all objects
- **Syntax**: `{ ... }` (no keyword)
- **Execution**: Runs for each object instance, before the constructor

## Execution Order
1. Static blocks (when class loads)
2. Instance blocks (for each object created)
3. Constructor (for each object created)

## Example
```java
public class Example {
    static {
        System.out.println("Static block - runs once");
    }
    
    {
        System.out.println("Instance block - runs per object");
    }
    
    public Example() {
        System.out.println("Constructor - runs per object");
    }
}
```

**Output when creating 2 objects:**
```
Static block - runs once
Instance block - runs per object  
Constructor - runs per object
Instance block - runs per object
Constructor - runs per object
```

Static blocks are useful for database connections, logging setup, or expensive one-time operations. Instance blocks help avoid code duplication when you have multiple constructors.
this keyword
scope resolution
constructor calling
access modifiers
public
protected
default
private


package
method and constructor overloading
argunent passing
garbage collection



The order of excution:
Class loaded → static block runs
Object created → instance block runs
Constructor runs

*/


// we can access the contents of the static block by creating an object
// why do we need instance blocks when we can use the constructors 
// we have to create constructors to access the contents of the contructors but we don't need to do that
// the contents of the instance block are executed before the constructor and when the object is created
// it is preferable to use constructors insted of instance blocks
// they both are used for initialization but constructors are more flexible

// it[instance block] was introduced in java 8
// we can have more than one instance and static block in a class
// They are excuted in their order as they don't have names to call by
// Static blocks are executed first, in the mian class before the main method

// why do we need more than one static block
// it is moe of to increase the readability and mentainability of the code

// 



public class contentsToCover {    
    // Final variables
    final double PI = 3.14;
    final int NUMBER = 10;
    static final double PI_VALUE = 3.14159;
    
    // Access modifiers example
    public int publicNum;
    protected float protectedNum;
    int defaultNum;
    private double privateNum;
    
    // Static block
    static {
        System.out.println("Static block executed");
    }
    
    // Instance block
    {
        System.out.println("Instance block executed");
    }
    
    // Constructor
    public contentsToCover(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Constructor chaining
    public contentsToCover(String name) {
        this(name, 25);
    }
    
    // Static method
    static void sayHello() {
        System.out.println("Hello!");
    }
    
    // Instance methods
    void sayName() {
        System.out.println("My name is " + this.name);
    }
    
    void printThis() {
        System.out.println("This refers to: " + this);
    }
    
    public static void main(String[] args) {
        contentsToCover obj = new contentsToCover("Alice", 30);
        obj.sayName();
        sayHello();
    }
}

// Separate Person class (not nested)
class Person {
    String name;
    int age;
    
    Person() {
        System.out.println("Default constructor called");
    }
    
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
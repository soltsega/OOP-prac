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


*/



class Person {
    String name;
    int age;
}

static void sayHello() {
    System.out.println("Hello!");
}

void sayName() {
    System.out.println("My name is " + this.name);
}

final int PI = 3.14;

final int NUMBER = 10;
static final double PI_VALUE = 3.14159;

Person person = new Person();

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

static {
    System.out.println("Static block executed");
}

{
    System.out.println("Instance block executed");
}

void printThis() {
    System.out.println("This refers to: " + this);
}

void printFullName() {
    System.out.println(this.name + " " + Person.name);
}

Person(String name) {
    this("John", 25);
}

public int publicNum;
protected float protectedNum;
int defaultNum;
private double privateNum;

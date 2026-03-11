// Java Program Structure

// java program strucutre
/*   


member of a class
attributes
methods: instance and static
final keyword
instance final and static final
object instantiation
contrructors
types of constructors
static block
instance block
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

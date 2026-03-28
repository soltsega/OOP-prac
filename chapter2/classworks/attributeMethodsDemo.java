package chapter2.classworks;

public class attributeMethodsDemo {
    

    // Attributes

    // instance attributes
    String name, id;
    int age;

// Static attributes
static String courseName;


// methods
// The types of methods: can be instance or static 
// Unlike the variables we don't talk about memory address. we talk about the accessing mechanism
// They ae accessed via objects
// instance methods are allowed to access both static and instance attributes
// But static methods are allowed only to access static attributes/variables
// The main method is static adn can't be otherwise

// 🔥how to access instance members in the main method or any other staic methods 
// n1 and n2 are class wide variables. they are accessible by only their classes 



// Constant attributes
// We use final keyword to accomplish this end
// They have to be initialized as soon as they are defined


// Ways of initialization in java 
final int constNum = 0;
final static int constStaticNum = 0; 
int n1, n2;
static int n3;
void test1(){
    // we can access n1, n2, n3, and even test2() method
    n3 = n1 + n2;
    test2();
}

static void test2(){
    // we can't access n1, n2, and test1() method as they are instance attributes

}

}

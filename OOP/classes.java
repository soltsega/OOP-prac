    // The package statement should be at the top of the file
    // The error is probably due to the package statement being placed after some other code.
    package OOP;

    public class classes {
        public static void main(String[] args) {
            System.out.println("This is a class in Java!");
            
            // Creating an instance of the class inside the class itself (in a static method)
            classes myClass = new classes();
            System.out.println("Instance created inside the class: " + myClass);
        }
        
    }
// creating an instance of the class
// classes myClass = new classes();


// methods of creating an instance of the class
// 1. Using the new keyword
// classes myClass = new classes();
// 2. Using the class name
// classes myClass = new classes();
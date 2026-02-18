package dataTypes;

// constants in java
// final keyword is used to declare constants
// final variable cannot be reassigned
// final variable must be initialized when declared

public class Javaconstants {
    public static void main(String[] args) {
        final int x = 10;
        // x = 20; // error: cannot assign a value to final variable
        System.out.println(x);
    }
}

// other operations related to the final keyword
// final methods cannot be overridden
// final classes cannot be inherited
// final variables cannot be reassigned
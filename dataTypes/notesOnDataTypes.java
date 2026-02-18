package dataTypes;

// data types in java
/*
We have to import the dataTypes package to work on data types and operations

*/


// byte - this includes a range of numbers from -128 to 127
// the operations - 

// short - this includes a range of 



// float


// double


// long



// string




// Java provides several primitive data types:
public class notesOnDataTypes {
    public static void main(String[] args) {
byte byteVariable = 10;
short shortVariable = 100;
int intVariable = 1000;
long longVariable = 10000L;
float floatVariable = 3.14f;
double doubleVariable = 3.14159;
char charVariable = 'A';
boolean booleanVariable = true;

// Note the "L" suffix for long literals and the "f" suffix for float literals.

// We can use these primitive data types to store and manipulate data directly in memory.



// Example of declaring and initializing variables of different primitive data types:

// We can also declare variables without initializing them:
int uninitializedInt; // Valid, but the variable will have an indeterminate value

// We can also declare multiple variables of the same type on the same line:
int a, b, c; // Declares three int variables named a, b, and c

// We can also declare and initialize variables in a single line:
int x = 10, y = 20, z = x + y; // Declares three int variables x, y, and z, and initializes them

// We can also use parentheses to explicitly specify the type of a literal:
long value = (long) 3.14; // Casts a float literal to a long

// The Java programming language provides several operators for performing arithmetic operations on primitive data types:

int sum = 1 + 2; // Addition
int difference = 5 - 3; // Subtraction
int product = 2 * 6; // Multiplication
int quotient = 10 / 2; // Division
int remainder = 11 % 3; // Modulus (remainder of division)

// We can also use the increment and decrement operators to modify a variable by one:

int count = 0;
// count++; // Increments count by one
// count--; // Decrements count by one

// We can also perform compound assignment operations using the +=, -=, *=, /=, and %= operators:

// int number = 10;
// number += 5; // Equivalent to number = number + 5
// number -= 3; // Equivalent to number = number - 3
// number *= 2; // Equivalent to number = number * 2
// number /= 4; // Equivalent to number = number / 4
// number %= 3; // Equivalent to number = number % 3
    }
}
package dataTypes;
// the var keyword in java
// it is used to declare a variable without specifying its type
// it is used to declare a variable with a type that is inferred from the value assigned to it
// the other use case is to declare a variable in a for loop


// misuses of the keyword that cause error
// 1. applying to the variable that is declared but not initialized
// 2. 
public class vardt {
    public static void main(String[] args) {
        var name = "John";
        var age = 25;
        var height = 5.9;
        var isStudent = true;
        
        System.out.println(name);
        System.out.println(age);
        System.out.println(height);
        System.out.println(isStudent);
    }
    
}

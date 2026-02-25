package dataTypes;

// casting can be of two types:
// 1. widening casting - can be done automatically when the smaller data type is assigned to the larger data type
// 2. narrowing casting - has to be done manually 


// Casting also applies for inheritance



// We can't cast boolean data type to other data types

// Some of the castings that can cause errors or are forbidden in Java are:
// 1. Upcasting - can be done automatically when the smaller data type is assigned to the larger data type
// 2. Downcasting - needs to be checked at runtime and is not allowed if it is not possible to be done
// 3. Narrowing - cannot be done automatically when the larger data type is assigned to the smaller data type
// 4. Unboxing - cannot be done automatically from a reference type to a primitive type
// 5. Boxing - cannot be done automatically from a primitive type to a reference type
// 6. Widening reference cast - can be done automatically
// 7. Narrowing reference cast - needs to be checked at runtime and is not allowed if it is not possible to be done


public class castingInJava {
    public static void main(String[] args) {
        // 1. narrowwing- 
        double d = 1.2;
        int i = (int) d;
        System.out.println(i);


        // to cast two unrelated data types
        int intvar = 65; 
        System.out.println(intvar);
        String s = String.valueOf(intvar);     
        System.out.println(s);   
    }
}

package broCode;

/**
 * Wrapper classes are used when we want to have an object that wraps primitive data types like int, double or boolean
 * 
 * 
 * Wrapper classes are classes that wrap around primitive data types. They are used to provide methods and properties for primitive data types.
 * 
 * - Autoboxing: it is the process of converting a primitive data type to its corresponding wrapper class.
 * - Unboxing: it is the process of converting a wrapper class to its corresponding primitive data type.
 * 
 * The difference between primitive data types and wrapper classes is:
 * - Primitive data types are directly used in the code whereas wrapper classes are used when we want to perform operations on the primitive data types.
 * - Primitive data types are faster than wrapper classes because they are directly used by the JVM.
 * - Wrapper classes provide additional methods and properties which are not available for primitive data types.
 * - Autoboxing and unboxing are used to convert between primitive data types and wrapper classes.
 * - Autoboxing and unboxing are automatic and do not require explicit typecasting.
 * - Autoboxing and unboxing are available only for 8 primitive data types: byte, short, int, long, float, double, boolean, and char.
 * - Autoboxing and unboxing are not applicable for other primitive data types such as void and references.
 */


/**
 * Wrapper classes and collections in array data types:
 * 
 * When we use collections in array data types, we can store wrapper classes as well as primitive data types.
 * 
 * For example, we can create a ArrayList of Integer objects and store the wrapper class objects in it.
 * 
 * We can also create an ArrayList of int primitive data types and store the primitive data types in it.
 * 
 * When we retrieve the data from the ArrayList, we can use autoboxing and unboxing to convert between the wrapper class and primitive data types.
 * 
 * Note: When we use collections in array data types, we can use both primitive data types and wrapper classes. However, when we use primitive data types, we cannot use methods specific to wrapper classes.
 * 
 * Feature,Array,"Collections (e.g., ArrayList)"
Size,Fixed (Fixed-length),Dynamic (Resizable)
Type,Primitives & Objects,Objects only (uses Autoboxing)
Methods,None (only .length),"Many (add, remove, clear, etc.)"
Speed,Faster,Slightly Slower
Syntax,int[] arr = new int[5];,ArrayList<Integer> list = new ArrayList<>();
 */

// let's now demonstrate it with a code snippet

public class WrapperClasses {
    
    public static void main(String[] args) {
        // demonstrating autoboxing
        int number = 10;
        Integer integer = number; // autoboxing
        System.out.println(integer);
        
        // demonstrating unboxing
        Integer integer2 = 10; // autoboxing
        int number2 = integer2; // unboxing
        System.out.println(number2);


        String a = Integer.toString(10);
        System.out.println("a = " + a);
        String b = Double.toString(10.5);
        System.out.println("b = " + b);
        String c = Boolean.toString(true);
        System.out.println("c = " + c);
        String d = Character.toString('A');  //this will output the character 'A'
        System.out.println("d = " + d);

        String all = a + " " + b + " " + c + " " + d;
        System.out.println("all = " + all);
    }
        
}

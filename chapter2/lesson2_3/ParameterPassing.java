package chapter2.lesson2_3;

/**
 * 2.3.3. Parameter Passing
 * 
 * This lesson demonstrates how parameters are passed to methods in Java:
 * - Primitive types: Pass by value (copy)
 * - Object types: Pass by reference value
 * - Arrays: Pass by reference value
 */

public class ParameterPassing {
    
    public static void main(String[] args) {
        System.out.println("=== 2.3.3. Parameter Passing ===\n");
        
        // 1. Primitive parameter passing
        demonstratePrimitivePassing();
        
        // 2. Object parameter passing
        demonstrateObjectPassing();
        
        // 3. Array parameter passing
        demonstrateArrayPassing();
        
        // 4. String special case
        demonstrateStringPassing();
        
        // 5. Wrapper classes
        demonstrateWrapperPassing();
        
        // 6. Varargs (variable arguments)
        demonstrateVarargs();
    }
    
    public static void demonstratePrimitivePassing() {
        System.out.println("1. Primitive Parameter Passing (Pass by Value):");
        
        int original = 10;
        System.out.println("Before method call: original = " + original);
        
        modifyPrimitive(original);
        
        System.out.println("After method call: original = " + original + " (unchanged)");
        System.out.println("→ Primitive parameters are copied, original unchanged");
        System.out.println();
    }
    
    public static void demonstrateObjectPassing() {
        System.out.println("2. Object Parameter Passing (Pass by Reference Value):");
        
        Person person = new Person("Alice", 25);
        System.out.println("Before method call: " + person);
        
        modifyObject(person);
        
        System.out.println("After method call: " + person + " (changed)");
        System.out.println("→ Object references are copied, but both point to same object");
        
        // Reassigning reference doesn't affect original
        System.out.println("\nTesting reference reassignment:");
        Person originalPerson = new Person("Bob", 30);
        System.out.println("Before reassignment: " + originalPerson);
        
        reassignReference(originalPerson);
        
        System.out.println("After reassignment: " + originalPerson + " (unchanged)");
        System.out.println("→ Reassigning reference parameter doesn't affect original");
        System.out.println();
    }
    
    public static void demonstrateArrayPassing() {
        System.out.println("3. Array Parameter Passing:");
        
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Before method call: " + java.util.Arrays.toString(numbers));
        
        modifyArray(numbers);
        
        System.out.println("After method call: " + java.util.Arrays.toString(numbers) + " (changed)");
        System.out.println("→ Arrays are objects, modifications affect original");
        
        // Array reassignment
        System.out.println("\nTesting array reassignment:");
        int[] originalArray = {10, 20, 30};
        System.out.println("Before reassignment: " + java.util.Arrays.toString(originalArray));
        
        reassignArray(originalArray);
        
        System.out.println("After reassignment: " + java.util.Arrays.toString(originalArray) + " (unchanged)");
        System.out.println();
    }
    
    public static void demonstrateStringPassing() {
        System.out.println("4. String Parameter Passing (Special Case):");
        
        String text = "Hello";
        System.out.println("Before method call: " + text);
        
        modifyString(text);
        
        System.out.println("After method call: " + text + " (unchanged)");
        System.out.println("→ Strings are immutable, modifications create new objects");
        
        // Using StringBuilder for mutable strings
        System.out.println("\nUsing StringBuilder (mutable):");
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println("Before method call: " + sb);
        
        modifyStringBuilder(sb);
        
        System.out.println("After method call: " + sb + " (changed)");
        System.out.println("→ StringBuilder is mutable, modifications affect original");
        System.out.println();
    }
    
    public static void demonstrateWrapperPassing() {
        System.out.println("5. Wrapper Class Parameter Passing:");
        
        Integer number = 100;
        System.out.println("Before method call: " + number);
        
        modifyWrapper(number);
        
        System.out.println("After method call: " + number + " (unchanged)");
        System.out.println("→ Wrapper objects are immutable like primitives");
        
        // Using mutable wrapper
        System.out.println("\nUsing mutable wrapper:");
        MutableInt mutableInt = new MutableInt(100);
        System.out.println("Before method call: " + mutableInt);
        
        modifyMutableWrapper(mutableInt);
        
        System.out.println("After method call: " + mutableInt + " (changed)");
        System.out.println();
    }
    
    public static void demonstrateVarargs() {
        System.out.println("6. Variable Arguments (Varargs):");
        
        // Different ways to call varargs method
        printNumbers(1);
        printNumbers(1, 2, 3);
        printNumbers(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Passing array to varargs
        int[] array = {10, 20, 30};
        printNumbers(array);
        
        // Mixed parameters with varargs
        printInfo("Numbers", 1, 2, 3);
        printInfo("Single", 42);
        printInfo("Empty"); // No additional arguments
        
        System.out.println();
    }
    
    // Helper methods for demonstrations
    
    public static void modifyPrimitive(int number) {
        number = number * 2; // Only affects local copy
        System.out.println("Inside method: number = " + number);
    }
    
    public static void modifyObject(Person person) {
        person.setAge(person.getAge() + 5); // Modifies the actual object
        System.out.println("Inside method: " + person);
    }
    
    public static void reassignReference(Person person) {
        person = new Person("Charlie", 35); // Reassigns local copy only
        System.out.println("Inside method: " + person);
    }
    
    public static void modifyArray(int[] array) {
        array[0] = 99; // Modifies the actual array
        System.out.println("Inside method: " + java.util.Arrays.toString(array));
    }
    
    public static void reassignArray(int[] array) {
        array = new int[]{100, 200, 300}; // Reassigns local copy only
        System.out.println("Inside method: " + java.util.Arrays.toString(array));
    }
    
    public static void modifyString(String text) {
        text = text + " World"; // Creates new String object
        System.out.println("Inside method: " + text);
    }
    
    public static void modifyStringBuilder(StringBuilder sb) {
        sb.append(" World"); // Modifies the actual StringBuilder
        System.out.println("Inside method: " + sb);
    }
    
    public static void modifyWrapper(Integer number) {
        number = number * 2; // Creates new Integer object
        System.out.println("Inside method: " + number);
    }
    
    public static void modifyMutableWrapper(MutableInt number) {
        number.setValue(number.getValue() * 2); // Modifies the actual object
        System.out.println("Inside method: " + number);
    }
    
    public static void printNumbers(int... numbers) {
        System.out.print("Numbers: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println("(count: " + numbers.length + ")");
    }
    
    public static void printInfo(String label, int... numbers) {
        System.out.print(label + ": ");
        if (numbers.length == 0) {
            System.out.print("(no numbers)");
        } else {
            for (int num : numbers) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }
}

/**
 * Supporting classes for demonstrations
 */

class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void setAge(int age) { this.age = age; }
    public int getAge() { return age; }
    
    @Override
    public String toString() {
        return "Person[name=" + name + ", age=" + age + "]";
    }
}

/**
 * Mutable integer wrapper class
 */
class MutableInt {
    private int value;
    
    public MutableInt(int value) {
        this.value = value;
    }
    
    public void setValue(int value) { this.value = value; }
    public int getValue() { return value; }
    
    @Override
    public String toString() {
        return "MutableInt[value=" + value + "]";
    }
}

/**
 * Key Points for Parameter Passing:
 * 
 * 1. Primitive Types (int, double, boolean, etc.):
 *    - Pass by value (copy)
 *    - Original value unchanged
 *    - Changes affect only local copy
 * 
 * 2. Object Types:
 *    - Pass by reference value (copy of reference)
 *    - Both references point to same object
 *    - Object modifications affect original
 *    - Reference reassignment doesn't affect original
 * 
 * 3. Arrays:
 *    - Treated as objects
 *    - Modifications affect original
 *    - Reassignment doesn't affect original
 * 
 * 4. Strings:
 *    - Immutable objects
 *    - Modifications create new objects
 *    - Original reference unchanged
 * 
 * 5. Wrapper Classes:
 *    - Immutable like primitives
 *    - Use custom mutable wrappers if needed
 * 
 * 6. Varargs:
 *    - Variable number of arguments
 *    - Treated as arrays inside method
 *    - Must be last parameter
 */

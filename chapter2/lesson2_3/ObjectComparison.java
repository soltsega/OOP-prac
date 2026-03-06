package chapter2.lesson2_3;

/**
 * 2.3.4. Comparing and Identifying Objects
 * 
 * This lesson demonstrates different ways to compare objects in Java:
 * - Reference equality (== operator)
 * - Object equality (equals() method)
 * - Hash code consistency
 * - Ordering (Comparable interface)
 */

public class ObjectComparison {
    
    public static void main(String[] args) {
        System.out.println("=== 2.3.4. Comparing and Identifying Objects ===\n");
        
        // 1. Reference equality vs object equality
        demonstrateReferenceVsObjectEquality();
        
        // 2. equals() and hashCode() contract
        demonstrateEqualsHashCode();
        
        // 3. String comparison special cases
        demonstrateStringComparison();
        
        // 4. Comparable interface for ordering
        demonstrateComparable();
        
        // 5. Arrays comparison
        demonstrateArrayComparison();
        
        // 6. Custom comparison strategies
        demonstrateCustomComparison();
    }
    
    public static void demonstrateReferenceVsObjectEquality() {
        System.out.println("1. Reference Equality vs Object Equality:");
        
        // Create different objects with same content
        Student student1 = new Student("Alice", 1001, 3.8);
        Student student2 = new Student("Alice", 1001, 3.8);
        Student student3 = student1; // Same reference
        
        System.out.println("student1: " + student1);
        System.out.println("student2: " + student2);
        System.out.println("student3: " + student3);
        
        // Reference equality (==)
        System.out.println("\nReference equality (==):");
        System.out.println("student1 == student2: " + (student1 == student2)); // false
        System.out.println("student1 == student3: " + (student1 == student3)); // true
        
        // Object equality (equals())
        System.out.println("\nObject equality (equals()):");
        System.out.println("student1.equals(student2): " + student1.equals(student2)); // true
        System.out.println("student1.equals(student3): " + student1.equals(student3)); // true
        
        System.out.println("\n→ == checks if references point to same object");
        System.out.println("→ equals() checks if objects have same content");
        System.out.println();
    }
    
    public static void demonstrateEqualsHashCode() {
        System.out.println("2. equals() and hashCode() Contract:");
        
        Student student1 = new Student("Bob", 1002, 3.5);
        Student student2 = new Student("Bob", 1002, 3.5);
        Student student3 = new Student("Bob", 1003, 3.5); // Different ID
        
        System.out.println("student1: " + student1);
        System.out.println("student2: " + student2);
        System.out.println("student3: " + student3);
        
        System.out.println("\nequals() results:");
        System.out.println("student1.equals(student2): " + student1.equals(student2)); // true
        System.out.println("student1.equals(student3): " + student1.equals(student3)); // false
        
        System.out.println("\nhashCode() results:");
        System.out.println("student1.hashCode(): " + student1.hashCode());
        System.out.println("student2.hashCode(): " + student2.hashCode());
        System.out.println("student3.hashCode(): " + student3.hashCode());
        
        System.out.println("\nContract rules:");
        System.out.println("1. If equals() is true, hashCode() must be equal");
        System.out.println("2. If equals() is false, hashCode() may or may not be equal");
        System.out.println("3. Multiple calls to hashCode() must return same value");
        System.out.println();
    }
    
    public static void demonstrateStringComparison() {
        System.out.println("3. String Comparison Special Cases:");
        
        // String literals (interned)
        String str1 = "Hello";
        String str2 = "Hello";
        
        // String objects
        String str3 = new String("Hello");
        String str4 = new String("Hello");
        
        System.out.println("String literals:");
        System.out.println("str1 == str2: " + (str1 == str2)); // true (interned)
        System.out.println("str1.equals(str2): " + str1.equals(str2)); // true
        
        System.out.println("\nString objects:");
        System.out.println("str3 == str4: " + (str3 == str4)); // false (different objects)
        System.out.println("str3.equals(str4): " + str3.equals(str4)); // true
        
        System.out.println("\nMixed comparison:");
        System.out.println("str1 == str3: " + (str1 == str3)); // false
        System.out.println("str1.equals(str3): " + str1.equals(str3)); // true


        
        System.out.println("\nString interning:");
        String str5 = str3.intern(); // Returns interned string
        System.out.println("str3.intern() == str1: " + (str5 == str1)); // true
        
        System.out.println("\n→ String literals are automatically interned");
        System.out.println("→ Use equals() for string content comparison");
        System.out.println();
    }
    
    public static void demonstrateComparable() {
        System.out.println("4. Comparable Interface for Ordering:");
        
        Student student1 = new Student("Alice", 1001, 3.8);
        Student student2 = new Student("Bob", 1002, 3.5);
        Student student3 = new Student("Charlie", 1003, 4.0);
        
        System.out.println("Students:");
        System.out.println("1: " + student1);
        System.out.println("2: " + student2);
        System.out.println("3: " + student3);
        
        System.out.println("\nNatural ordering (by GPA):");
        System.out.println("student1.compareTo(student2): " + student1.compareTo(student2)); // positive
        System.out.println("student2.compareTo(student1): " + student2.compareTo(student1)); // negative
        System.out.println("student1.compareTo(student1): " + student1.compareTo(student1)); // zero
        
        System.out.println("\nSorting students:");
        Student[] students = {student2, student1, student3};
        java.util.Arrays.sort(students); // Uses compareTo() for sorting
        
        for (Student student : students) {
            System.out.println(student);
        }
        
        System.out.println("\n→ compareTo() returns negative, zero, or positive");
        System.out.println("→ Used by Collections.sort() and Arrays.sort()");
        System.out.println();
    }
    
    public static void demonstrateArrayComparison() {
        System.out.println("5. Arrays Comparison:");
        
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        int[] array3 = {1, 2, 4};
        
        System.out.println("array1: " + java.util.Arrays.toString(array1));
        System.out.println("array2: " + java.util.Arrays.toString(array2));
        System.out.println("array3: " + java.util.Arrays.toString(array3));
        
        System.out.println("\nReference equality:");
        System.out.println("array1 == array2: " + (array1 == array2)); // false
        
        System.out.println("\nContent equality:");
        System.out.println("Arrays.equals(array1, array2): " + java.util.Arrays.equals(array1, array2)); // true
        System.out.println("Arrays.equals(array1, array3): " + java.util.Arrays.equals(array1, array3)); // false
        
        System.out.println("\nMultidimensional arrays:");
        int[][] matrix1 = {{1, 2}, {3, 4}};
        int[][] matrix2 = {{1, 2}, {3, 4}};
        
        System.out.println("Arrays.deepEquals(matrix1, matrix2): " + java.util.Arrays.deepEquals(matrix1, matrix2));
        
        System.out.println("\n→ Use Arrays.equals() for 1D arrays");
        System.out.println("→ Use Arrays.deepEquals() for multidimensional arrays");
        System.out.println();
    }
    
    public static void demonstrateCustomComparison() {
        System.out.println("6. Custom Comparison Strategies:");
        
        Student student1 = new Student("Alice", 1001, 3.8);
        Student student2 = new Student("Bob", 1002, 3.5);
        
        // Using Comparator for different ordering
        java.util.Comparator<Student> byName = java.util.Comparator.comparing(Student::getName);
        java.util.Comparator<Student> byId = java.util.Comparator.comparingInt(Student::getId);
        java.util.Comparator<Student> byGpa = java.util.Comparator.comparingDouble(Student::getGpa);
        
        System.out.println("Comparing " + student1 + " and " + student2);
        
        System.out.println("\nBy name:");
        System.out.println("Result: " + byName.compare(student1, student2));
        
        System.out.println("\nBy ID:");
        System.out.println("Result: " + byId.compare(student1, student2));
        
        System.out.println("\nBy GPA:");
        System.out.println("Result: " + byGpa.compare(student1, student2));
        
        System.out.println("\n→ Comparator allows multiple comparison strategies");
        System.out.println("→ compareTo() defines natural ordering");
        System.out.println("→ Comparator defines custom ordering");
        System.out.println();
    }
}

/**
 * Student class implementing equals(), hashCode(), and Comparable
 */
class Student implements Comparable<Student> {
    private String name;
    private int id;
    private double gpa;
    
    public Student(String name, int id, double gpa) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }
    
    // Getters
    public String getName() { return name; }
    public int getId() { return id; }
    public double getGpa() { return gpa; }
    
    // Override equals() for content equality
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Same reference
        if (obj == null || getClass() != obj.getClass()) return false; // Different class or null
        
        Student student = (Student) obj;
        return id == student.id && 
               java.util.Objects.equals(name, student.name) && 
               java.util.Double.compareTo(gpa, student.gpa) == 0;
    }
    
    // Override hashCode() to maintain contract with equals()
    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, id, gpa);
    }
    
    // Implement compareTo() for natural ordering (by GPA descending)
    @Override
    public int compareTo(Student other) {
        // Sort by GPA in descending order
        return Double.compare(other.gpa, this.gpa);
    }
    
    @Override
    public String toString() {
        return String.format("Student[name=%s, id=%d, gpa=%.1f]", name, id, gpa);
    }
}

/**
 * Key Points for Object Comparison:
 * 
 * 1. Reference Equality (==):
 *    - Compares memory addresses
 *    - True only if both references point to same object
 *    - Fast but checks identity, not content
 * 
 * 2. Object Equality (equals()):
 *    - Compares object content
 *    - Must override equals() in custom classes
 *    - Follows contract: reflexive, symmetric, transitive, consistent
 * 
 * 3. hashCode() Contract:
 *    - If equals() is true, hashCode() must be equal
 *    - If equals() is false, hashCode() may be equal
 *    - Multiple calls must return same value
 *    - Use Objects.hash() for safe implementation
 * 
 * 4. Comparable Interface:
 *    - Defines natural ordering
 *    - compareTo() returns negative, zero, or positive
 *    - Used by sorting algorithms
 * 
 * 5. Arrays Comparison:
 *    - Arrays.equals() for 1D arrays
 *    - Arrays.deepEquals() for multidimensional arrays
 *    - Never use == for array content comparison
 * 
 * 6. String Special Cases:
 *    - String literals are interned (shared)
 *    - new String() creates separate objects
 *    - Always use equals() for content comparison
 */

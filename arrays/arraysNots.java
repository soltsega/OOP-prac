package arrays;

public class arraysNots {
    public static void main(String[] args) {
        // This is a single-dimensional array
        int[] singleDimensionalArray = {1, 2, 3, 4, 5};
        System.out.println("Single-dimensional array: " + java.util.Arrays.toString(singleDimensionalArray));

        // This is a multi-dimensional array (2D array)
        int[][] multiDimensionalArray = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Multi-dimensional array (2D): " + java.util.Arrays.deepToString(multiDimensionalArray));

        // This is an array of objects
        String[] arrayOfObjects = {"Hello", "World", "Java"};
        System.out.println("Array of objects: " + java.util.Arrays.toString(arrayOfObjects));
    }
}

package methods;
import java.util.Random;
// Methods in java
// Now, we will see the randomm number generator method in java

// the fill() method of an array
// it is used to fill an array with a specific item
// it is usd like this

// Arrays.fill(arrayName, "The value we wanted to fill with")


// varargs in java are used to pack arguments in an array
// it is like this one 
// public int classname (datatype of the collection... the name of the array we want to collect in)
public class RandomNumGenerator {
    Random random = new Random();
    
    public void generateRandomNumbers() {
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(100));
        }
    }
    
    public static void main(String[] args) {
        RandomNumGenerator generator = new RandomNumGenerator();
        generator.generateRandomNumbers();
    }
}

package methods;
import java.util.Random;
// Methods in java
// Now, we will see the randomm number generator method in java
public class RandomNumGenerator {
    // 
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

package chapter2.lesson2_3;

public class EnumeratorsInJava {
    
    public static void main(String [] args){
        
        // Example of an enum
        enum Fruit {
            APPLE, ORANGE, BANANA
        }
        
        // Using enum constants
        Fruit fruit = Fruit.APPLE;
        System.out.println("My favorite fruit is " + fruit);
        
        // Enum values can be compared
        if (fruit == Fruit.APPLE) {
            System.out.println("You guessed it!");
        }
        
        // Enum values can be iterated
        for (Fruit f : Fruit.values()) {
            System.out.println(f);
            System.out.println(f.ordinal());
        }
        

    }
}

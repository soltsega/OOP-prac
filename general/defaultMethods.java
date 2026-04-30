package general;

public class defaultMethods {
    

    interface A {
        default void a (){

        }

    }
    interface B {
        default void a(){

        }

    }


}


public interface Festival{
    static void announce(){
        System.out.println("Celebrating Ethiopian festivals...");
    }

}

class FoodTradtion{
    
}

class MeskelFestival extends FoodTradtion implements A, B{
    
}

public class Main{
    public static void main(String[] args) {
        Festival.announce();
    }
}


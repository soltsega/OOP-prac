package classActivity.inherit;

public class InheritCoffee {
    public static void main(){
        Tona tona = new Tona();
        Abol abol = new Abol();
        Bereka bereka = new Bereka();


    }



public class CoffeeRound {
    public void serve(){

    }


}

public class Abol extends CoffeeRound(){
    public void  describe(){
        System.out.println("Abol");
    } 
}

    public class Tona extends CoffeeRound(){
        public void describe(){
        System.out.println("Tona");

        }
    } 
    public class Bereka extends CoffeeRound(){
        public void describe(){
            System.out.println("Bereka");
        }
    }
}



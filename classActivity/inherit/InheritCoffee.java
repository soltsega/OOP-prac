package classActivity.inherit;

public class InheritCoffee {

    public static void main(String[] args) {
        Tona tona = new Tona();
        Abol abol = new Abol();
        Bereka bereka = new Bereka();

        serveCoffee(tona);
        serveCoffee(abol);
        serveCoffee(bereka);
    }

    public static void serveCoffee(CoffeeRound coffeeRound){
        coffeeRound.serve();
        coffeeRound.describe();
    }

    public static class CoffeeRound {
        public void serve() {
        }

        public void describe() {
        }
    }

    public static class Abol extends CoffeeRound {
        @Override
        public void describe() {
            System.out.println("Abol");
        }
    }

    public static class Tona extends CoffeeRound {
        @Override
        public void describe() {
            System.out.println("Tona");
        }
    }

    public static class Bereka extends CoffeeRound {
        @Override
        public void describe() {
            System.out.println("Bereka");
        }
    }
}


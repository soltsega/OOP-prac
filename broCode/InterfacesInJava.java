package broCode;


interface MyInterface {
        void method1();
        int method2();
        static void method3() {
            System.out.println("This is a static method in the interface");
        }
    }

class MyClass implements MyInterface {
        @Override
        public void method1() {
            System.out.println("This is a method1 in the class");
        }

        @Override
        public int method2() {
            return 10;
        }
    }


public class InterfacesInJava {
       public static void main(String[] args) {
        MyInterface obj = new MyClass(); // Note: The variable 'obj' should be of type 'MyInterface' since MyClass implements MyInterface
        obj.method1();
        System.out.println(obj.method2());
        MyInterface.method3();
    }
    
}

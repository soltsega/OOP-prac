package chapter2;

public class Method_Chaining {

class Student {

    String name;
    int age;

    // Method that returns this (method chaining)
    Student setName(String name) {
        this.name = name;
        return this;
    }

    Student setAge(int age) {
        this.age = age;
        return this;
    }

    // Method that passes this
    void sendToPrinter() {
        Printer.printStudent(this);   // passing current object
    }
}

class Printer {

    static void printStudent(Student s) {
        System.out.println("Student Name: " + s.name);
        System.out.println("Student Age: " + s.age);
    }

}

public class Main {
    public static void main(String[] args) {

        Student s = new Student();

        // Using method chaining (return this)
        s.setName("Solomon").setAge(22);

        // Passing this to another method
        s.sendToPrinter();
    }
}

    
}

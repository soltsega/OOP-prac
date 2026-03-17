package broCode;



/* 

Getters and Setters are methods in Java that are used to access and modify the values of private fields in a class.

Getters are used to retrieve the value of a private field. They are typically named after the field they are retrieving, with a "get" prefix. For example, if you have a private field called "name", the corresponding getter method would be called "getName".

Setters are used to modify the value of a private field. They are typically named after the field they are modifying, with a "set" prefix. For example, if you have a private field called "age", the corresponding setter method would be called "setAge".

Getters and setters are used in Java to provide a way to access and modify the values of private fields without directly exposing them to the outside world. They can be used to enforce certain constraints on the values of the fields, such as ensuring that an age is always a positive integer.

Getters and setters are commonly used in Java when you want to provide a way to access and modify the state of an object without exposing the implementation details of the object. They are also used in Java Beans, which are classes that follow a specific convention for providing properties and their accessors.

Use cases for getters and setters include:

- Encapsulation: Getters and setters provide a way to encapsulate the implementation details of a class and hide the private fields from the outside world.

- Validation: Getters and setters can be used to validate the values being set on private fields, ensuring that they meet certain constraints.

- Serialization: Getters and setters are used by serialization frameworks to serialize and deserialize objects.

- Property Binding: Getters and setters are used by property binding frameworks to bind the values of properties to UI components.

- Reflection: Getters and setters can be used with reflection to access and modify the values of private fields at runtime.

*/
public class GetterAndSetters {
    
    private String name;
    private int age;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public static void main(String[] args) {
        GetterAndSetters obj = new GetterAndSetters();
        
        obj.setName("Solomon");
        obj.setAge(20);
        
        System.out.println("Name: " + obj.getName());
        System.out.println("Age: " + obj.getAge());
    }
    
}

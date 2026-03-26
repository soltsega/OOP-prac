package classActivity.person;

public class Person {
    private String name;
    private int age;
    private String city;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this(name);
        this.age = age;
    }

    public Person(String name, int age, String city) {
        this(name, age);
        this.city = city;
    }

    public void updateAge(Person p, int newAge) {
        p.age = newAge;
    }

    public Person getModifiedPerson(String newName, int newAge, String newCity) {
        return new Person(newName, newAge, newCity);
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age + ", City: " + city);
    }
}

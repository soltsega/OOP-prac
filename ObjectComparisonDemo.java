// Java Object Comparison Methods

import java.util.*;
import java.util.Comparator;

// 1. Basic class with equals() and hashCode()
class Person {
    private String name;
    private int age;
    private String email;
    
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    
    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getEmail() { return email; }
    
    // 1. equals() method for equality comparison
    @Override
    public boolean equals(Object obj) {
        // 1. Check if same reference
        if (this == obj) return true;
        
        // 2. Check if null or different class
        if (obj == null || getClass() != obj.getClass()) return false;
        
        // 3. Cast and compare fields
        Person other = (Person) obj;
        return age == other.age &&
               Objects.equals(name, other.name) &&
               Objects.equals(email, other.email);
    }
    
    // 2. hashCode() method (must be consistent with equals)
    @Override
    public int hashCode() {
        return Objects.hash(name, age, email);
    }
    
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", email='" + email + "'}";
    }
}

// 2. Class implementing Comparable interface
class Student implements Comparable<Student> {
    private String name;
    private double gpa;
    private int id;
    
    public Student(String name, double gpa, int id) {
        this.name = name;
        this.gpa = gpa;
        this.id = id;
    }
    
    // Getters
    public String getName() { return name; }
    public double getGpa() { return gpa; }
    public int getId() { return id; }
    
    // 3. compareTo() method for natural ordering
    @Override
    public int compareTo(Student other) {
        // Compare by GPA (descending)
        return Double.compare(other.gpa, this.gpa);
    }
    
    @Override
    public String toString() {
        return "Student{name='" + name + "', gpa=" + gpa + ", id=" + id + "}";
    }
}

// 3. Class for Comparator examples
class Employee {
    private String name;
    private double salary;
    private String department;
    private int experience;
    
    public Employee(String name, double salary, String department, int experience) {
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.experience = experience;
    }
    
    // Getters
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }
    public int getExperience() { return experience; }
    
    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + ", dept='" + department + "', exp=" + experience + "}";
    }
}

// 4. Custom Comparator classes
class EmployeeSalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return Double.compare(e1.getSalary(), e2.getSalary());
    }
}

class EmployeeNameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getName().compareTo(e2.getName());
    }
}

class EmployeeDepartmentThenSalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        int deptCompare = e1.getDepartment().compareTo(e2.getDepartment());
        if (deptCompare != 0) {
            return deptCompare;
        }
        return Double.compare(e2.getSalary(), e1.getSalary()); // Salary descending
    }
}

public class ObjectComparisonDemo {
    public static void main(String[] args) {
        System.out.println("=== OBJECT COMPARISON METHODS ===\n");
        
        // 1. equals() and hashCode() demonstration
        System.out.println("1. equals() and hashCode():");
        Person person1 = new Person("John", 25, "john@example.com");
        Person person2 = new Person("John", 25, "john@example.com");
        Person person3 = new Person("Jane", 30, "jane@example.com");
        
        System.out.println("person1: " + person1);
        System.out.println("person2: " + person2);
        System.out.println("person3: " + person3);
        
        System.out.println("person1.equals(person2): " + person1.equals(person2));
        System.out.println("person1.equals(person3): " + person1.equals(person3));
        System.out.println("person1 == person2: " + (person1 == person2));
        
        System.out.println("person1.hashCode(): " + person1.hashCode());
        System.out.println("person2.hashCode(): " + person2.hashCode());
        System.out.println("person3.hashCode(): " + person3.hashCode());
        
        // HashSet behavior with proper equals/hashCode
        Set<Person> personSet = new HashSet<>();
        personSet.add(person1);
        personSet.add(person2); // Won't be added (duplicate)
        personSet.add(person3);
        
        System.out.println("Set size: " + personSet.size());
        System.out.println("Set: " + personSet);
        
        // 2. Comparable interface (natural ordering)
        System.out.println("\n2. Comparable interface:");
        List<Student> students = Arrays.asList(
            new Student("Alice", 3.8, 101),
            new Student("Bob", 3.2, 102),
            new Student("Charlie", 3.9, 103),
            new Student("Diana", 3.5, 104)
        );
        
        System.out.println("Original list:");
        students.forEach(System.out::println);
        
        Collections.sort(students); // Uses compareTo()
        System.out.println("\nSorted by GPA (natural ordering):");
        students.forEach(System.out::println);
        
        // 3. Comparator interface (custom ordering)
        System.out.println("\n3. Comparator interface:");
        List<Employee> employees = Arrays.asList(
            new Employee("John", 75000, "IT", 5),
            new Employee("Alice", 85000, "HR", 3),
            new Employee("Bob", 70000, "IT", 2),
            new Employee("Charlie", 90000, "Finance", 7),
            new Employee("Diana", 80000, "HR", 4)
        );
        
        System.out.println("Original list:");
        employees.forEach(System.out::println);
        
        // Sort by salary using separate Comparator class
        employees.sort(new EmployeeSalaryComparator());
        System.out.println("\nSorted by salary (ascending):");
        employees.forEach(System.out::println);
        
        // Sort by name using separate Comparator class
        employees.sort(new EmployeeNameComparator());
        System.out.println("\nSorted by name:");
        employees.forEach(System.out::println);
        
        // Sort by department then salary using separate Comparator class
        employees.sort(new EmployeeDepartmentThenSalaryComparator());
        System.out.println("\nSorted by department then salary (descending):");
        employees.forEach(System.out::println);
        
        // 4. Anonymous Comparator
        System.out.println("\n4. Anonymous Comparator:");
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return Integer.compare(e2.getExperience(), e1.getExperience()); // Experience descending
            }
        });
        
        System.out.println("Sorted by experience (descending) using anonymous class:");
        employees.forEach(System.out::println);
        
        // 5. Lambda Comparator (Java 8+)
        System.out.println("\n5. Lambda Comparator:");
        employees.sort((e1, e2) -> e1.getName().length() - e2.getName().length());
        
        System.out.println("Sorted by name length using lambda:");
        employees.forEach(System.out::println);
        
        // 6. Comparator.comparing() method
        System.out.println("\n6. Comparator.comparing():");
        employees.sort(Comparator.comparing(Employee::getDepartment)
                                   .thenComparing(Employee::getName));
        
        System.out.println("Sorted by department then name using Comparator.comparing():");
        employees.forEach(System.out::println);
        
        // 7. Complex comparison with multiple criteria
        System.out.println("\n7. Complex comparison:");
        employees.sort(Comparator.comparing(Employee::getDepartment)
                                   .thenComparing(Employee::getSalary, Comparator.reverseOrder())
                                   .thenComparing(Employee::getExperience));
        
        System.out.println("Sorted by department, salary(desc), experience:");
        employees.forEach(System.out::println);
        
        // 8. Using comparators with streams
        System.out.println("\n8. Comparator with streams:");
        List<Employee> topEarners = employees.stream()
            .filter(e -> e.getSalary() > 75000)
            .sorted(Comparator.comparing(Employee::getSalary).reversed())
            .limit(3)
            .toList();
        
        System.out.println("Top 3 earners (salary > 75000):");
        topEarners.forEach(System.out::println);
        
        // 9. Custom comparison logic
        System.out.println("\n9. Custom comparison logic:");
        employees.sort((e1, e2) -> {
            // Custom logic: IT department first, then others by salary
            boolean e1IT = e1.getDepartment().equals("IT");
            boolean e2IT = e2.getDepartment().equals("IT");
            
            if (e1IT && !e2IT) return -1;
            if (!e1IT && e2IT) return 1;
            
            return Double.compare(e2.getSalary(), e1.getSalary());
        });
        
        System.out.println("Custom sort (IT first, then by salary desc):");
        employees.forEach(System.out::println);
    }
}

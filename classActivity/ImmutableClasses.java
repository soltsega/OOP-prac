package classActivity;

import java.util.Date;
import java.util.List;
import java.util.Collections;

public class ImmutableClasses {
    
    public static void main(String[] args) {
        System.out.println("=== Immutable Classes Demonstration ===\n");
        
        // 1. Basic Immutable Class Example
        demonstrateBasicImmutable();
        
        // 2. Immutable Class with Collections
        demonstrateImmutableWithCollections();
        
        // 3. Immutable Class with Defensive Copies
        demonstrateImmutableWithDefensiveCopies();
        
        // 4. When to Use Immutable Classes
        demonstrateUseCases();
    }
    
    // 1. BASIC IMMUTABLE CLASS
    public static final class Person {
        private final String name;
        private final int age;
        private final String email;
        
        public Person(String name, int age, String email) {
            this.name = name;
            this.age = age;
            this.email = email;
        }
        
        // Only getters - no setters
        public String getName() { return name; }
        public int getAge() { return age; }
        public String getEmail() { return email; }
        
        // Create new instance for modified state
        public Person withAge(int newAge) {
            return new Person(name, newAge, email);
        }
        
        public Person withEmail(String newEmail) {
            return new Person(name, age, newEmail);
        }
        
        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + ", email='" + email + "'}";
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Person person = (Person) obj;
            return age == person.age && 
                   name.equals(person.name) && 
                   email.equals(person.email);
        }
        
        @Override
        public int hashCode() {
            return name.hashCode() + age + email.hashCode();
        }
    }
    
    // 2. IMMUTABLE CLASS WITH COLLECTIONS
    public static final class Team {
        private final String teamName;
        private final List<String> members;
        private final Date createdDate;
        
        public Team(String teamName, List<String> members, Date createdDate) {
            this.teamName = teamName;
            // Defensive copy of mutable collection
            this.members = List.copyOf(members); // Java 10+ or use Collections.unmodifiableList
            // Defensive copy of mutable Date
            this.createdDate = new Date(createdDate.getTime());
        }
        
        public String getTeamName() { return teamName; }
        
        // Return unmodifiable view
        public List<String> getMembers() { return members; }
        
        // Return defensive copy
        public Date getCreatedDate() { return new Date(createdDate.getTime()); }
        
        @Override
        public String toString() {
            return "Team{name='" + teamName + "', members=" + members + ", created=" + createdDate + "}";
        }
    }
    
    // 3. IMMUTABLE BUILDER PATTERN
    public static final class Product {
        private final String id;
        private final String name;
        private final double price;
        private final String category;
        private final boolean inStock;
        
        private Product(Builder builder) {
            this.id = builder.id;
            this.name = builder.name;
            this.price = builder.price;
            this.category = builder.category;
            this.inStock = builder.inStock;
        }
        
        // Getters only
        public String getId() { return id; }
        public String getName() { return name; }
        public double getPrice() { return price; }
        public String getCategory() { return category; }
        public boolean isInStock() { return inStock; }
        
        // Builder class
        public static class Builder {
            private final String id;
            private String name;
            private double price;
            private String category;
            private boolean inStock = true;
            
            public Builder(String id) {
                this.id = id;
            }
            
            public Builder name(String name) {
                this.name = name;
                return this;
            }
            
            public Builder price(double price) {
                this.price = price;
                return this;
            }
            
            public Builder category(String category) {
                this.category = category;
                return this;
            }
            
            public Builder inStock(boolean inStock) {
                this.inStock = inStock;
                return this;
            }
            
            public Product build() {
                return new Product(this);
            }
        }
        
        @Override
        public String toString() {
            return String.format("Product{id='%s', name='%s', price=%.2f, category='%s', inStock=%s}", 
                               id, name, price, category, inStock);
        }
    }
    
    // 4. UTILITY CLASS (Immutable by design)
    public static final class MathUtils {
        // Private constructor to prevent instantiation
        private MathUtils() {
            throw new AssertionError("Cannot instantiate utility class");
        }
        
        public static int add(int a, int b) {
            return a + b;
        }
        
        public static int multiply(int a, int b) {
            return a * b;
        }
        
        public static boolean isEven(int number) {
            return number % 2 == 0;
        }
    }
    
    // DEMONSTRATION METHODS
    private static void demonstrateBasicImmutable() {
        System.out.println("1. Basic Immutable Class:");
        
        Person person = new Person("Alice", 30, "alice@email.com");
        System.out.println("Original: " + person);
        
        // Try to modify (creates new instance)
        Person olderPerson = person.withAge(31);
        System.out.println("Modified: " + olderPerson);
        System.out.println("Original unchanged: " + person);
        
        // Demonstrate thread safety
        System.out.println("Hash code: " + person.hashCode());
        System.out.println("Equals test: " + person.equals(new Person("Alice", 30, "alice@email.com")));
        System.out.println();
    }
    
    private static void demonstrateImmutableWithCollections() {
        System.out.println("2. Immutable Class with Collections:");
        
        List<String> originalMembers = List.of("John", "Jane", "Bob");
        Date createdDate = new Date();
        
        Team team = new Team("Development Team", originalMembers, createdDate);
        System.out.println("Team: " + team);
        
        // Try to modify the returned collection
        List<String> members = team.getMembers();
        try {
            members.add("New Member"); // This should fail
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify immutable collection: " + e.getMessage());
        }
        
        // Try to modify the returned date
        Date returnedDate = team.getCreatedDate();
        returnedDate.setTime(0); // This won't affect the original
        System.out.println("Original team unchanged: " + team);
        System.out.println();
    }
    
    private static void demonstrateImmutableWithDefensiveCopies() {
        System.out.println("3. Immutable Class with Builder Pattern:");
        
        Product product = new Product.Builder("P001")
            .name("Laptop")
            .price(999.99)
            .category("Electronics")
            .inStock(true)
            .build();
            
        System.out.println("Product: " + product);
        System.out.println();
    }
    
    private static void demonstrateUseCases() {
        System.out.println("4. When to Use Immutable Classes:");
        
        System.out.println("✅ Value Objects (Money, Address, DateRange)");
        System.out.println("✅ Configuration settings");
        System.out.println("✅ Data Transfer Objects (DTOs)");
        System.out.println("✅ Cache keys");
        System.out.println("✅ Thread-safe shared objects");
        System.out.println("✅ Utility classes");
        System.out.println("✅ Enum-like behavior");
        System.out.println();
        
        // Demonstrate utility class usage
        System.out.println("Utility class usage:");
        System.out.println("5 + 3 = " + MathUtils.add(5, 3));
        System.out.println("Is 4 even? " + MathUtils.isEven(4));
        System.out.println();
        
        // Demonstrate thread safety
        System.out.println("Thread Safety Demonstration:");
        Person sharedPerson = new Person("Shared User", 25, "shared@email.com");
        
        // Multiple threads can safely access this object
        System.out.println("Thread 1 sees: " + sharedPerson);
        System.out.println("Thread 2 sees: " + sharedPerson);
        System.out.println("No synchronization needed!");
    }
}

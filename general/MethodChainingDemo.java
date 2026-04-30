package general;

// Method Chaining Examples in Java

// 1. Basic Method Chaining with Fluent Interface
class StringBuilderChain {
    private StringBuilder sb = new StringBuilder();
    
    public StringBuilderChain append(String text) {
        sb.append(text);
        return this; // Return this for chaining
    }
    
    public StringBuilderChain addSpace() {
        sb.append(" ");
        return this;
    }
    
    public StringBuilderChain addLine() {
        sb.append("\n");
        return this;
    }
    
    public String build() {
        return sb.toString();
    }
}

// 2. Builder Pattern for Object Construction
class Person {
    private String name;
    private int age;
    private String email;
    private String address;
    
    // Private constructor
    private Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.email = builder.email;
        this.address = builder.address;
    }
    
    // Builder class with method chaining
    public static class Builder {
        private String name;
        private int age;
        private String email;
        private String address;
        
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        
        public Builder age(int age) {
            this.age = age;
            return this;
        }
        
        public Builder email(String email) {
            this.email = email;
            return this;
        }
        
        public Builder address(String address) {
            this.address = address;
            return this;
        }
        
        public Person build() {
            return new Person(this);
        }
    }
    
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", email='" + email + "', address='" + address + "'}";
    }
}

// 3. Fluent API for Configuration
class DatabaseConfig {
    private String host;
    private int port;
    private String database;
    private String username;
    private String password;
    private boolean sslEnabled;
    
    public DatabaseConfig host(String host) {
        this.host = host;
        return this;
    }
    
    public DatabaseConfig port(int port) {
        this.port = port;
        return this;
    }
    
    public DatabaseConfig database(String database) {
        this.database = database;
        return this;
    }
    
    public DatabaseConfig credentials(String username, String password) {
        this.username = username;
        this.password = password;
        return this;
    }
    
    public DatabaseConfig enableSSL() {
        this.sslEnabled = true;
        return this;
    }
    
    public void connect() {
        System.out.println("Connecting to database:");
        System.out.println("Host: " + host);
        System.out.println("Port: " + port);
        System.out.println("Database: " + database);
        System.out.println("SSL: " + sslEnabled);
        System.out.println("Connection successful!");
    }
}

// 4. Calculator with Method Chaining
class Calculator {
    private double result;
    
    public Calculator() {
        this.result = 0;
    }
    
    public Calculator add(double value) {
        result += value;
        return this;
    }
    
    public Calculator subtract(double value) {
        result -= value;
        return this;
    }
    
    public Calculator multiply(double value) {
        result *= value;
        return this;
    }
    
    public Calculator divide(double value) {
        if (value != 0) {
            result /= value;
        }
        return this;
    }
    
    public Calculator power(double exponent) {
        result = Math.pow(result, exponent);
        return this;
    }
    
    public double getResult() {
        return result;
    }
    
    public Calculator reset() {
        result = 0;
        return this;
    }
}

// 5. HTML Builder with Method Chaining
class HtmlBuilder {
    private StringBuilder html = new StringBuilder();
    
    public HtmlBuilder doctype() {
        html.append("<!DOCTYPE html>");
        return this;
    }
    
    public HtmlBuilder html() {
        html.append("<html>");
        return this;
    }
    
    public HtmlBuilder head() {
        html.append("<head>");
        return this;
    }
    
    public HtmlBuilder title(String title) {
        html.append("<title>").append(title).append("</title>");
        return this;
    }
    
    public HtmlBuilder body() {
        html.append("<body>");
        return this;
    }
    
    public HtmlBuilder h1(String text) {
        html.append("<h1>").append(text).append("</h1>");
        return this;
    }
    
    public HtmlBuilder p(String text) {
        html.append("<p>").append(text).append("</p>");
        return this;
    }
    
    public HtmlBuilder closeTag(String tag) {
        html.append("</").append(tag).append(">");
        return this;
    }
    
    public String build() {
        return html.toString();
    }
}

public class MethodChainingDemo {
    public static void main(String[] args) {
        System.out.println("=== Method Chaining Examples ===\n");
        
        // 1. StringBuilder Chain
        System.out.println("1. StringBuilder Chain:");
        String text = new StringBuilderChain()
            .append("Hello")
            .addSpace()
            .append("World!")
            .addLine()
            .append("Welcome to")
            .addSpace()
            .append("method chaining")
            .build();
        System.out.println(text);
        
        // 2. Builder Pattern
        System.out.println("\n2. Builder Pattern:");
        Person person = new Person.Builder()
            .name("John Doe")
            .age(30)
            .email("john@example.com")
            .address("123 Main St")
            .build();
        System.out.println(person);
        
        // 3. Database Configuration
        System.out.println("\n3. Database Configuration:");
        DatabaseConfig config = new DatabaseConfig()
            .host("localhost")
            .port(5432)
            .database("myapp")
            .credentials("admin", "password")
            .enableSSL();
        config.connect();
        
        // 4. Calculator Chain
        System.out.println("\n4. Calculator Chain:");
        double result = new Calculator()
            .add(10)
            .multiply(2)
            .subtract(5)
            .divide(3)
            .power(2)
            .getResult();
        System.out.println("Calculation result: " + result);
        
        // 5. HTML Builder
        System.out.println("\n5. HTML Builder:");
        String html = new HtmlBuilder()
            .doctype()
            .html()
            .head()
            .title("My Page")
            .closeTag("head")
            .body()
            .h1("Welcome!")
            .p("This is method chaining demo")
            .closeTag("body")
            .closeTag("html")
            .build();
        System.out.println(html);
    }
}

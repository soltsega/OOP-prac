package chapter2.lesson2_3;

/**
 * 2.3.2. Methods and Messages
 * 
 * This lesson demonstrates how to call methods on objects (sending messages)
 * and different method invocation patterns
 */

public class MethodsAndMessages {
    
    public static void main(String[] args) {
        System.out.println("=== 2.3.2. Methods and Messages ===\n");
        
        // 1. Basic method invocation
        demonstrateBasicMethods();
        
        // 2. Method chaining
        demonstrateMethodChaining();
        
        // 3. Methods with different return types
        demonstrateReturnTypes();
        
        // 4. Static methods vs instance methods
        demonstrateStaticVsInstance();
        
        // 5. Method overloading
        demonstrateMethodOverloading();
    }
    
    public static void demonstrateBasicMethods() {
        System.out.println("1. Basic Method Invocation:");
        
        SmartPhone phone = new SmartPhone("iPhone 15");
        
        // Sending messages to the object
        phone.turnOn();
        phone.installApp("WhatsApp");
        phone.makeCall("123-456-7890");
        phone.sendMessage("Hello World!");
        
        System.out.println("Battery level: " + phone.getBatteryLevel() + "%");
        
        phone.turnOff();
        System.out.println();
    }
    
    public static void demonstrateMethodChaining() {
        System.out.println("2. Method Chaining:");
        
        TextProcessor processor = new TextProcessor();
        
        // Chain multiple method calls
        String result = processor.setText("Hello World")
                               .toUpperCase()
                               .addPrefix(">>> ")
                               .addSuffix(" <<<")
                               .replace("WORLD", "Java")
                               .getText();
        
        System.out.println("Chained result: " + result);
        
        // Another chaining example
        processor.clear()
                .setText("Method chaining is powerful")
                .toLowerCase()
                .addPrefix("Note: ");
        
        System.out.println("Another chain: " + processor.getText());
        System.out.println();
    }
    
    public static void demonstrateReturnTypes() {
        System.out.println("3. Methods with Different Return Types:");
        
        Calculator calc = new Calculator();
        
        // void return type
        calc.add(10);
        calc.multiply(2);
        
        // primitive return types
        double result = calc.getResult();
        boolean isPositive = calc.isPositive();
        int integerPart = calc.getIntegerPart();
        
        System.out.println("Double result: " + result);
        System.out.println("Is positive: " + isPositive);
        System.out.println("Integer part: " + integerPart);
        
        // object return types
        String description = calc.getDescription();
        Calculator copy = calc.clone();
        
        System.out.println("Description: " + description);
        System.out.println("Clone result: " + copy.getResult());
        
        // array return types
        int[] history = calc.getHistory();
        System.out.println("History: " + java.util.Arrays.toString(history));
        
        System.out.println();
    }
    
    public static void demonstrateStaticVsInstance() {
        System.out.println("4. Static vs Instance Methods:");
        
        // Instance methods - require object creation
        MathOperations math = new MathOperations();
        double instanceResult = math.multiply(5, 3);
        System.out.println("Instance method result: " + instanceResult);
        
        // Static methods - called on class directly
        double staticResult = MathOperations.add(5, 3);
        System.out.println("Static method result: " + staticResult);
        
        // Static utility methods
        double sqrt = Math.sqrt(16);
        System.out.println("Math.sqrt(16): " + sqrt);
        
        String formatted = String.format("Value: %.2f", 3.14159);
        System.out.println("Formatted string: " + formatted);
        
        System.out.println();
    }
    
    public static void demonstrateMethodOverloading() {
        System.out.println("5. Method Overloading:");
        
        Printer printer = new Printer();
        
        // Same method name, different parameters
        printer.print("Hello");
        printer.print(42);
        printer.print(3.14);
        printer.print("Name: ", "John");
        printer.print("Values: ", 1, 2, 3);
        
        System.out.println();
    }
}

/**
 * SmartPhone class for basic method demonstration
 */
class SmartPhone {
    private String model;
    private boolean isOn;
    private int batteryLevel;
    private String[] installedApps;
    private int appCount;
    
    public SmartPhone(String model) {
        this.model = model;
        this.isOn = false;
        this.batteryLevel = 100;
        this.installedApps = new String[10];
        this.appCount = 0;
    }
    
    public void turnOn() {
        isOn = true;
        System.out.println(model + " turned on");
    }
    
    public void turnOff() {
        isOn = false;
        System.out.println(model + " turned off");
    }
    
    public void installApp(String appName) {
        if (appCount < installedApps.length) {
            installedApps[appCount++] = appName;
            System.out.println("Installed: " + appName);
        }
    }
    
    public void makeCall(String number) {
        if (isOn) {
            System.out.println("Calling " + number + "...");
            batteryLevel -= 2;
        }
    }
    
    public void sendMessage(String message) {
        if (isOn) {
            System.out.println("Sending: " + message);
            batteryLevel -= 1;
        }
    }
    
    public int getBatteryLevel() { return batteryLevel; }
}

/**
 * TextProcessor class for method chaining
 */
class TextProcessor {
    private String text;
    
    public TextProcessor setText(String text) {
        this.text = text;
        return this; // Return this for chaining
    }
    
    public TextProcessor toUpperCase() {
        this.text = text.toUpperCase();
        return this;
    }
    
    public TextProcessor toLowerCase() {
        this.text = text.toLowerCase();
        return this;
    }
    
    public TextProcessor addPrefix(String prefix) {
        this.text = prefix + text;
        return this;
    }
    
    public TextProcessor addSuffix(String suffix) {
        this.text = text + suffix;
        return this;
    }
    
    public TextProcessor replace(String target, String replacement) {
        this.text = text.replace(target, replacement);
        return this;
    }
    
    public TextProcessor clear() {
        this.text = "";
        return this;
    }
    
    public String getText() { return text; }
}

/**
 * Calculator class for different return types
 */
class Calculator {
    private double result;
    private int[] history = new int[10];
    private int historyCount = 0;
    
    public Calculator add(double value) {
        result += value;
        addToHistory('+', (int)value);
        return this;
    }
    
    public Calculator multiply(double value) {
        result *= value;
        addToHistory('*', (int)value);
        return this;
    }
    
    public double getResult() { return result; }
    
    public boolean isPositive() { return result > 0; }
    
    public int getIntegerPart() { return (int) result; }
    
    public String getDescription() {
        return "Calculator[current=" + result + ", operations=" + historyCount + "]";
    }
    
    public Calculator clone() {
        Calculator copy = new Calculator();
        copy.result = this.result;
        copy.historyCount = this.historyCount;
        System.arraycopy(this.history, 0, copy.history, 0, history.length);
        return copy;
    }
    
    public int[] getHistory() {
        int[] copy = new int[historyCount];
        System.arraycopy(history, 0, copy, 0, historyCount);
        return copy;
    }
    
    private void addToHistory(char op, int value) {
        if (historyCount < history.length) {
            history[historyCount++] = value;
        }
    }
}

/**
 * MathOperations class for static vs instance methods
 */
class MathOperations {
    // Instance method
    public double multiply(double a, double b) {
        return a * b;
    }
    
    // Static method
    public static double add(double a, double b) {
        return a + b;
    }
    
    // Static utility method
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}

/**
 * Printer class for method overloading
 */
class Printer {
    public void print(String text) {
        System.out.println("String: " + text);
    }
    
    public void print(int number) {
        System.out.println("Integer: " + number);
    }
    
    public void print(double number) {
        System.out.println("Double: " + number);
    }
    
    public void print(String label, String value) {
        System.out.println(label + value);
    }
    
    public void print(String label, int... numbers) {
        System.out.print(label);
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

/**
 * Key Concepts for Methods and Messages:
 * 
 * 1. Method Invocation = Sending messages to objects
 * 2. Method Chaining = Methods returning 'this' for fluent interface
 * 3. Return Types = void, primitive, object, array
 * 4. Static Methods = Belong to class, no object needed
 * 5. Instance Methods = Belong to object, require object creation
 * 6. Method Overloading = Same name, different parameters
 * 7. Fluent Interface = Chainable methods for readable code
 */

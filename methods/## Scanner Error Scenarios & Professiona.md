## Scanner Error Scenarios & Professional Usage

### **When Scanner Crashes JVM:**

#### **1. Resource Leaks (Memory Issues)**
```java
// BAD - Never closing scanner
public class BadScanner {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            scanner.next(); // Memory leak - never closed
        }
    }
}
```

#### **2. Infinite Loop with Bad Input**
```java
// BAD - No error handling
Scanner scanner = new Scanner(System.in);
while (true) {
    int num = scanner.nextInt(); // User enters "hello" → endless loop
}
```

#### **3. System.in Closed Multiple Times**
```java
// BAD - Closing System.in
Scanner scanner1 = new Scanner(System.in);
Scanner scanner2 = new Scanner(System.in);
scanner1.close(); // Closes System.in
scanner2.nextLine(); // CRASH - System.in already closed
```

### **Professional Scanner Usage:**

#### **1. Try-with-Resources (Best Practice)**
```java
public static void readData() {
    try (Scanner scanner = new Scanner(System.in)) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        System.out.println(name + " is " + age);
    } // Auto-closed
}
```

#### **2. Robust Error Handling**
```java
public static int safeReadInt(Scanner scanner, String prompt) {
    while (true) {
        try {
            System.out.print(prompt);
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid number! Try again.");
            scanner.nextLine(); // Clear bad input
        }
    }
}
```

#### **3. Input Validation**
```java
public static int readAge(Scanner scanner) {
    while (true) {
        System.out.print("Enter age (1-120): ");
        try {
            int age = scanner.nextInt();
            scanner.nextLine(); // Clear newline
            
            if (age >= 1 && age <= 120) {
                return age;
            }
            System.out.println("Age must be between 1 and 120");
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number");
            scanner.nextLine(); // Clear bad input
        }
    }
}
```

#### **4. Single Scanner Pattern**
```java
public class InputManager {
    private static Scanner scanner = new Scanner(System.in);
    
    public static String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
    
    public static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = scanner.nextInt();
                scanner.nextLine(); // Clear newline
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Invalid number!");
                scanner.nextLine(); // Clear bad input
            }
        }
    }
    
    // Close when application ends
    public static void close() {
        scanner.close();
    }
}
```

#### **5. File Scanner Professional Usage**
```java
public static void readFile(String filename) {
    try (Scanner fileScanner = new Scanner(new File(filename))) {
        fileScanner.useDelimiter(","); // Custom delimiter
        
        while (fileScanner.hasNext()) {
            String data = fileScanner.next();
            System.out.println(data);
        }
    } catch (FileNotFoundException e) {
        System.out.println("File not found: " + filename);
    }
}
```

### **Key Professional Rules:**

1. **Always close scanner** (try-with-resources)
2. **Handle InputMismatchException**
3. **Clear bad input** with `nextLine()`
4. **Validate input ranges**
5. **Use single scanner instance** per application
6. **Never close System.in** multiple times

**Professional pattern = try-with-resources + error handling + validation**
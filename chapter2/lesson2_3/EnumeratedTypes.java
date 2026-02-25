package chapter2.lesson2_3;

/**
 * 2.3.6. Enumerated Types
 * 
 * This lesson demonstrates Java enums and their capabilities:
 * - Basic enum constants
 * - Enum with properties and methods
 * - Enum with abstract methods
 * - Enum sets and maps
 * - Switch statements with enums
 * - Enum comparison and iteration
 */

public class EnumeratedTypes {
    
    public static void main(String[] args) {
        System.out.println("=== 2.3.6. Enumerated Types ===\n");
        
        // 1. Basic enum usage
        demonstrateBasicEnum();
        
        // 2. Enum with properties
        demonstrateEnumWithProperties();
        
        // 3. Enum methods
        demonstrateEnumMethods();
        
        // 4. Switch statements with enums
        demonstrateEnumSwitch();
        
        // 5. Enum iteration and comparison
        demonstrateEnumIteration();
        
        // 6. Advanced enum features
        demonstrateAdvancedEnums();
        
        // 7. Enum collections
        demonstrateEnumCollections();
    }
    
    public static void demonstrateBasicEnum() {
        System.out.println("1. Basic Enum Usage:");
        
        // Using enum constants
        Day today = Day.MONDAY;
        Day weekend = Day.SATURDAY;
        
        System.out.println("Today: " + today);
        System.out.println("Weekend: " + weekend);
        
        // Enum values are objects, not strings or integers
        System.out.println("Type of today: " + today.getClass().getSimpleName());
        
        // Enum constants are singletons
        Day anotherMonday = Day.MONDAY;
        System.out.println("Same reference? " + (today == anotherMonday));
        
        System.out.println();
    }
    
    public static void demonstrateEnumWithProperties() {
        System.out.println("2. Enum with Properties:");
        
        Priority high = Priority.HIGH;
        Priority medium = Priority.MEDIUM;
        Priority low = Priority.LOW;
        
        System.out.println("High priority: " + high);
        System.out.println("Level: " + high.getLevel());
        System.out.println("Color: " + high.getColor());
        System.out.println("Is urgent: " + high.isUrgent());
        
        System.out.println("\nMedium priority:");
        System.out.println("Level: " + medium.getLevel());
        System.out.println("Color: " + medium.getColor());
        System.out.println("Is urgent: " + medium.isUrgent());
        
        System.out.println();
    }
    
    public static void demonstrateEnumMethods() {
        System.out.println("3. Enum Methods:");
        
        // Built-in enum methods
        System.out.println("Built-in methods:");
        
        for (Day day : Day.values()) {
            System.out.println(day.name() + " (ordinal: " + day.ordinal() + ")");
        }
        
        System.out.println("\nValue of methods:");
        System.out.println("Day.valueOf('MONDAY'): " + Day.valueOf("MONDAY"));
        System.out.println("Day.MONDAY.toString(): " + Day.MONDAY.toString());
        
        // Custom enum methods
        System.out.println("\nCustom methods:");
        System.out.println("MONDAY is weekend: " + Day.MONDAY.isWeekend());
        System.out.println("SUNDAY is weekend: " + Day.SUNDAY.isWeekend());
        System.out.println("MONDAY work hours: " + Day.MONDAY.getWorkHours());
        
        System.out.println();
    }
    
    public static void demonstrateEnumSwitch() {
        System.out.println("4. Switch Statements with Enums:");
        
        Day[] days = {Day.MONDAY, Day.WEDNESDAY, Day.SATURDAY, Day.SUNDAY};
        
        for (Day day : days) {
            System.out.print(day + ": ");
            
            switch (day) {
                case MONDAY:
                case TUESDAY:
                case WEDNESDAY:
                case THURSDAY:
                case FRIDAY:
                    System.out.println("Work day (8 hours)");
                    break;
                case SATURDAY:
                    System.out.println("Weekend (half day)");
                    break;
                case SUNDAY:
                    System.out.println("Weekend (day off)");
                    break;
            }
        }
        
        System.out.println();
    }
    
    public static void demonstrateEnumIteration() {
        System.out.println("5. Enum Iteration and Comparison:");
        
        // Iteration
        System.out.println("All days:");
        for (Day day : Day.values()) {
            System.out.println("  " + day + " - " + day.getDescription());
        }
        
        // Comparison
        System.out.println("\nComparison:");
        Day day1 = Day.MONDAY;
        Day day2 = Day.TUESDAY;
        Day day3 = Day.MONDAY;
        
        System.out.println("MONDAY == TUESDAY: " + (day1 == day2));
        System.out.println("MONDAY == MONDAY: " + (day1 == day3));
        System.out.println("MONDAY.compareTo(TUESDAY): " + day1.compareTo(day2));
        System.out.println("TUESDAY.compareTo(MONDAY): " + day2.compareTo(day1));
        
        // Finding enum by property
        System.out.println("\nFinding by property:");
        Day weekendDay = findWeekendDay();
        System.out.println("First weekend day: " + weekendDay);
        
        System.out.println();
    }
    
    public static void demonstrateAdvancedEnums() {
        System.out.println("6. Advanced Enum Features:");
        
        // Enum with abstract methods
        System.out.println("Math operations:");
        MathOperation add = MathOperation.ADD;
        MathOperation multiply = MathOperation.MULTIPLY;
        
        System.out.println("5 + 3 = " + add.calculate(5, 3));
        System.out.println("5 * 3 = " + multiply.calculate(5, 3));
        
        // Enum implementing interface
        System.out.println("\nShape calculations:");
        Shape circle = Shape.CIRCLE;
        Shape rectangle = Shape.RECTANGLE;
        
        System.out.println("Circle area (radius 5): " + circle.calculateArea(5));
        System.out.println("Rectangle area (width 5, height 3): " + rectangle.calculateArea(5, 3));
        
        // Enum constants with different behavior
        System.out.println("\nDatabase connections:");
        DatabaseConnection mysql = DatabaseConnection.MYSQL;
        DatabaseConnection postgres = DatabaseConnection.POSTGRESQL;
        
        mysql.connect();
        postgres.connect();
        
        System.out.println();
    }
    
    public static void demonstrateEnumCollections() {
        System.out.println("7. Enum Collections:");
        
        // EnumSet - efficient set of enum constants
        java.util.EnumSet<Day> weekdays = java.util.EnumSet.of(
            Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, Day.THURSDAY, Day.FRIDAY
        );
        
        java.util.EnumSet<Day> weekend = java.util.EnumSet.of(Day.SATURDAY, Day.SUNDAY);
        
        System.out.println("Weekdays: " + weekdays);
        System.out.println("Weekend: " + weekend);
        
        // EnumSet operations
        java.util.EnumSet<Day> allDays = java.util.EnumSet.allOf(Day.class);
        System.out.println("All days: " + allDays);
        
        java.util.EnumSet<Day> noWeekend = java.util.EnumSet.copyOf(weekdays);
        noWeekend.removeAll(weekend);
        System.out.println("Weekdays only: " + noWeekend);
        
        // EnumMap - map with enum keys
        java.util.EnumMap<Priority, String> priorityMessages = new java.util.EnumMap<>(Priority.class);
        priorityMessages.put(Priority.HIGH, "Urgent attention required");
        priorityMessages.put(Priority.MEDIUM, "Normal processing");
        priorityMessages.put(Priority.LOW, "Process when available");
        
        System.out.println("\nPriority messages:");
        for (Priority priority : Priority.values()) {
            System.out.println(priority + ": " + priorityMessages.get(priority));
        }
        
        System.out.println();
    }
    
    // Helper method
    public static Day findWeekendDay() {
        for (Day day : Day.values()) {
            if (day.isWeekend()) {
                return day;
            }
        }
        return null; // Should never happen for Day enum
    }
}

/**
 * Basic enum for days of week
 */
enum Day {
    MONDAY("Monday", 1, false, "Start of work week"),
    TUESDAY("Tuesday", 2, false, "Second work day"),
    WEDNESDAY("Wednesday", 3, false, "Mid week"),
    THURSDAY("Thursday", 4, false, "Almost Friday"),
    FRIDAY("Friday", 5, false, "Last work day"),
    SATURDAY("Saturday", 6, true, "Weekend start"),
    SUNDAY("Sunday", 7, true, "Rest day");
    
    private final String name;
    private final int dayNumber;
    private final boolean isWeekend;
    private final String description;
    
    Day(String name, int dayNumber, boolean isWeekend, String description) {
        this.name = name;
        this.dayNumber = dayNumber;
        this.isWeekend = isWeekend;
        this.description = description;
    }
    
    public String getName() { return name; }
    public int getDayNumber() { return dayNumber; }
    public boolean isWeekend() { return isWeekend; }
    public String getDescription() { return description; }
    
    public int getWorkHours() {
        return isWeekend ? (this == SATURDAY ? 4 : 0) : 8;
    }
}

/**
 * Enum with properties
 */
enum Priority {
    LOW(1, "green", false),
    MEDIUM(2, "yellow", false),
    HIGH(3, "red", true),
    CRITICAL(4, "purple", true);
    
    private final int level;
    private final String color;
    private final boolean urgent;
    
    Priority(int level, String color, boolean urgent) {
        this.level = level;
        this.color = color;
        this.urgent = urgent;
    }
    
    public int getLevel() { return level; }
    public String getColor() { return color; }
    public boolean isUrgent() { return urgent; }
}

/**
 * Enum with abstract methods
 */
enum MathOperation {
    ADD {
        @Override
        public double calculate(double a, double b) {
            return a + b;
        }
        
        @Override
        public String getSymbol() {
            return "+";
        }
    },
    
    SUBTRACT {
        @Override
        public double calculate(double a, double b) {
            return a - b;
        }
        
        @Override
        public String getSymbol() {
            return "-";
        }
    },
    
    MULTIPLY {
        @Override
        public double calculate(double a, double b) {
            return a * b;
        }
        
        @Override
        public String getSymbol() {
            return "*";
        }
    },
    
    DIVIDE {
        @Override
        public double calculate(double a, double b) {
            return b != 0 ? a / b : 0;
        }
        
        @Override
        public String getSymbol() {
            return "/";
        }
    };
    
    public abstract double calculate(double a, double b);
    public abstract String getSymbol();
}

/**
 * Enum implementing interface
 */
interface ShapeCalculator {
    double calculateArea(double... dimensions);
}

enum Shape implements ShapeCalculator {
    CIRCLE {
        @Override
        public double calculateArea(double... dimensions) {
            double radius = dimensions[0];
            return Math.PI * radius * radius;
        }
        
        @Override
        public String getDescription() {
            return "Circle (π × r²)";
        }
    },
    
    RECTANGLE {
        @Override
        public double calculateArea(double... dimensions) {
            double width = dimensions[0];
            double height = dimensions[1];
            return width * height;
        }
        
        @Override
        public String getDescription() {
            return "Rectangle (width × height)";
        }
    },
    
    TRIANGLE {
        @Override
        public double calculateArea(double... dimensions) {
            double base = dimensions[0];
            double height = dimensions[1];
            return 0.5 * base * height;
        }
        
        @Override
        public String getDescription() {
            return "Triangle (½ × base × height)";
        }
    };
    
    public abstract String getDescription();
}

/**
 * Enum with complex behavior
 */
enum DatabaseConnection {
    MYSQL {
        @Override
        public void connect() {
            System.out.println("Connecting to MySQL database...");
            System.out.println("Driver: com.mysql.jdbc.Driver");
            System.out.println("URL: jdbc:mysql://localhost:3306/mydb");
        }
        
        @Override
        public String getConnectionString() {
            return "jdbc:mysql://localhost:3306/mydb";
        }
    },
    
    POSTGRESQL {
        @Override
        public void connect() {
            System.out.println("Connecting to PostgreSQL database...");
            System.out.println("Driver: org.postgresql.Driver");
            System.out.println("URL: jdbc:postgresql://localhost:5432/mydb");
        }
        
        @Override
        public String getConnectionString() {
            return "jdbc:postgresql://localhost:5432/mydb";
        }
    },
    
    ORACLE {
        @Override
        public void connect() {
            System.out.println("Connecting to Oracle database...");
            System.out.println("Driver: oracle.jdbc.OracleDriver");
            System.out.println("URL: jdbc:oracle:thin:@localhost:1521:XE");
        }
        
        @Override
        public String getConnectionString() {
            return "jdbc:oracle:thin:@localhost:1521:XE";
        }
    };
    
    public abstract void connect();
    public abstract String getConnectionString();
}

/**
 * Key Points for Enumerated Types:
 * 
 * 1. Basic Enums:
 *    - Type-safe constants
 *    - Singleton instances
 *    - Cannot be instantiated with new
 *    - Extends java.lang.Enum implicitly
 * 
 * 2. Enum Properties:
 *    - Can have fields, constructors, methods
 *    - Constructor is private
 *    - Constants are initialized in declaration order
 * 
 * 3. Built-in Methods:
 *    - values() - returns all constants
 *    - valueOf() - creates enum from string
 *    - name() - returns constant name
 *    - ordinal() - returns declaration position
 *    - compareTo() - compares by ordinal
 * 
 * 4. Switch Statements:
 *    - Type-safe switching
 *    - No default case needed if all constants covered
 *    - Compile-time checking for completeness
 * 
 * 5. Advanced Features:
 *    - Abstract methods implemented by each constant
 *    - Interface implementation
 *    - Custom behavior per constant
 * 
 * 6. Enum Collections:
 *    - EnumSet - efficient set implementation
 *    - EnumMap - map with enum keys
 *    - Better performance than regular collections
 */

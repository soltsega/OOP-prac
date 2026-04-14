// Holiday.java - Parent class demonstrating encapsulation and inheritance
class Holiday {
    // Encapsulated fields
    private String name;
    private String date;
    private String description;

    // Constructor
    public Holiday(String name, String date, String description) {
        this.name = name;
        this.date = date;
        this.description = description;
    }

    // Getters and setters for encapsulation
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Method that can be overridden by subclasses
    public void celebrate() {
        System.out.println("Celebrating " + name + " on " + date + ". " + description);
    }

    // Display holiday information
    public void displayInfo() {
        System.out.println("Holiday: " + name);
        System.out.println("Date: " + date);
        System.out.println("Description: " + description);
    }
}

// Christmas.java - Child class extending Holiday
class Christmas extends Holiday {
    private String specialTradition;

    public Christmas(String date, String description, String specialTradition) {
        super("Christmas", date, description);
        this.specialTradition = specialTradition;
    }

    public String getSpecialTradition() {
        return specialTradition;
    }

    public void setSpecialTradition(String specialTradition) {
        this.specialTradition = specialTradition;
    }

    @Override
    public void celebrate() {
        super.celebrate();
        System.out.println("Special tradition: " + specialTradition);
        System.out.println("Merry Christmas!");
    }
}

// Eid.java - Child class extending Holiday
class Eid extends Holiday {
    private String prayerLocation;

    public Eid(String date, String description, String prayerLocation) {
        super("Eid", date, description);
        this.prayerLocation = prayerLocation;
    }

    public String getPrayerLocation() {
        return prayerLocation;
    }

    public void setPrayerLocation(String prayerLocation) {
        this.prayerLocation = prayerLocation;
    }

    @Override
    public void celebrate() {
        super.celebrate();
        System.out.println("Prayer location: " + prayerLocation);
        System.out.println("Eid Mubarak!");
    }
}

// Diwali.java - Child class extending Holiday
class Diwali extends Holiday {
    private String festivalOfLights;

    public Diwali(String date, String description, String festivalOfLights) {
        super("Diwali", date, description);
        this.festivalOfLights = festivalOfLights;
    }

    public String getFestivalOfLights() {
        return festivalOfLights;
    }

    public void setFestivalOfLights(String festivalOfLights) {
        this.festivalOfLights = festivalOfLights;
    }

    @Override
    public void celebrate() {
        super.celebrate();
        System.out.println("Festival of lights: " + festivalOfLights);
        System.out.println("Happy Diwali!");
    }
}

// Main class to demonstrate inheritance and encapsulation
public class HolidayInheritanceDemo {
    public static void main(String[] args) {
        // Create holiday objects using inheritance
        Christmas christmas = new Christmas("December 25", "Christian holiday celebrating the birth of Jesus Christ", "Gift giving and Christmas trees");
        Eid eid = new Eid("Varies (Islamic calendar)", "Islamic holiday marking the end of Ramadan", "Mosque");
        Diwali diwali = new Diwali("October/November", "Hindu festival of lights", "Lighting lamps and fireworks");

        // Demonstrate encapsulation with getters and setters
        System.out.println("=== Encapsulation Demo ===");
        System.out.println("Christmas name: " + christmas.getName());
        christmas.setDate("December 25th");
        System.out.println("Updated Christmas date: " + christmas.getDate());

        // Demonstrate inheritance and polymorphism
        System.out.println("\n=== Inheritance and Polymorphism Demo ===");
        Holiday[] holidays = {christmas, eid, diwali}; // Parent reference to child objects

        for (Holiday holiday : holidays) {
            holiday.displayInfo();
            holiday.celebrate(); // Dynamic method dispatch - calls overridden method
            System.out.println("---");
        }
    }
}
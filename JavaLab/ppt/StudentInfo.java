package JavaLab.ppt;


/**
 * The Student Profile Generator
 * Create a new Java class named StudentProfile. Your program should store student information , calculate your age by subtracting from current year and  display a formatted report.
 * NB; student information should be provided from keyboard
 */
public class StudentInfo {
    public static void main(String[] args) {
        System.out.println("Student Info");
    }
    
}

class StudentProfile {
    String name;
    int yearOfBirth;
    String studentId;
    
    public StudentProfile(String name, int yearOfBirth, String studentId) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.studentId = studentId;
    }
    
    public int calculateAge() {
        return 2025 - yearOfBirth;
    }
    
    public void displayProfile() {
        System.out.println("Student Profile");
        System.out.println("Name: " + name);
        System.out.println("Age: " + calculateAge());
        System.out.println("Student ID: " + studentId);
    }
}
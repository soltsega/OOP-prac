package classworks;
/*
 1. define the package
 2. create parameteriezed construtors
 3. 

//  task description
//  create a class student with the following attributes:
//  sName, sId, GPA, yearOfStudy, university
//  create a method to display student info
//  create a method to check if student is passing
//  create a method to get student count
//  create a method to get student info
//  create a method to get student name
//  create a method to get student id
//  create a method to get student gpa
//  create a method to get student year of study
//  create a method to get student university
//  create a method to get student passing gpa
//  create a method to get student max gpa
//  create a method to get student min gpa
//  create a method to get student total students
//  create a method to get student year of study

*/

public class Student {

        String  sName;
        String  sId;
        final static String  university = "CNCS";
        double  GPA;
        final static double passingGPA = 2.0;
        final static double maxGPA = 4.0;
        final static double minGPA = 0.0;
        static int totalStudents = 0;
        final int yearOfStudy = 4;





    public static void main(String[] args) {

        // create objects
        Student student1 = new Student("Fikre", "8585", 4.00);
        Student student2 = new Student("Gebre", "4545", 3.8);


        // call the display method
        for (Student student : new Student[]{student1, student2}) {
            student.displayStudentInfo();
            // is passing
            System.out.println("Is passing?: " + student.isPassing());
            System.out.println();
        }

        // get student count
        System.out.println("Total students: " + student1.getStudentCount());

    }

    // parameterized constructor
    public Student(String sName, String sId, double GPA) {
        this.sName = sName;
        this.sId = sId;
        this.GPA = GPA;
        totalStudents++;
    
    }


    public void displayStudentInfo() {
        System.out.println("Name: " + sName);
        System.out.println("ID: " + sId);
        System.out.println("GPA: " + GPA);
        System.out.println("Year of study: " + yearOfStudy);
        System.out.println("University: " + university);
    }

    public int getStudentCount() {
        return totalStudents;
    }
    
    public boolean isPassing() {
        return GPA >= passingGPA;
    }
    
}

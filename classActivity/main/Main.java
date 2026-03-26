package classActivity.main;
import classActivity.person.Person;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to the Person Manager");
        Scanner sc = new Scanner(System.in);

        // 1. Get number of persons
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        Person[] people = new Person[n];

        // Input data
        for (int i = 1; i <= n; i++) {
            System.out.println("\nEnter details for person " + i);

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("City: ");
            String city = sc.nextLine();

            people[i-1] = new Person(name, age, city);
        }




        // 2. Update age
        System.out.println("Do you want to update? Y or N");
        String choice = sc.nextLine();
        if(choice=="Y" || choice=="y"){
        System.out.print("\nEnter index to update age: ");
        int index = sc.nextInt();
        


        if (index >= 0 && index < n) {
            System.out.print("Enter new age: ");
            int newAge = sc.nextInt();

            // call method
            people[index].updateAge(people[index], newAge);
        } else {
            System.out.println("Invalid index! Skipping update.");
        }
    }
        // 3. Create modified person
        Person modifiedPerson = null;

        System.out.print("\nEnter index to base new person on: ");
        int baseIndex = sc.nextInt();
        sc.nextLine();

        if (baseIndex >= 0 && baseIndex < n) {

            System.out.print("New Name: ");
            String newName = sc.nextLine();

            System.out.print("New Age: ");
            int newAge = sc.nextInt();
            sc.nextLine();

            System.out.print("New City: ");
            String newCity = sc.nextLine();

            modifiedPerson = people[baseIndex]
                    .getModifiedPerson(newName, newAge, newCity);

        } else {
            System.out.println("Invalid index! Skipping creation.");
        }

        // 4. Display all persons
        System.out.println("\nAll Persons:");
        for (int i = 0; i < n; i++) {
            people[i].display();
        }

        // 5. Display modified person
        if (modifiedPerson != null) {
            System.out.println("\nModified Person:");
            modifiedPerson.display();
        }

        sc.close();
    }
}

public class EnumDemo {
// Define two enum types−−definitions go OUTSIDE The main() routine !
enum Day { SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY }
enum Month { JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC }

public static void main(String[] args) {
 for (int i = 0; i < Day.values().length; i++) {
    System.out.println(Day.values()[i]);
 }

Day tgif;
// Declare a variable of type Day.
Month libra; // Declare a variable of type Month.
tgif = Day.FRIDAY;  // the value of the tgif variable is FRIDAY
System.out.println(tgif);
// Assign a value of type Day to tgif .
libra = Month.OCT;
// Assign a value of type Month to libra .
System.out.print("My sign is libra , since I was born in ");
System.out.println(libra);
// Output value will be: OCT
System.out.print("That’s the ");
System.out.print( libra.ordinal() );
System.out.println("−th month of the year. ");
System.out.println("( Counting from 0, of course!) ");
System.out.print(" Isn ’t it nice to get to ");
System.out.println(tgif);
// Output value will be: FRIDAY
System.out.println( tgif + " is the " + tgif.ordinal() + "−th day of the week. "); //Can concatenate enum values onto Strings !

// Iterating over enumerators Using for loop
// the template will be: 
/*  for ( enum−type−name variable−name : enum−type−name.values() )
statement*/
for ( Day d : Day.values() ) {
System.out.print( d );
System.out.print(" is day number ");
System.out.println( d.ordinal() );
}

}
}



// Note: The .ordinal() method is a built-in method of each enumerated type.
// It returns the integer value of the enumerator. The first enumerator has an 
// ordinal value of 0, the second has an ordinal value of 1, and so on.
// This method is useful if you want to know the position of an enumerator in the
// enumerated type. For example, if you have an enumerated type called Color
// with enumerators RED, GREEN, and BLUE, then RED has an ordinal value of 0,
// GREEN has an ordinal value of 1, and BLUE has an ordinal value of 2.
// Note: The .values() method is a built-in method of each enumerated type.
// It returns an array of all the enumerators in the enumerated type. For example,
// if you have an enumerated type called Day with enumerators SUNDAY, MONDAY,
// TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, and SATURDAY, then the .values() method
// will return an array of all the enumerators in the Day type.
// Note: Enumerated types are objects, so you can assign one enumerated type to
// another variable of the same type. You can also use enumerated types in collections
// like arrays, lists, and sets.
// Note: The .name() method is a built-in method of each enumerator.
// It returns a string that represents the name of the enumerator. For example,
// if you have an enumerated type called Day with enumerators SUNDAY, MONDAY,
// TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, and SATURDAY, then SUNDAY.name() will
// return the string "SUNDAY".
// Note: The .valueOf() method is a built-in method of each enumerated type.
// It returns the enumerator that corresponds to the name parameter. For example,
// if you have an enumerated type called Day with enumerators SUNDAY, MONDAY,
// TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, and SATURDAY, then Day.valueOf("MONDAY")
// will return the enumerator MONDAY.



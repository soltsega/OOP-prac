package broCode;


/*
 * Parsing methods in Java
 * 
 * 1. Java provides us with a set of methods that can be used to parse strings into different data types.
 * 
 * 2. The methods in the java.lang.Number class are used to parse numbers from strings.
 * 
 *      - static double parseDouble(String s)
 *      - static float parseFloat(String s)
 *      - static long parseLong(String s)
 *      - static int parseInt(String s)
 *      - static Integer valueOf(String s)
 *      - static Long valueOf(String s)
 *      - static Float valueOf(String s)
 * 
 * 3. The methods in the java.lang.Character class are used to parse characters from strings.
 * 
 *      - static char parseChar(String s)
 *      - static Character valueOf(String s)
 * 
 * 4. The methods in the java.lang.Boolean class are used to parse booleans from strings.
 * 
 *      - static boolean parseBoolean(String s)
 *      - static Boolean valueOf(String s)
 * 
 * 5. The method in the java.util.Scanner class is used to parse strings into different data types.
 * 
 *      - boolean hasNextDouble()
 *      - boolean hasNextFloat()
 *      - boolean hasNextLong()
 *      - boolean hasNextInt()
 *      - double nextDouble()
 *      - float nextFloat()
 *      - long nextLong()
 *      - int nextInt()
 *      - String next()
 *      - String nextLine()
 *      - boolean hasNext()
 * 
 * 6. The methods in the java.util.StringTokenizer class is used to parse strings into tokens.
 * 
 *      - StringTokenizer(String str, String delim)
 *      - boolean hasMoreTokens()
 *      - String nextToken()
 * 
 * 7. The methods in the java.util.regex.Pattern and java.util.regex.Matcher classes are used to parse strings using regular expressions.
 * 
 *      - static Pattern compile(String regex)
 *      - boolean matches(String input)
 *      - Matcher matcher(CharSequence input)
 *      - boolean find()
 *      - String group()
 * 
*/
import java.lang.Character;
import java.lang.Number;
import java.lang.String;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsingMethodsInJava {

    public static void main(String[] args) {

        // Parsing numbers using Number class
        String numberString = "3.14";
        double numberDouble = Double.parseDouble(numberString);
        float numberFloat = Float.parseFloat(numberString);
        long numberLong = Long.parseLong(numberString);
        int numberInt = Integer.parseInt(numberString);

        System.out.println(numberDouble);
        System.out.println(numberFloat);
        System.out.println(numberLong);
        System.out.println(numberInt);

        // Parsing characters using Character class
        String characterString = "a";
        char characterChar = Character.toLowerCase(characterString.charAt(0));
        System.out.println(characterChar);

        // Parsing booleans using Boolean class
        String booleanString = "true";
        boolean booleanBoolean = Boolean.parseBoolean(booleanString);
        System.out.println(booleanBoolean);

        // Parsing strings using Scanner class
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        double inputDouble = scanner.nextDouble();
        float inputFloat = scanner.nextFloat();
        long inputLong = scanner.nextLong();
        int inputInt = scanner.nextInt();
        System.out.println(inputString);
        System.out.println(inputDouble);
        System.out.println(inputFloat);
        System.out.println(inputLong);
        System.out.println(inputInt);

        // Parsing strings using StringTokenizer class
        StringTokenizer stringTokenizer = new StringTokenizer(inputString, " ");
        while (stringTokenizer.hasMoreTokens()) {
            System.out.println(stringTokenizer.nextToken());
        }

        // Parsing strings using regular expressions
        String regexString = "\\d+";
        Pattern pattern = Pattern.compile(regexString);
        Matcher matcher = pattern.matcher(inputString);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

    }


    
}

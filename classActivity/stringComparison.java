package classActivity;
// 1. By using the comparator operator: ==
// stringa == string2
// this will output false if they 




/**
 * Java provides several methods for string comparison:
 * 
 * 1. Using the equality operator (==):
 *    - Compares memory addresses
 *    - True only if both references point to the same object
 *    - Fast but checks identity, not content
 * 
 * 2. Using the equals() method:
 *    - Compares object content
 *    - Ignores case by default
 *    - Returns true if the content is equal
 *    - Override equals() method in custom classes for content-based comparison
 * 
 * 3. Using the compareTo() method:
 *    - Compares the lexicographical order of the string
 *    - Returns a negative number if the current string is less than the argument string
 *    - Returns 0 if the strings are equal
 *    - Returns a positive number if the current string is greater than the argument string
 *    - Can be used with the Comparable interface for natural ordering
 * 
 * 4. Using the startsWith() method:
 *    - Checks if the current string starts with the specified prefix
 *    - Returns true if the current string starts with the prefix
 *    - Case-sensitive
 * 
 * 5. Using the endsWith() method:
 *    - Checks if the current string ends with the specified suffix
 *    - Returns true if the current string ends with the suffix
 *    - Case-sensitive
 * 
 * 6. Using the contains() method:
 *    - Checks if the current string contains the specified substring
 *    - Returns true if the current string contains the substring
 *    - Case-sensitive
 * 
 * 7. Using the equalsIgnoreCase() method:
 *    - Compares object content, ignoring case
 *    - Returns true if the content is equal, ignoring case
 *    - Override equalsIgnoreCase() method in custom classes for content-based comparison, ignoring case
 * 
 * 8. Using the regionMatches() method:
 *    - Checks if the specified region of the current string matches the specified region of the argument string
 *    - Returns true if the regions match
 *    - Case-sensitive
 * 
 * 9. Using the compareToIgnoreCase() method:
 *    - Compares the lexicographical order of the string, ignoring case
 *    - Returns a negative number if the current string is less than the argument string, ignoring case
 *    - Returns 0 if the strings are equal, ignoring case
 *    - Returns a positive number if the current string is greater than the argument string, ignoring case
 * 
 * 10. Using the matches() method:
 *     - Checks if the current string matches the specified regular expression
 *     - Returns true if the current string matches the regular expression
 * 
 * 11. Using the replace() method:
 *     - Replaces all occurrences of the specified substring with the specified replacement in the current string
 *     - Returns the modified string
 * 
 * 12. Using the replaceFirst() method:
 *     - Replaces the first occurrence of the specified substring with the specified replacement in the current string
 *     - Returns the modified string
 * 
 * 13. Using the replaceAll() method:
 *     - Replaces all occurrences of the specified regular expression with the specified replacement in the current string
 *     - Returns the modified string
 * 
 * 14. Using the split() method:
 *     - Splits the current string into an array of substrings based on the specified regular expression
 *     - Returns the array of substrings
 * 
 * 15. Using the toLowerCase() method:
 *     - Converts the current string to lowercase
 *     - Returns the lowercase string
 * 
 * 16. Using the toUpperCase() method:
 *     - Converts the current string to uppercase
 *     - Returns the uppercase string
 * 
 * 17. Using the trim() method:
 *     - Removes leading and trailing whitespace from the current string
 *     - Returns the modified string
 * 
 */
public class stringComparison {
    
    public static void main(String[] args) {
        String str1 = "Hello, World!";
        String str2 = "hello, world!";
        String str3 = "Hello";
        String str4 = "World";
        
        System.out.println(str1.startsWith("Hello"));      // true
        System.out.println(str1.endsWith("!"));             // true
        System.out.println(str1.contains(","));            // true
        System.out.println(str1.equalsIgnoreCase(str2));   // true
        System.out.println(str1.regionMatches(1, str2, 1, 5));   // true
        System.out.println(str1.compareToIgnoreCase(str2));  // 0
        System.out.println(str1.matches("[A-Za-z,\\s]+")); // true
        System.out.println(str1.replace("World", "Java")); // Hello, Java!
        System.out.println(str1.replaceFirst("World", "Java")); // Hello, Java!
        System.out.println(str1.replaceAll("\\w", "*")); // ****, ****!
        System.out.println(str1.toLowerCase()); // hello, world!
        System.out.println(str1.toUpperCase()); // HELLO, WORLD!
        System.out.println(str1.trim()); // Hello, World!
    }

    
}



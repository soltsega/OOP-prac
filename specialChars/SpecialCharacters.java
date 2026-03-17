package specialChars;

public class SpecialCharacters {
    // 1. \n : new line
    // 2. \t : tab
    // 3. \\ : backslash
    // 4. \" : double quote
    // 5. \' : single quote
    // 6. \r : carriage return
    // 7. \b : backspace
    // 8. \f : form feed
    // 9. \0 : null character

    public static void main(String[] args) {
        System.out.println("New Line:\nLine 2");
        System.out.println("Tab:\tSpaced");
        System.out.println("Backslash: \\");
        System.out.println("Quotes: \"Double\" and \'Single\'");
        
        // These might look messy in an IDE console but work in a Terminal:
        System.out.println("Carriage Return: \rOverwritten");
        System.out.println("Backspace: Hello\bWorld"); 
        System.out.println("Form Feed: Hello\fWorld");
        System.out.println("Null Char: Hello\0World");
    }
}
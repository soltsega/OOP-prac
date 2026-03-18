# Java Program Structure – Detailed Notes

## Class Naming Conventions
- Class names should start with uppercase letters.
- Use singular nouns for class names.
- Class names must be descriptive and short.

## Main Method & JVM
- The JVM invokes the `main` method, similar to C++.
- The class containing the `main` method should have the same name as the file.

## Static Keyword
- Static members belong to the class, not to any instance.
- Static members can be accessed without creating an object.
- Use static for fields/methods that should be shared across all instances.

## Java Comments
- Used to document and explain code, syntax, purpose, input, and output.
- Can also be used to write HTML for documentation.

## Key Concepts
- **Instance:** An object of a class.
- **Static:** A class member, not tied to any instance.
- **Methods:** Can be instance or static.
- **Final Keyword:** Used to declare constants or prevent inheritance/overriding.
- **Object Instantiation:** Creating objects from classes.
- **Constructors:** Special methods for object creation; can be overloaded.
- **Static/Instance Blocks:** Used for initialization.
- **this Keyword:** Refers to the current object.
- **Scope Resolution:** Determines visibility and accessibility.
- **Constructor Calling:** Can call other constructors using `this()`.

## Access Modifiers & Packages
- Packages group related classes; names should be short, descriptive, and lowercase.
- Package statement must be at the top of the file.
- If no package is specified, the class is in the default package.

## Import Statement
- Second statement in a Java program.
- `import java.util.*;` imports all classes in `java.util`.
- `import java.lang.Math;` imports the `Math` class.
- Some classes (like those in `java.lang`) are imported by default.
- Cannot import packages or subpackages directly.

## Method & Constructor Overloading/Overriding
- **Overloading:** Multiple methods/constructors with different parameters.
- **Overriding:** Subclass provides specific implementation for a method.

## Argument Passing & Garbage Collection
- Arguments are passed to the `main` method via command line.
- Use loops or switch-case to handle arguments safely.
- Garbage collection is automatic in Java.

## Program Structure
1. Documentation (comments)
2. Package statement
3. Import statement
4. Interface declaration (optional)
5. Class declaration
6. Main method declaration
7. Constructor declaration
8. Method declaration

## Multiple Classes
- Multiple classes can be declared in a file, but only one can be public and match the filename.

## System.out.println()
- `out` is a static field in `System` that refers to the output stream object.

## Running Java Code (CLI)
- Compile: `javac HelloWorld.java`
- Run: `java HelloWorld`

## Passing Parameters
- After compiling, run with arguments: `java HelloWorld arg1 arg2`
- Arguments are received in `main(String[] args)`.

## Packages & Bytecode
- If no package, class is in default package.
- When running code from a package: `java mypackage.BytecodeName`
package OOP.Access_modifiers;

/**
 * Non-access modifiers:
 * 
 * 1. static:
 *    - Applied to class, field, method, or inner class
 *    - Static field: Belongs to class, not object
 *    - Static method: Belongs to class, not object
 *    - Static inner class: Cannot access non-static members
 * 
 * 2. final:
 *    - Applied to class, field, method, or variable
 *    - Prevents modification or inheritance
 *    - final class: Cannot be subclassed
 *    - final method: Cannot be overridden
 *    - final variable: Cannot be reassigned after initialization
 * 
 * 3. interface:
 *    - Applied to class
 *    - Interface class: Cannot be instantiated, only implemented
 *    - Interface method: Must be implemented by subclass
 * 
 * 4. abstract:
 *    - Applied to class
 *    - Abstract class: Cannot be instantiated, only subclassed
 *    - Abstract method: Must be implemented by subclass
 * 
 * Other non-access modifiers:
 *  - transient:
 *    - Applied to field
 *    - Field will not be serialized
 *  - volatile:
 *    - Applied to field
 *    - Ensures that changes to the field are immediately visible to other threads
 *  - synchronized:
 *    - Applied to method or block of code
 *    - Ensures thread-safe access to shared resources
 * 
 * Note: The order of execution:
 *   - Static block → runs once
 *   - Instance block → runs per object
 *   - Constructor → runs per object
 */

public class NonAccessModifiers {
    
}

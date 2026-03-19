/**
 * we use it[scope resolution] when we have intance or static variables and local variable

 * The word "this" is used to refer to the instance variable
 * what will happen if we have static varable and local variable?
 * we use the class name to achieve this: ClassName.varname = 
 * we can't use this keyword in a static block: static{}
 * used to isolate or differentiate local variable from instance variable
 * 
 * what is the other use of "this"
 * used to call constructor: how is a constructor called?
 * it is called like this one: using the new keyword when the object is created
 * what if we need to call a constructor using another constructor: we will not be creating an object here
 * we use this keyword again: this([args])
 * calling the constructor must be the ftst statement in the method: it will cause an error if you do so
 * this([args]) is used only in a constructor not anywhere else
 * what is cascading? multiple constructors can be accessed via one object
 * we can call only one constructor at a time
 * where can and can't we call another constructor
 * 
 * 
 * 
 * Access modifiers
 * default/package: we can accesss only those in the same package. we have to import the packages if outside
 * what does it mean by making a constructor private: we can't create even an object
 * 
 * public: 
 * 
 * 
 * 
 * protected: is more on inheritance
 * 
 * 
 * private: 
 * 
 * As a good practice or rule of thumb, the data must be private and the methods public
 * the classes also should be public 
 * 
 * 
 * 
 */
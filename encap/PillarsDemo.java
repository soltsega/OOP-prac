package encap;

public class PillarsDemo {
    private String name;
    private int age;
    private String gender;
    // private final String ID;

    public PillarsDemo(int age, String gender, String name) {
        this.age = age;
        this.gender = gender;
        this.name = name;
    }

    // generate setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    // generating getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }


    public static void main(String [] args){
        System.out.println("We set all up");
        PillarsDemo pd = new PillarsDemo(19, "Undefined" , "Undefined");
        pd.setAge(19);
        System.out.println(pd.getAge());

        
    }


    
}


// we can use the builtin enviontment autocomplete to create similar setters if the number of setters are too high to do by hand
// why don't use constructors instead of or along with setter methods  
// we have to create an object for each constructor which is inefficient due to the fact that we have to allocate memory to each object
// setters can be called evry time they are intended to use but constructors are called only once
// we can set but updating will be a bottleneck if we are using constructors
// constructor overloading will be a bottleneck too
// can we use the similar names for more than one setter methods
//  

// what are the things that can't be done with setter methods in converse
// we use static setter methods to set those static attributes



/** 2. Getter methods
 * is used to get or return the data
 * 
 * public type getFieldName(){
 * return fieldName;
 * }
 * 
 * it does not take parameters as setters does
 * 
*/


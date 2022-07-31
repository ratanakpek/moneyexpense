package ratanak.pek.moneyexpense.cleancode.objectanddatastructure.lawofdemeter;

import org.junit.Test;

//https://www.geeksforgeeks.org/law-of-demeter-in-java-principle-of-least-knowledge/
public class LawDemeterTest {

    //Methods: Rules of Law of Demeter
    //
    //There are primarily 4 principles of the least knowledge in java as follows:
    //
    //1. Method M of an object O can invoke the method of O itself
    //2. Method M can call methods of any parameter P
    //3. Method M can call objects created within M
    //4. Method M in object O can invoke methods of any type of object that is a direct component of O

    //TODO Method encapsulated within a class can call other methods that are encapsulated in the same class.
    @Test
    public void firstLaw() {
        // Creating an object of above Helper class and
        // in the main() method
        Helper obj = new Helper();

        // Method M of an object O can invoke
        // the method of O itself
        obj.M();
    }

    //TODO Method M can use methods of object P if it is passed as an argument as object P will be local to the Method M.
    @Test
    public void secondLaw() {
        // Creating object of Human Class and Dog class
        // inside the main method
        Human h = new Human();
        Dog obj = new Dog();

        // Method M calling any parameter P
        // M-> method of Dog class
        // h-> Human class object
        obj.M(h);
    }

    //TODO If method M makes an object then it can use that object as the object is considered local to method M.
    @Test
    public void thirdLaw() {
        // Creating an object of Dog class
        // in the main() method
        Cat obj = new Cat();

        // Method M can call objects created
        // within M
        obj.M();
    }

    //TODO Method of a class can call methods of another class which are its instance variable.
    @Test
    public void fourLaw() {
        // Creating object of Dog class
        // in the main() method
        DogLaw obj = new DogLaw();

        obj.M();
    }
}

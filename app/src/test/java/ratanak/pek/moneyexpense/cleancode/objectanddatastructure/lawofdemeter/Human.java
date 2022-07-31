package ratanak.pek.moneyexpense.cleancode.objectanddatastructure.lawofdemeter;

public class Human{

    // Method of Human class
    public void speak() {

        // Print message whenever function is called
        System.out.println("Hello Dog");
    }
}

// Class 2
// Helper class
class Dog{

    // Method of Dog class
    public void M(Human P) {

        // We can call methods of object
        // passed in our parameter
        P.speak();

        // Print message whenever function is called
        System.out.println("Bark(_-_)");
    }
}
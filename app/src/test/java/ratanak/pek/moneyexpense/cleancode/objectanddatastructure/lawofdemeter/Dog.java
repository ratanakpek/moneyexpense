package ratanak.pek.moneyexpense.cleancode.objectanddatastructure.lawofdemeter;

// Class 2
// helper class
class DogLaw {

    // Instance Variable
    Human P;

    // Method of Dog class
    public void M() {

        // We can use P as it is an Instance Variable
        // of class dog
        P = new Human();

        // Calling speak() method over instance variable
        P.speak();

        // Method of Dog class
        System.out.println("Barks!");
    }
}


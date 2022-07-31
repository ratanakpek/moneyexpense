package ratanak.pek.moneyexpense.cleancode.objectanddatastructure.lawofdemeter;

public class Cat {
    // Method of Dog class
    public void M() {

        // We can use object P as it is local
        // to this method and satisfy 3rd law
        Human P = new Human();
        P.speak();

        // Print statement whenever the method is called
        System.out.println("Barks-_-");
    }
}

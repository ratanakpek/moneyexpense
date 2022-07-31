package ratanak.pek.moneyexpense.cleancode.objectanddatastructure.lawofdemeter;

public class Helper {

    // Method of this class
    void M() {
        // Print statement whenever method is called
        System.out.println("hello from M()");

        // 'this' keyword is valid as method named-
        // anotherMethod() is encapsulated in the same class
        this.anotherMethod();
    }

    // Method of this class
    private void anotherMethod() {
        // Print statement whenever method is called
        System.out.println(
                "I am anotherMethod() of same class");
    }
}
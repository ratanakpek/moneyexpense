package ratanak.pek.moneyexpense.generic;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

//https://www.youtube.com/watch?v=K1iu1kXkVoA
public class GenericDaeldungTest {

    @Test
    public void printTheList(){
        List<Integer> intList = new ArrayList<>();
        intList.add(3);
        printList(intList);
        // printListSpecific(intList);

        //using extend key -> is upper bound
        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Cat());
        printListSpecific(animalList);

        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat());
        printListSpecific(catList);

        //Using super key -> is lower bound
        List<ParentAnimal> parentAnimalList = new ArrayList<>();
        parentAnimalList.add(new Cat());
        printListSuper(parentAnimalList);

    }

    //Change <Object> to <?>
    private void printList(List<?> myList){
        System.out.println();
    }

    private void printListSpecific(List<? extends Animal> myList){
        System.out.println("Done");
    }

    private void printListSuper(List<? super Animal> myList){
        System.out.println("Done");
    }


    ///============================

    @Test
    public void printAnyThing() {
        shout("Ratanak", 1);
        shout(23, 2);
        shout(new Cat(), new Dog());
    }

    private <T, V> void shout(T thingToShout, V otherThingToShout) {
        System.out.print(thingToShout + " -> ");
        System.out.println(otherThingToShout);
    }

    ///============================

    @Test
    public void genericMethod() {
        // fromArrayToList(3);
    }

    public <T> List<T> fromArrayToList(T[] a) {
        return Arrays.stream(a).collect(Collectors.toList());
    }

    ///============================

    @Test
    public void handleGenericWithSpecificType() {
        //Bounded Generic
        //GenericPrinterSpecific<Double> gps = new GenericPrinterSpecific(2.3);
        GenericPrinterSpecific<Cat> gps = new GenericPrinterSpecific(new Cat());
        GenericPrinterSpecific<Dog> gpsDog = new GenericPrinterSpecific(new Cat());
        GenericPrinterSpecific<Animal> gpsAnimal = new GenericPrinterSpecific(new Animal());

        //T extend animal -> T is animal, so we can use their method of Animal
        gps.print();
    }


    @Test
    public void genericCanHoldEverything() {
        ArrayList<Object> catList = new ArrayList<>();
        catList.add(new Cat());
        catList.add(new Cat());
        catList.add(new Dog());
        catList.add(new Double(1.0));


        //print cat at 0 index
        System.out.println(catList.get(0));

        // cat can not cast to dog, so we hard to handle it
        Dog myDog = (Dog) catList.get(0);
        System.out.println(myDog);
    }

    ///============================

    @Test
    public void whyNeedGeneric() {
        List list = new LinkedList();
        list.add(new Integer(1));
        Integer i = (Integer) list.iterator().next();
        // Integer i = list.iterator().next();
    }

    @Test
    public void handleThingsToPrint() {

        //Without use generic, we duplicate many class
        IntegerPrinter ip = new IntegerPrinter(123);
        ip.print();

        DoublePrinter dp = new DoublePrinter(3.4);
        dp.print();

        StringPrinter sp = new StringPrinter("Hello, string printer");
        sp.print();


        //Using generic, we can create many type like Double, Car, String, Cat
        GenericPrinter<Integer> gp = new GenericPrinter(1);
        gp.print();

        GenericPrinter<Double> gdp = new GenericPrinter(1132);
        gdp.print();

        GenericPrinter<String> sdp = new GenericPrinter("I miss you like crazy!!!");
        sdp.print();


        Assert.assertEquals(true, true);
    }

}

///============================

class GenericPrinterSpecific<T extends Animal> {
    T thingToPrint;

    public GenericPrinterSpecific(T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        thingToPrint.eat();
        // System.out.println(thingToPrint);
    }
}

class GenericPrinter<T> {
    T thingToPrint;

    public GenericPrinter(T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        System.out.println(thingToPrint);
    }
}

class ParentAnimal{

}

class Animal extends ParentAnimal {
    String name;
    int age;

    public void eat() {
        System.out.println("general animal eat....");
    }
}

class Cat extends Animal {

}

class Dog extends Animal {

}

class IntegerPrinter {
    Integer thingToPrint;

    public IntegerPrinter(Integer thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        System.out.println(thingToPrint);
    }
}

class StringPrinter {
    String thingToPrint;

    public StringPrinter(String thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        System.out.println(thingToPrint);
    }
}

class DoublePrinter {
    Double thingToPrint;

    public DoublePrinter(Double thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        System.out.println(thingToPrint);
    }
}

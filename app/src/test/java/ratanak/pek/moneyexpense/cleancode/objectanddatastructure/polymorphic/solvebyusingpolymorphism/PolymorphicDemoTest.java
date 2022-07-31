package ratanak.pek.moneyexpense.cleancode.objectanddatastructure.polymorphic.solvebyusingpolymorphism;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PolymorphicDemoTest {

    @Test
    public void polymorphicTest() {
        Shape circle = new Circle(2);

        Shape rectangle = new Rectangle(2, 2);
        Shape square = new Square(2);

        List<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(rectangle);
        shapes.add(square);

        for (Shape shape : shapes) {
            System.out.println("Area : " + shape.area());
        }
    }
}

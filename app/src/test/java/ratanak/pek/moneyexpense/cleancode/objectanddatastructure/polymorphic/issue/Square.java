package ratanak.pek.moneyexpense.cleancode.objectanddatastructure.polymorphic.issue;

//If we add another shape, we must change code in Geometry
//so to solve this issue, we need to use polymophism
public class Square {
    public int topLeft;
    public double side;
}

class Rectangle {
    public int topLeft;
    public double height;
    public double width;
}

class Circle {
    public int center;
    public double radius;
}

class Geometry {
    public final double PI = 3.15;

    // here is the issue, if we want to add another shape, we have change code here
    public double area(Object shape) throws NoSuchShapeException {
        if (shape instanceof Square) {
            Square s = (Square) shape;
            return s.side * s.side;
        } else if (shape instanceof Rectangle) {
            Rectangle rec = (Rectangle) shape;
            return rec.height * rec.width;
        } else if (shape instanceof Circle) {
            Circle c = (Circle) shape;
            return PI * c.radius * c.radius;
        }
        throw new NoSuchShapeException();
    }
}

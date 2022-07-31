package ratanak.pek.moneyexpense.cleancode.objectanddatastructure.polymorphic.solvebyusingpolymorphism;

//There are 2 steps to rescue this issue:
//1. Use interface
//2. find base method or variable

//1. Use interface
public interface Shape {

    //2. find base method or variable
    double area();
}


class Rectangle implements Shape {
    private int topLeft;
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double area() {
        return height * width;
    }
}

class Square implements Shape {
    public int topLeft;
    public double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }
}

class Circle implements Shape {
    private int topLeft;
    private double radius;
    public final double PI = 3.15;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return PI * radius * radius;
    }
}


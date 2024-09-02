package calismasorulari.inheritance;

public class Triangle extends Shape {
    double side1, side2, side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double perimeter() {
        return side1 + side2 + side3;
    }

    public double area() {
        double u = perimeter() / 2.0;
        double heron = u * (u - side1) * (u - side2) * (u - side3);
        return Math.sqrt(heron);
    }
}

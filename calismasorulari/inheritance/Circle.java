package calismasorulari.inheritance;

public class Circle extends Shape {
    final double PI = 3.14159;
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return PI * radius * radius;
    }

    public double perimeter() {
        return 2 * PI * radius;
    }
}

package calismasorulari.inheritance;

public class Rectangle extends Shape {
    double longSide, shortSide;

    public Rectangle(double longSide, double shortSide) {
        this.longSide = longSide;
        this.shortSide = shortSide;
    }

    public double area() {
        return shortSide * longSide;
    }

    public double perimeter() {
        return (shortSide + longSide) * 2;
    }
}

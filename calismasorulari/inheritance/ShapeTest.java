package calismasorulari.inheritance;

public class ShapeTest {
    public static void main(String[] args) {
        Circle c = new Circle(3.0);
        Rectangle rec = new Rectangle(4.0, 2.0);
        Triangle tri = new Triangle(5.5, 2.0, 7.0);

        System.out.println("triangle's area and perimeter : " + tri.area() + " " + tri.perimeter());
        System.out.println("circle's area and perimeter : " + c.area() + " " + c.perimeter());
        System.out.println("rectangle's area and perimeter : " + rec.area() + " " + rec.perimeter());
    }
}

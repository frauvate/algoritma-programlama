/* Soru 2:
Java'da bir ComplexNumber (Karmaşık Sayı) sınıfı oluşturun. 
Bu sınıf, karmaşık sayılar için toplama, çıkarma, çarpma ve bölme işlemlerini gerçekleştiren 
yöntemler içermelidir. Ayrıca, karmaşık sayının büyüklüğünü (magnitude) hesaplayan bir 
yöntem ekleyin. Karmaşık sayılar şu şekilde temsil edilsin: a + bi, burada a ve b double türündedir.
*/

package calismasorulari.other;

public class Main6 {
    private double real;
    private double imaginary;

    public Main6(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Main6 conjugate() {
        return new Main6(this.real, -this.imaginary);
    }

    public static Main6 add(Main6 c1, Main6 c2) {
        return new Main6(c1.real+c2.real, c1.imaginary+c2.imaginary);
    }

    public static Main6 sub(Main6 c1, Main6 c2) {
        return new Main6(c1.real-c2.real, c1.imaginary-c2.imaginary);
    }

    public static Main6 multiply(Main6 c1, Main6 c2) {
        double newReal = c1.real * c2.real;
        double newImaginary = (c1.real * c2.imaginary) + (c1.imaginary * c2.real) + (c1.imaginary + c2.imaginary);
        return new Main6(newReal, newImaginary);
    }

    public static Main6 division(Main6 c1, Main6 c2) {
        double temp =c2.real * c2.real + c2.imaginary * c2.imaginary;
        double realPart = (c1.real * c2.real + c1.imaginary * c2.imaginary) / temp;
        double imaginaryPart = (c1.imaginary * c2.real - c1.real * c2.imaginary) / temp;
        return new Main6(realPart, imaginaryPart);
    }

    public String toString() {
        if (imaginary >= 0) {
            return real + " + " + imaginary + "i";
        } else {
            return real + " - " + (-imaginary) + "i";
        }
    }
}

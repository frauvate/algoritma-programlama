package sinavsorulari.classes;

public class ComplexNumber {
    private double real;  // Gerçek kısım
    private double imaginary;  // Sanal kısım

    // Yapıcı metot (constructor)
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Eşlenik metodu (Conjugate)
    public ComplexNumber conjugate() {
        return new ComplexNumber(this.real, -this.imaginary);
    }

    // Toplama metodu (Addition)
    public static ComplexNumber add(ComplexNumber c1, ComplexNumber c2) {
        return new ComplexNumber(c1.real + c2.real, c1.imaginary + c2.imaginary);
    }

    // Çıkarma metodu (Subtraction)
    public static ComplexNumber subtract(ComplexNumber c1, ComplexNumber c2) {
        return new ComplexNumber(c1.real - c2.real, c1.imaginary - c2.imaginary);
    }

    // Bölme metodu (Division)
    public static ComplexNumber divide(ComplexNumber c1, ComplexNumber c2) {
        double denominator = c2.real * c2.real + c2.imaginary * c2.imaginary;
        double realPart = (c1.real * c2.real + c1.imaginary * c2.imaginary) / denominator;
        double imaginaryPart = (c1.imaginary * c2.real - c1.real * c2.imaginary) / denominator;
        return new ComplexNumber(realPart, imaginaryPart);
    }

    // Karşılaştırma metodu (Comparison)
    public static boolean equals(ComplexNumber c1, ComplexNumber c2) {
        return c1.real == c2.real && c1.imaginary == c2.imaginary;
    }

    // Karmaşık sayıyı yazdırma metodu (toString)
    @Override
    public String toString() {
        if (imaginary >= 0) {
            return real + " + " + imaginary + "i";
        } else {
            return real + " - " + (-imaginary) + "i";
        }
    }

    // Main metodu, sınıfı test etmek için kullanılabilir
    public static void main(String[] args) {
        ComplexNumber c1 = new ComplexNumber(4, 5);
        ComplexNumber c2 = new ComplexNumber(3, -2);

        // Toplama
        ComplexNumber sum = ComplexNumber.add(c1, c2);
        System.out.println("Toplama: " + sum);

        // Çıkarma
        ComplexNumber difference = ComplexNumber.subtract(c1, c2);
        System.out.println("Çıkarma: " + difference);

        // Bölme
        ComplexNumber quotient = ComplexNumber.divide(c1, c2);
        System.out.println("Bölme: " + quotient);

        // Eşlenik
        ComplexNumber conjugate = c1.conjugate();
        System.out.println("Eşlenik: " + conjugate);

        // Karşılaştırma
        boolean isEqual = ComplexNumber.equals(c1, c2);
        System.out.println("Eşit mi? " + isEqual);
    }
}

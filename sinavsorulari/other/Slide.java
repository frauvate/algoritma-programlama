package sinavsorulari.other;

public class Slide {
    public static int donustur(int sayi, boolean yon, int adet) {
        if (yon) {
            // Sağa kaydırma işlemi
            return sayi >> adet;
        } else {
            // Sola kaydırma işlemi
            return sayi << adet;
        }
    }
    public static void main(String[] args) {
        System.out.println(donustur(7, false, 3));
    }
}

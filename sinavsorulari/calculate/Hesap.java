package sinavsorulari.calculate;

import java.lang.Math;

public class Hesap {
    // Hesap sınıfı için örnek bir katsayı tanımlayalım
    static double hesapKatsayi = 16;

    Hesap() {
        hesapKatsayi = hesapKatsayi * 4;
    }

    // Verilen sayının karesini hesaplayan metot
    public static int kareAl(int sayi) {
        return sayi * sayi;
    }

    // Verilen sayının küpünü hesaplayan metot
    public static int kupAl(int sayi) {
        return sayi * sayi * sayi;
    }

    // Verilen sayının karekökünü hesaplayan metot
    public static double karekokAl(double sayi) {
        return Math.sqrt(sayi);
    }
}

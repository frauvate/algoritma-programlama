package sinavsorulari.other;

import java.util.Scanner;
import java.util.InputMismatchException;

public class TestHata {
    public static void main(String[] args) {
        Scanner kullan = new Scanner(System.in);
        boolean devamMi;
        devamMi = true;
        do {
            try {
                System.out.print("bir double sayi giriniz:");
                double deger = kullan.nextDouble();
                System.out.println("girilen sayi"+deger+"dir");
                devamMi = false;
            }
            catch (InputMismatchException ex) {
                System.out.println("tekrar deneyin. gecersiz giris: bir double sayi gerekiyor");
                kullan.nextLine();
            }
        } while (devamMi);
        kullan.close();
    }
}


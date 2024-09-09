package sinavsorulari.circle;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestYakala {
    public static void main(String[] args) {
        Scanner kullan = new Scanner(System.in);

        boolean devam = true;

        do {
            try {
                System.out.print("cember yaricapini giriniz:");
                int capinyarisi = kullan.nextInt();
                CemberYakala cember1 = new CemberYakala(capinyarisi);
                System.out.println("cemberin alani: " + cember1.getHesap());
                devam = false;
            }
            catch (IllegalArgumentException istisna) {
                System.out.println("aciklama" + istisna);
                System.out.println("");
            }
            catch (InputMismatchException istisna2) {
                System.out.println("aciklama" + istisna2);
                System.out.println("");
                kullan.nextLine();
            }
        } while(devam);

        kullan.close();
    }
}

package sinavsorulari.other;

import java.util.Scanner;

public class Func {
    public static void main(String[] args) {
        Scanner gir = new Scanner(System.in);
        System.out.print("mesajinizi girin:");
        String mesaj = gir.nextLine();
        System.out.print("kac kez yazilacak:");
        int n = gir.nextInt();
        mesajYazdir(n, mesaj, "\n");
        gir.close();
    }

    public static void mesajYazdir(int sayac, String teks, String opt) {
        for(int i=0; i<sayac; i++) {
            System.out.println(teks + opt);
        }
    }
}
